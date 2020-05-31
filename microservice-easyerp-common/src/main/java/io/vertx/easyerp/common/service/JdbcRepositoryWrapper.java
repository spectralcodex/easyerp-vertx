package io.vertx.easyerp.common.service;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
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

    protected final JDBCClient client;

    public JdbcRepositoryWrapper(Vertx vertx, JsonObject config) {
        this.client = JDBCClient.createNonShared(vertx, config);
    }

    /**
     * @param params
     * @param sql
     * @param resultHandler
     */
    protected void executeNoResult(JsonArray params, String sql, Handler<AsyncResult<Void>> resultHandler) {
        client.getConnection(connHandler(resultHandler, con -> {
            con.updateWithParams(sql, params, r -> {
                if (r.succeeded()) {
                    resultHandler.handle(Future.succeededFuture());
                } else {
                    resultHandler.handle(Future.failedFuture(r.cause()));
                }
                con.close();
            });
        }));
    }

    /**
     * @param params
     * @param sql
     * @param ret
     * @param resultHandler
     * @param <R>
     */
    protected <R> void execute(JsonArray params, String sql, R ret, Handler<AsyncResult<R>> resultHandler) {
        client.getConnection(connHandler(resultHandler, con -> {
            con.updateWithParams(sql, params, ar -> {
                if (ar.succeeded()) {
                    resultHandler.handle(Future.succeededFuture(ret));
                } else {
                    resultHandler.handle(Future.failedFuture(ar.cause()));
                }
                con.close();
            });
        }));
    }

    protected <K> Future<Optional<JsonObject>> retrieveOne(K param, String sql) {
        return getConnection()
                .compose(con -> {
                    Future<Optional<JsonObject>> future = Future.future();
                    con.queryWithParams(sql, new JsonArray().add(param), r -> {
                        if (r.succeeded()) {
                            List<JsonObject> resList = r.result().getRows();
                            if (resList == null || resList.isEmpty()) {
                                future.complete(Optional.empty());
                            } else {
                                future.complete(Optional.of(resList.get(0)));
                            }
                        } else {//hello
                            future.fail(r.cause());
                        }
                        con.close();
                    });
                    return future;
                });
    }

    protected Future<List<JsonObject>> retrieveMany(JsonArray param, String sql) {
        return getConnection().compose(con -> {
            Future<List<JsonObject>> future = Future.future();
            con.queryWithParams(sql, param, r -> {
                if (r.succeeded()) {
                    future.complete(r.result().getRows());
                } else {
                    future.fail(r.cause());
                }
                con.close();
            });
            return future;
        });
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
        Future<SQLConnection> future = Future.future();
        client.getConnection(future.completer());
        return future;
    }
}

