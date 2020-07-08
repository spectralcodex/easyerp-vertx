package io.vertx.easyerp.microservice.common.service;

import io.vertx.core.*;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.SQLClient;
import io.vertx.ext.sql.SQLConnection;


import java.util.List;
import java.util.Optional;

/**
 * Helper and wrapper class for JDBC repository services ported from origional blueprint
 *
 * @author Rubicon
 */

public class JdbcRepositoryWrapper {
    private static final Logger logger = LoggerFactory.getLogger(JdbcRepositoryWrapper.class);
    protected final SQLClient client;

    //Using Postgres connection pooling
    /*protected final PgPool client;
    protected final PgConnectOptions connectOptions;
    protected final PoolOptions poolOptions;



    /*public JdbcRepositoryWrapper(Vertx vertx, JsonObject config) {
        connectOptions = new PgConnectOptions().setPort(5432)
                .setHost(config.getString("PGHOST", "the-host"))
                .setDatabase(config.getString("PGDATABASE", "the-db"))
                .setUser(config.getString("PGUSER", "user"))
                .setPassword(config.getString("PGPASSWORD", "secret"));

        poolOptions = new PoolOptions().setMaxSize(config.getInteger("PGMAXSIZE", 5));

        this.client = PgPool.pool(vertx, connectOptions, poolOptions);
    }*/

    public JdbcRepositoryWrapper(Vertx vertx, JsonObject config) {
        this.client = JDBCClient.create(vertx, config);
    }

    /**
     * @param params        JsonArray containing query parameters
     * @param sql           query
     * @param resultHandler results
     */
    protected void executeNoResult(JsonArray params, String sql, Handler<AsyncResult<Void>> resultHandler) {
        client.getConnection(connHandler(resultHandler, con ->
                con.callWithParams(sql, params, null, r -> { //if returns then fix return json array
                    if (r.succeeded()) {
                        resultHandler.handle(Future.succeededFuture());
                    } else {
                        resultHandler.handle(Future.failedFuture(r.cause()));
                    }
                    con.close();
                })));
    }

    /**
     * @param in            JsonArray containing in parameters
     * @param out           JsonArray containing out parameters
     * @param sql           query
     * @param resultHandler handler
     */
    protected void executeNoResult(JsonArray in, JsonArray out, String sql, Handler<AsyncResult<Void>> resultHandler) {
        client.getConnection(connHandler(resultHandler, con ->
                con.callWithParams(sql, in, out, ar -> {
                    if (ar.succeeded()) {
                        String err_msg = ar.result().getOutput().getString(0);
                        //logger.info("Result -->" + err_msg);
                        switch (err_msg) {
                            case "SUCCESS":
                                resultHandler.handle(Future.succeededFuture());
                                break;
                            default:
                                resultHandler.handle(Future.failedFuture(err_msg));
                        }
                    } else {
                        resultHandler.handle(Future.failedFuture(ar.cause()));
                    }
                    con.close();
                })));
    }

    /**
     * @param params        JsonArray containing query parameters
     * @param sql           query
     * @param ret           result passed
     * @param resultHandler handler
     * @param <R>           Unknown Object
     */
    protected <R> void execute(JsonArray params, String sql, R ret, Handler<AsyncResult<R>> resultHandler) {
        client.getConnection(connHandler(resultHandler, con ->
                con.callWithParams(sql, params, null, ar -> {
                    if (ar.succeeded()) {
                        resultHandler.handle(Future.succeededFuture(ret));
                    } else {
                        resultHandler.handle(Future.failedFuture(ar.cause()));
                    }
                    con.close();
                })));
    }

    /**
     * @param in            JsonArray containing in parameters
     * @param out           JsonArray containing out parameters
     * @param sql           query
     * @param ret           result passed
     * @param resultHandler handler
     * @param <R>           Unknown Object
     */
    protected <R> void execute(JsonArray in, JsonArray out, String sql, R ret, Handler<AsyncResult<R>> resultHandler) {
        client.getConnection(connHandler(resultHandler, con ->
                con.callWithParams(sql, in, out, ar -> {
                    if (ar.succeeded()) {
                        JsonArray res = ar.result().getOutput();

                        String err_msg = res.encode();
                        logger.info("Result-->" + res);
                        switch (err_msg) {
                            case "success":
                                resultHandler.handle(Future.succeededFuture(ret));
                                break;
                            default:
                                resultHandler.handle(Future.failedFuture(err_msg));
                        }

                    } else {
                        resultHandler.handle(Future.failedFuture(ar.cause()));
                    }
                    con.close();
                })));
    }


    /*protected <K> Future<Optional<JsonObject>> retrieveOne(K param, String sql) {
        return getConnection()
                .compose(pgCon -> {
                    Promise<Optional<JsonObject>> promise = Promise.promise();

                    pgCon.callWithParams(sql, new JsonArray().add(param), null, r -> {
                        if (r.succeeded()) {
                            List<JsonObject> resList = r.result().getRows();
                            if (resList == null || resList.isEmpty()) {
                                promise.complete(Optional.empty());
                            } else {
                                promise.complete(Optional.of(resList.get(0)));
                            }
                        } else {//hello
                            promise.fail(r.cause());
                        }
                        pgCon.close();
                    });
                    return promise.future();
                });
    }*/

    protected <K> Future<Optional<JsonObject>> retrieveOne(JsonArray in, JsonArray out, String sql) {
        return getConnection()
                .compose(pgCon -> {
                    Promise<Optional<JsonObject>> promise = Promise.promise();
                    pgCon.callWithParams(sql, in , out, r -> {
                        if (r.succeeded()) {
                            logger.info("RESULT --> "+r.result().getOutput());
                            List<JsonObject> resList = r.result().getRows();
                            if (resList == null || resList.isEmpty()) {
                                promise.complete(Optional.empty());
                            } else {
                                promise.complete(Optional.of(resList.get(0)));
                            }
                        } else {//hello
                            promise.fail(r.cause());
                        }
                        pgCon.close();
                    });
                    return promise.future();
                });
    }

    protected <T> Future<Void> retrieveNone(T t, String sql) {
        return getConnection()
                .compose(pgCon -> {
                    Promise<JsonObject> promise = Promise.promise();
                    pgCon.call(sql, ar -> {
                        if (ar.succeeded()) {
                            logger.info("persist OK  id --> " + t);
                            promise.complete();
                        } else {
                            promise.fail(ar.cause());
                        }
                        pgCon.close();
                    });
                    return promise.future().map(r -> null);
                });
    }

    /**
     * @param param Json array param
     * @param sql   callable statement of pgsql function
     * @return a list of json objects
     */
    protected Future<List<JsonObject>> retrieveMany(JsonArray param, String sql) {
        return getConnection().compose(pgCon -> {
            Promise<List<JsonObject>> promise = Promise.promise();
            //new JsonArray().add(t), new JsonArray().add("VARCHAR")
            pgCon.callWithParams(sql, param, null, r -> { //if call returns then must fix
                if (r.succeeded()) {
                    promise.complete(r.result().getRows());
                } else {
                    promise.fail(r.cause());
                }
                pgCon.close();
            });
            return promise.future();
        });
    }

    /**
     * @param sql
     * @return
     */
    protected Future<List<JsonObject>> retrieveAll(String sql) {
        return getConnection().compose(pgCon -> {
            Promise<List<JsonObject>> promise = Promise.promise();
            pgCon.call(sql, r -> {
                if (r.succeeded()) {
                    promise.complete(r.result().getRows());
                } else {
                    promise.fail(r.cause());
                }
                pgCon.close();
            });
            return promise.future();
        });
    }

    /**
     * @param id
     * @param sql
     * @param resultHandler
     * @param <K>
     */
    protected <K> void removeOne(K id, String sql, Handler<AsyncResult<Void>> resultHandler) {
        client.getConnection(connHandler(resultHandler, pgCon -> {
            JsonArray params = new JsonArray().add(id);
            pgCon.callWithParams(sql, params, null, r -> {
                if (r.succeeded()) {
                    resultHandler.handle(Future.succeededFuture());
                } else {
                    resultHandler.handle(Future.failedFuture(r.cause()));
                }
                pgCon.close();
            });
        }));
    }

    /**
     * @param sql
     * @param resultHandler
     */
    protected void removeAll(String sql, Handler<AsyncResult<Void>> resultHandler) {
        client.getConnection(connHandler(resultHandler, pgCon -> {
            pgCon.call(sql, r -> {
                if (r.succeeded()) {
                    resultHandler.handle(Future.succeededFuture());
                } else {
                    resultHandler.handle(Future.failedFuture(r.cause()));
                }
                pgCon.close();
            });
        }));
    }

    /**
     * A helper methods that generates async handler for SQLConnection
     *
     * @return generated handler
     */
    protected <R> Handler<AsyncResult<SQLConnection>> connHandler(Handler<AsyncResult<R>> h1, Handler<SQLConnection> h2) {
        return pgCon -> {
            if (pgCon.succeeded()) {
                final SQLConnection connection = pgCon.result();
                h2.handle(connection);
            } else {
                h1.handle(Future.failedFuture(pgCon.cause()));
            }
        };
    }


    protected Future<SQLConnection> getConnection() {
        Promise<SQLConnection> promise = Promise.promise();
        this.client.getConnection(promise); //equivalent initial
        return promise.future();
    }


}

