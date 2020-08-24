package io.vertx.easyerp.microservice.common.service;

import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.asyncsql.PostgreSQLClient;
import io.vertx.ext.sql.SQLConnection;
import jooq.async.AsyncClassicGenericQueryExecutor;
import jooq.async.AsyncClassicQueryExecutor;
import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper and wrapper class for Jooq repository services
 *
 * @author Rubicon
 */

public class JooqRepositoryWrapper {
    private static final Logger logger = LoggerFactory.getLogger(JooqRepositoryWrapper.class);
    protected final  AsyncClassicGenericQueryExecutor executor;
    private final AsyncSQLClient nonShared;
    private final static Configuration DIALECT = new DefaultConfiguration().set(SQLDialect.POSTGRES);



    public JooqRepositoryWrapper(Vertx vertx, JsonObject config){
        this.nonShared = PostgreSQLClient.createNonShared(vertx, config);
        this.executor = new AsyncClassicGenericQueryExecutor(DIALECT, this.nonShared);

        //this.dsl = DSL.using(dialect);
    }

    protected <T> Future<Void> retrieveNone(T t, String sql) {
        return getConnection()
                .compose(pgCon -> {
                    Promise<JsonObject> promise = Promise.promise();
                    pgCon.execute(sql, ar -> {
                        if (ar.succeeded()) {
                            logger.info("Persist OK --> id:" + t);
                            promise.complete();
                        } else {
                            promise.fail(ar.cause());
                        }
                        pgCon.close();
                    });
                    return promise.future().map(r -> null);
                });
    }

    protected Future<SQLConnection> getConnection() {
        Promise<SQLConnection> promise = Promise.promise();
        this.nonShared.getConnection(promise);
        return promise.future();
    }

    protected AsyncClassicGenericQueryExecutor queryExecutor(){
        return this.executor;
    }

}
