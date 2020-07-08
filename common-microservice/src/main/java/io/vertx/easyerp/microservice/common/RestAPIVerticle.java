package io.vertx.easyerp.microservice.common;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Promise;
//import io.vertx.core.http.CookieSameSite;
//import io.vertx.core.http.CookieSameSite;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.CorsHandler;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.sstore.ClusteredSessionStore;
import io.vertx.ext.web.sstore.LocalSessionStore;
import io.vertx.rxjava.ext.web.handler.CookieHandler;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;


public class RestAPIVerticle extends BaseMicroserviceVerticle {
    private static final Logger logger = LoggerFactory.getLogger(RestAPIVerticle.class);

    /**
     * @param router microservice router
     * @param host   http host
     * @param port   http port
     * @return async result
     */
    protected Future<Void> createHttpServer(Router router, String host, int port) {
        Promise<HttpServer> httpServerPromise = Promise.promise();
        vertx.createHttpServer()
                .requestHandler(router)
                .listen(port, host, httpServerPromise);
        return httpServerPromise.future().map(r -> null);
    }

    /**
     * @param router router instance
     */
    protected void enableCorsSupport(Router router) {
        Set<String> allowHeaders = new HashSet<>();
        allowHeaders.add("x-requested-with");
        allowHeaders.add("Access-Control-Allow-Origin");
        allowHeaders.add("origin");
        allowHeaders.add("Content-Type");
        allowHeaders.add("accept");

        Set<HttpMethod> allowMethods = new HashSet<>();
        allowMethods.add(HttpMethod.GET);
        allowMethods.add(HttpMethod.PUT);
        allowMethods.add(HttpMethod.OPTIONS);
        allowMethods.add(HttpMethod.POST);
        allowMethods.add(HttpMethod.DELETE);
        allowMethods.add(HttpMethod.PATCH);

        router.route().handler(CorsHandler.create("*")
                .allowedHeaders(allowHeaders)
                .allowedMethods(allowMethods));
    }

    /**
     * Enable local session support for session storage
     *
     * @param router router instance
     */
    protected void enableLocalSession(Router router) {
        //router.route().handler(CookieHandler.create()); //deprecated
        router.route().handler(SessionHandler.create(
                LocalSessionStore.create(vertx, "erp.user.session"))
                //.setCookieSameSite(CookieSameSite.STRICT)
                .setCookieSecureFlag(true));
    }

    /**
     * Enable clustered session support for session storage
     *
     * @param router Clustered session store
     */
    protected void enableClusteredSession(Router router) {
        //router.route().handler(CookieHandler.create()); deprecated
        router.route().handler(SessionHandler.create(ClusteredSessionStore.create(vertx))
                //.setCookieSameSite(CookieSameSite.STRICT)
                .setCookieSecureFlag(true));
    }

    /**
     * Used to validate user login process
     *
     * @param context    routing context from rest
     * @param biConsumer be able to get both results together
     */
    protected void requireLogin(RoutingContext context, BiConsumer<RoutingContext, JsonObject> biConsumer) {
        Optional<JsonObject> principal = Optional.ofNullable(context.request().getHeader("user-principal"))
                .map(JsonObject::new);
        if (principal.isPresent()) {
            biConsumer.accept(context, principal.get());
        } else {
            context.response()
                    .setStatusCode(401)
                    .end(new JsonObject().put("message", "need_auth").encode());
        }
    }

    //Helper methods for REST API {PUT,GET,POST} calls

    protected <T> Handler<AsyncResult<T>> resultHandler(RoutingContext context, Handler<T> handler) {
        return ar -> {
            if (ar.succeeded()) {
                handler.handle(ar.result());
            } else {
                //logger.error(ar.cause());
                internalError(context, ar.cause());
                ar.cause().printStackTrace();
            }
        };
    }

    protected <T> Handler<AsyncResult<T>> resultHandler(RoutingContext context) {
        return ar -> {
            if (ar.succeeded()) {
                T res = ar.result();
                context.response().putHeader("Content-type", "application/json")
                        .end(res == null ? "{}" : res.toString());
            }
        };
    }

    protected <T> Handler<AsyncResult<T>> resultHandler(RoutingContext context, Function<T, String> converter) {
        return ar -> {
            if (ar.succeeded()) {
                T res = ar.result();
                if (res == null) {
                    serviceUnavailable(context, "invalid_result");
                } else {
                    context.response()
                            .putHeader("content-type", "application/json")
                            .end(converter.apply(res));
                }
            } else {
                //logger.error(ar.cause());
                internalError(context, ar.cause());
                ar.cause().printStackTrace();

            }
        };
    }

    protected <T> Handler<AsyncResult<T>> resultHandlerNonEmpty(RoutingContext context, Function<T, String> converter) {
        return ar -> {
            if (ar.succeeded()) {
                T res = ar.result();
                if (res == null) {
                    notFound(context);
                } else {
                    context.response()
                            .putHeader("content-type", "application/json")
                            .end(converter.apply(res));
                }
            } else {
                //logger.error(ar.cause());
                internalError(context, ar.cause());
                ar.cause().printStackTrace();

            }
        };
    }

    protected <T> Handler<AsyncResult<T>> resultHandlerNonEmpty(RoutingContext context) {
        return ar -> {
            if (ar.succeeded()) {
                T res = ar.result();
                if (res == null) {
                    notFound(context);
                } else {
                    context.response()
                            .putHeader("content-type", "application/json")
                            .end(res.toString());
                }
            } else {
                //logger.error(ar.cause());
                internalError(context, ar.cause());
                ar.cause().printStackTrace();
            }
        };
    }

    protected <T> Handler<AsyncResult<T>> rawResultHandler(RoutingContext context) {
        return ar -> {
            if (ar.succeeded()) {
                T res = ar.result();
                context.response()
                        .end(res == null ? "" : res.toString());
            } else {
                internalError(context, ar.cause());
                ar.cause().printStackTrace();
            }
        };
    }

    /**
     * This method generates handler for async methods in REST APIs.
     * The result is not needed. Only the state of the async result is required.
     *
     * @param context routing context instance
     * @param result  result content
     * @param status  status code
     * @return generated handler
     */
    protected Handler<AsyncResult<Void>> resultVoidHandler(RoutingContext context, JsonObject result, int status) {
        return ar -> {
            if (ar.succeeded()) {
                context.response()
                        .setStatusCode(status == 0 ? 200 : status)
                        .putHeader("content-type", "application/json")
                        .end(result.encodePrettily());
            } else {
                internalError(context, ar.cause());
                ar.cause().printStackTrace();
            }
        };
    }

    protected Handler<AsyncResult<Void>> resultVoidHandler(RoutingContext context, int status) {
        return ar -> {
            if (ar.succeeded()) {
                context.response()
                        .setStatusCode(status == 0 ? 200 : status)
                        .putHeader("content-type", "application/json")
                        .end();
            } else {
                internalError(context, ar.cause());
                ar.cause().printStackTrace();
            }
        };
    }

    //Methods for REST DELETE API calls

    /**
     * This method generates handler for async methods in REST DELETE APIs.
     * Return format in JSON (successful status = 204):
     * <code>
     * {"message": "delete_success"}
     * </code>
     *
     * @param context routing context instance
     * @return generated handler
     */
    protected Handler<AsyncResult<Void>> deleteResultHandler(RoutingContext context) {
        return res -> {
            if (res.succeeded()) {
                context.response().setStatusCode(204)
                        .putHeader("content-type", "application/json")
                        .end(new JsonObject().put("message", "delete_success").encodePrettily());
            } else {
                internalError(context, res.cause());
                res.cause().printStackTrace();
            }
        };
    }

    // helper method dealing with failure

    protected void internalError(RoutingContext context, Throwable ex) {
        context.response().setStatusCode(500)
                .putHeader("content-type", "application/json")
                .end(new JsonObject().put("error", ex.getMessage()).encodePrettily());
    }

    protected void notImplemented(RoutingContext context) {
        context.response().setStatusCode(501)
                .putHeader("content-type", "application/json")
                .end(new JsonObject().put("message", "not_implemented").encodePrettily());
    }

    protected void badGateway(Throwable ex, RoutingContext context) {
        ex.printStackTrace();
        context.response()
                .setStatusCode(502)
                .putHeader("content-type", "application/json")
                .end(new JsonObject().put("error", "bad_gateway")
                        //.put("message", ex.getMessage())
                        .encodePrettily());
    }

    protected void serviceUnavailable(RoutingContext context) {
        context.fail(503);
    }

    protected void serviceUnavailable(RoutingContext context, Throwable ex) {
        context.response().setStatusCode(503)
                .putHeader("content-type", "application/json")
                .end(new JsonObject().put("error", ex.getMessage()).encodePrettily());
    }

    protected void serviceUnavailable(RoutingContext context, String cause) {
        context.response().setStatusCode(503)
                .putHeader("content-type", "application/json")
                .end(new JsonObject().put("error", cause).encodePrettily());
    }

    protected void badRequest(RoutingContext context, Throwable ex) {
        context.response().setStatusCode(400)
                .putHeader("content-type", "application/json")
                .end(new JsonObject().put("error", ex.getMessage()).encodePrettily());
    }

    protected void notFound(RoutingContext context) {
        context.response().setStatusCode(404)
                .putHeader("content-type", "application/json")
                .end(new JsonObject().put("message", "not_found").encodePrettily());
    }
}
