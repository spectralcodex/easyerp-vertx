package io.vertx.easyerp.microservice.gateway;

import io.vertx.core.Promise;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.JksOptions;
import io.vertx.easyerp.microservice.common.RestAPIVerticle;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.auth.oauth2.OAuth2FlowType;
import io.vertx.ext.auth.oauth2.providers.KeycloakAuth;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.servicediscovery.Record;
import io.vertx.servicediscovery.ServiceDiscovery;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;


public class APIGatewayVerticle extends RestAPIVerticle {
    //private static final long SCAN_PERIOD = 20000L;
    //private final static InputStream CONFIG_IN = APIGatewayVerticle.class.getClassLoader().getResourceAsStream(PropertiesCache.getInstance().getProperty("local.config.file"));

    private static final int DEFAULT_PORT = 8787;

    private static final Logger logger = LoggerFactory.getLogger(APIGatewayVerticle.class);

    private OAuth2Auth oauth2;

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        super.start();

        //config().mergeIn(retrieveConfigurations().result());
        //retrieveConfigurations();

        logger.info("API config Ok ->" + config());

        // get HTTP host and port from configuration, or use default value
        String host = config().getString("api.gateway.http.address", "localhost");
        int port = config().getInteger("api.gateway.http.port", DEFAULT_PORT);

        Router router = enableRouteLoggingSupport(Router.router(vertx));

        // version handler
        router.get("/api/v").handler(this::apiVersion);

        oauth2 = KeycloakAuth.create(vertx, OAuth2FlowType.AUTH_CODE, config());

        enableLocalSession(router, oauth2);

        // api dispatcher
        router.route("/api/*").handler(this::dispatchRequests);

        //static content
        router.route("/*").handler(StaticHandler.create());

        String hostURI = buildHostURI();

        HttpServerOptions httpServerOptions = new HttpServerOptions()
                .setSsl(true).setKeyStoreOptions(new JksOptions()
                        .setPath("server-keystore.jks").setPassword("secret"));

        vertx.createHttpServer(httpServerOptions)
                .requestHandler(router)
                .listen(port, host, ar -> {
                    if(ar.succeeded()) {
                        publishApiGateway(host, port);

                        logger.info("API Gateway is running on port " + port);

                        // publish log
                        publishGatewayLog("api_gateway_init_success:" + port);
                    } else {
                        startPromise.fail(ar.cause());
                    }
                });
    }

    /*private Future<JsonObject> retrieveConfigurations() throws Exception {
        Promise<JsonObject> initConfigPromise = Promise.promise();

        //get environmental variables using the path provided
        configurationRetriever
                .usingScanPeriod(SCAN_PERIOD)
                .withJsonStore(CONFIG_IN)
                .createConfig(vertx)
                .onComplete(initConfigPromise);
        return initConfigPromise.future().map(conf -> config().mergeIn(conf));
    }*/

    private void apiVersion(RoutingContext context) {
        String res = new JsonObject()
                .put("type", "response")
                .put("service", "vertx-docker")
                .put("version", "v1").encode();
        logger.info("Response from postman echo: {}", res);
        context.response()
                .putHeader("Content-Type", "application/json")
                .end(res);

    }

    private String buildHostURI() {
        int port = config().getInteger("api.gateway.http.port", DEFAULT_PORT);
        final String host = config().getString("api.gateway.http.address.external", "localhost");
        return String.format("https://%s:%d", host, port);
    }

    /**
     * @param ctx routing context
     */
    private void dispatchRequests(RoutingContext ctx) {
        int initialOffset = 5; //length pf `/api/`

        //run circuit breaker in order to deal with failure
        circuitBreaker.execute(future -> getAllEndpoints().onComplete(ar -> {
            if (ar.failed())
                future.fail(ar.cause());
            else {
                List<Record> recordList = ar.result();

                // get relative path and retrieve prefix to dispatch client
                String path = ctx.request().uri();
                if (path.length() <= initialOffset) { //Api path starts with /api/
                    notFound(ctx);
                    future.complete();
                    return;
                }

                String prefix = path.substring(initialOffset).split("/")[0]; //what follows after api/*
                logger.info("API prefix::" + prefix);

                //generate relative path
                String newPath = path.substring(initialOffset + prefix.length());
                logger.info("New path::"+ newPath);

                //get one relevant HTTP client, may not exist
                Optional<Record> client = recordList.stream()
                        .filter(record -> record.getMetadata().getString("api.name") != null)
                        .filter(record -> record.getMetadata().getString("api.name").equals(prefix))
                        .findAny();

                if (client.isPresent()) {
                    doDispatch(ctx, newPath, discovery.getReference(client.get()).get(),future);
                } else {
                    notFound(ctx);
                    future.complete();
                }
            }
        })).onComplete(ar -> {
            if(ar.failed())
                badGateway(ar.cause(), ctx);
        });
    }

    /**
     * @param ctx
     * @param path
     * @param client
     * @param cbPromise
     */
    private void doDispatch(@NotNull RoutingContext ctx, String path,  HttpClient client, Promise<Object> cbPromise) {
        HttpClientRequest toReq = client.request(ctx.request().method(), path, resp ->
                resp.bodyHandler(body -> {
                    if (resp.statusCode() >= 500)
                        cbPromise.fail(resp.statusCode() + ":" + body.toString());
                    else {
                        HttpServerResponse toRsp = ctx.response().setStatusCode(resp.statusCode());
                        resp.headers().forEach(header -> toRsp.putHeader(header.getKey(), header.getValue()));
                        toRsp.end(body);
                        cbPromise.complete();
                    }
                    ServiceDiscovery.releaseServiceObject(discovery, client);
                }));
        ctx.request().headers().forEach(header ->
                toReq.putHeader(header.getKey(), header.getValue()));

        /* if(ctx.user() != null) request.putHeader("user-principal", ctx.user().principal().encode()); */

        if (ctx.getBody() == null) {
            toReq.end();
        } else {
            toReq.end(ctx.getBody());
        }
    }

    // log methods
    private void publishGatewayLog(String info) {
        JsonObject message = new JsonObject()
                .put("info", info)
                .put("time", System.currentTimeMillis());
        publishLogEvent("gateway", message);
    }

    private void publishGatewayLog(JsonObject msg) {
        JsonObject message = msg.copy()
                .put("time", System.currentTimeMillis());
        publishLogEvent("gateway", message);
    }

}