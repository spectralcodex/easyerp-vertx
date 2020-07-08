package io.vertx.easyerp.microservice.administration.impl;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.easyerp.microservice.administration.AdministrationService;
import io.vertx.easyerp.microservice.administration.jpojo.User;
import io.vertx.easyerp.microservice.common.service.JooqRepositoryWrapper;

import java.util.UUID;


public class AdministrationImpl extends JooqRepositoryWrapper implements AdministrationService {

    protected final static Logger logger = LoggerFactory.getLogger(AdministrationImpl.class);

    public AdministrationImpl(Vertx vertx, JsonObject config) {
        super(vertx, config);
    }

    @Override
    public AdministrationService initializePersistence(Handler<AsyncResult<Void>> handler) {
        final String uuid = UUID.randomUUID().toString();
        //logger.info("Initializing service..Administration->" + uuid);
        this.retrieveNone(uuid, "select fn_get_now()")
                .onComplete(handler);
        return this;
    }

    @Override
    public AdministrationService addUser(User user, Handler<AsyncResult<Void>> resultHandler) {
        return null;
    }

    @Override
    public AdministrationService retrieveUser(String userId, Handler<AsyncResult<User>> resultHandler) {
        return null;
    }


}
