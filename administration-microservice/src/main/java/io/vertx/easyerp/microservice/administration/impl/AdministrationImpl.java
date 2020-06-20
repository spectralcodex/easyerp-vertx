package io.vertx.easyerp.microservice.administration.impl;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.easyerp.microservice.administration.AdministrationService;
import io.vertx.easyerp.microservice.administration.jpojo.User;
import io.vertx.easyerp.microservice.common.service.JdbcRepositoryWrapper;

import java.sql.ResultSet;

public class AdministrationImpl extends JdbcRepositoryWrapper implements AdministrationService {
    protected final static Logger logger = LoggerFactory.getLogger(AdministrationImpl.class);

    public AdministrationImpl(Vertx vertx, JsonObject config) {
        super(vertx, config);
    }

    @Override
    public AdministrationService initializePersistence(Handler<AsyncResult<Void>> rhandler) {
        client.getConnection(connHandler(rhandler, pgConn -> {
            pgConn.execute("SELECT CURRENT_TIMESTAMP", rhandler);
        }));
        return this;
    }

    @Override
    public AdministrationService addUser(User user, Handler<AsyncResult<User>> resultHandler) {
        return null;
    }

    @Override
    public AdministrationService retrieveUser(String userId, Handler<AsyncResult<User>> resultHandler) {
        return null;
    }
}
