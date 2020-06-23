package io.vertx.easyerp.microservice.administration.impl;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.easyerp.microservice.administration.AdministrationService;
import io.vertx.easyerp.microservice.administration.jpojo.User;
import io.vertx.easyerp.microservice.common.service.JdbcRepositoryWrapper;


public class AdministrationImpl extends JdbcRepositoryWrapper implements AdministrationService {

    protected final static Logger logger = LoggerFactory.getLogger(AdministrationImpl.class);

    public AdministrationImpl(Vertx vertx, JsonObject config) {
        super(vertx, config);
    }

    @Override
    public AdministrationService initializePersistence(Handler<AsyncResult<Void>> handler) {
        client.getConnection(connHandler(handler, pgConn -> {
            logger.info("Initializing persistence....!!");
            pgConn.execute("SELECT CURRENT_TIMESTAMP", handler);
        }));
        return this;
    }

    @Override
    public AdministrationService addUser(User user, Handler<AsyncResult<Void>> resultHandler) {
        JsonArray param = new JsonArray();
        String func = "{ call add_user() }";
        param.add(user.getId());
        param.add(user.getFirstName());
        param.add(user.getLastName());
        param.add(user.getAge());
        this.executeNoResult(param, func, resultHandler);
        return this;
    }

    @Override
    public AdministrationService retrieveUser(String userId, Handler<AsyncResult<User>> resultHandler) {
        String func = "{ call get_user(?) }";
        this.retrieveOne(userId, func)
                .map(option -> option.map(User::new).orElse(null))
                .onComplete(resultHandler);
        return this;
    }
}
