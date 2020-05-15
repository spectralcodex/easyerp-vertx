package io.vertx.easyerp.common.service;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;

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

    protected  void executeNoResult(JsonArray params, String sql, Handler<AsyncResult<Void>> resultHandler){

    }

    protected  <R> void execute(JsonArray params, String sql, R ret, Handler<AsyncResult<R>> resultHandler){

    }

}
