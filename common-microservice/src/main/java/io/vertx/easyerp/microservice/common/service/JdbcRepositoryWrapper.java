package io.vertx.easyerp.microservice.common.service;

import io.vertx.core.*;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.jdbc.JDBCClient;
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
    protected final JDBCClient client;

    public JdbcRepositoryWrapper(Vertx vertx, JsonObject config) {
        this.client = JDBCClient.create(vertx, config);
    }

    /**
     * @param params JsonArray containing query parameters
     * @param sql query
     * @param resultHandler results
     */
    protected void executeNoResult(JsonArray params, String sql, Handler<AsyncResult<Void>> resultHandler) {
        client.getConnection(connHandler(resultHandler, con ->
                con.updateWithParams(sql, params, r -> {
                    if (r.succeeded()) {
                        resultHandler.handle(Future.succeededFuture());
                    } else {
                        resultHandler.handle(Future.failedFuture(r.cause()));
                    }
                    con.close();
                })));
    }

    /**
     * @param params JsonArray containing query parameters
     * @param sql query
     * @param ret result passed
     * @param resultHandler handler
     * @param <R> Unknown Object
     */
    protected <R> void execute(JsonArray params, String sql, R ret, Handler<AsyncResult<R>> resultHandler) {
        client.getConnection(connHandler(resultHandler, con ->
            con.updateWithParams(sql, params, ar -> {
                if (ar.succeeded()) {
                    resultHandler.handle(Future.succeededFuture(ret));
                } else {
                    resultHandler.handle(Future.failedFuture(ar.cause()));
                }
                con.close();
        })));
    }


    protected <K> Future<Optional<JsonObject>> retrieveOne(K param, String sql) {
        return getConnection()
                .compose(con -> {
                    Promise<Optional<JsonObject>> promise = Promise.promise();

                    con.queryWithParams(sql, new JsonArray().add(param), r -> {
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
                        con.close();
                    });
                    return promise.future();
                });
    }

    /**
     * @param param
     * @param sql
     * @return
     */
    protected Future<List<JsonObject>> retrieveMany(JsonArray param, String sql) {
        return getConnection().compose(con -> {
            Promise<List<JsonObject>> promise = Promise.promise();
            con.queryWithParams(sql, param, r -> {
                if (r.succeeded()) {
                    promise.complete(r.result().getRows());
                } else {
                    promise.fail(r.cause());
                }
                con.close();
            });
            return promise.future();
        });
    }

    /**
     * @param sql
     * @return
     */
    protected Future<List<JsonObject>> retrieveAll(String sql) {
        return getConnection().compose(con -> {
            Promise<List<JsonObject>> promise = Promise.promise();
            con.query(sql, r -> {
                if (r.succeeded()) {
                    promise.complete(r.result().getRows());
                } else {
                    promise.fail(r.cause());
                }
                con.close();
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
        client.getConnection(connHandler(resultHandler, con -> {
            JsonArray params = new JsonArray().add(id);
            con.updateWithParams(sql, params, r -> {
                if(r.succeeded()){
                    resultHandler.handle(Future.succeededFuture());
                } else {
                    resultHandler.handle(Future.failedFuture(r.cause()));
                }
                con.close();
            });
        }));
    }

    /**
     * @param sql
     * @param resultHandler
     */
    protected void removeAll(String sql, Handler<AsyncResult<Void>> resultHandler) {
        client.getConnection(connHandler(resultHandler, connection -> {
            connection.update(sql, r -> {
                if (r.succeeded()) {
                    resultHandler.handle(Future.succeededFuture());
                } else {
                    resultHandler.handle(Future.failedFuture(r.cause()));
                }
                connection.close();
            });
        }));
    }

    /**
     * A helper methods that generates async handler for SQLConnection
     *
     * @return generated handler
     */
    protected <R> Handler<AsyncResult<SQLConnection>> connHandler(Handler<AsyncResult<R>> h1, Handler<SQLConnection> h2) {
        return conn -> {
            if (conn.succeeded()) {
                final SQLConnection connection = conn.result();
                h2.handle(connection);
            } else {
                h1.handle(Future.failedFuture(conn.cause()));
            }
        };
    }

    protected Future<SQLConnection> getConnection() {
        Promise<SQLConnection> promise = Promise.promise();
        /*client.getConnection(ar ->{
            if(ar.succeeded())
                promise.complete(ar.result());
            else
                logger.error("Database connection failed, cause is "+ar.cause());
                promise.fail(ar.cause());
        });*/

        client.getConnection(promise); //equivalent initial
        return promise.future();
    }
}

