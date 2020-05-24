package io.vertx.easyerp.common.service;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.SQLConnection;

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
        client.getConnection(connHandler(resultHandler, connection -> {
            connection.updateWithParams(sql, params, r -> {
                if (r.succeeded()) {
                    resultHandler.handle(Future.succeededFuture());
                } else {//hello malcador
                    resultHandler.handle(Future.failedFuture(r.cause()));
                }
                connection.close();
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
}

