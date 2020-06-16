package io.vertx.easyerp.microservice.administration.impl;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.easyerp.microservice.administration.AdministrationService;
import io.vertx.easyerp.microservice.administration.jpojo.User;
import io.vertx.easyerp.microservice.common.service.JdbcRepositoryWrapper;

public class AdministrationImpl extends JdbcRepositoryWrapper implements AdministrationService {

    public AdministrationImpl(Vertx vertx, JsonObject config) {
        super(vertx, config);
    }

    @Override
    public AdministrationService initializePersistence(Handler<AsyncResult<Void>> resultHandler) {
        return null;
    }

    //User operations
    @Override
    public AdministrationService addUser(User user, Handler<AsyncResult<User>> resultHandler) {
        return null;
    }

    @Override
    public AdministrationService retrieveUser(String userId, Handler<AsyncResult<User>> resultHandler) {
        return null;
    }
}
