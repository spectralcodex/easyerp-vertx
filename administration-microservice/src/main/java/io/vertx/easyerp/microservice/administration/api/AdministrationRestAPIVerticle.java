package io.vertx.easyerp.microservice.administration.api;


import io.vertx.core.Promise;
import io.vertx.core.json.DecodeException;
import io.vertx.core.json.JsonObject;
import io.vertx.easyerp.microservice.administration.AdministrationService;
import io.vertx.easyerp.microservice.administration.jpojo.User;
import io.vertx.easyerp.microservice.common.RestAPIVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdministrationRestAPIVerticle extends RestAPIVerticle {
    public static final String SERVICE_NAME = "administration-rest-api";
    private static final String API_ADD_USER = "/add";
    private static final String API_RETRIEVE_ALL_USER = "/users";
    private static final String API_RETRIEVE_USER = "/:userId";
    private static final String API_UPDATE_USER = "/:userId";
    private static final String API_DELETE_USER = "/userId";
    private static final String API_DELETE_ALL_USER = "/all";
    protected final static Logger logger = LoggerFactory.getLogger(AdministrationRestAPIVerticle.class);

    private final AdministrationService service;

    public AdministrationRestAPIVerticle(AdministrationService service) {
        this.service = service;
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        super.start();

        final Router router = enableRouteLoggingSupport(Router.router(vertx));

        router.post(API_ADD_USER).handler(this::apiAddUser);
        router.get(API_RETRIEVE_USER).handler(this::apiRetrieveUser);
        /*
        router.get(API_RETRIEVE_ALL_USER).handler(this::apiRetrieveUser);
        router.patch(API_UPDATE_USER).handler(this::apiRetrieveUser);
        router.delete(API_DELETE_USER).handler(this::apiRetrieveUser);
        router.delete(API_DELETE_ALL_USER).handler(this::apiRetrieveUser);
        */

        String host = config().getString("administration.http.address", "0.0.0.0");
        int port = config().getInteger("administration.http.port", 8082);

        createHttpServer(router, host, port)
                .compose(serverCreated -> publishHttpEndpoint(SERVICE_NAME, host, port))
                .onComplete(startPromise);
    }

    private void apiAddUser(RoutingContext context) {
        try {
            logger.info("{}", context.getBodyAsJson());
            User user = new User(context.getBodyAsJson());
            service.addUser(user, resultHandler(context, r -> {
                String result = new JsonObject().put("message", "user_added").encodePrettily();
                context.response().setStatusCode(201)
                        .putHeader("content-type", "application/json")
                        .end(result);
            }));
        } catch (DecodeException e) {
            badRequest(context, e);
        }
    }

    private void apiRetrieveUser(RoutingContext context) {
        String userId = context.request().getParam("userId");
        logger.info("finding--> {}", userId);
        service.retrieveUser(userId, resultHandlerNonEmpty(context));
    }
}
