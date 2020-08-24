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
import io.vertx.easyerp.microservice.common.config.AuthProviderHelper;
import io.vertx.easyerp.microservice.common.service.JooqRepositoryWrapper;

import static jooq.Tables.*;

import java.util.UUID;


public class AdministrationImpl extends JooqRepositoryWrapper implements AdministrationService {

    //protected final static Logger logger = LoggerFactory.getLogger(AdministrationImpl.class);
    private AuthProviderHelper authProviderHelper;

    public AdministrationImpl(Vertx vertx, JsonObject config) {
        super(vertx, config);
        authProviderHelper = new AuthProviderHelper(vertx);
    }

    @Override
    public AdministrationService initializePersistence(Handler<AsyncResult<Void>> handler) {
        final String uuid = UUID.randomUUID().toString();
        this.retrieveNone(uuid, "select fn_get_now()")
                .onComplete(handler);
        return this;
    }

    @Override
    public AdministrationService addUser(User user, Handler<AsyncResult<Integer>> resultHandler) {
        final String salt = authProviderHelper.generateSalt();
        final String generatedPassword = authProviderHelper.generatingRandomAlphanumeric();
        final String hash_password = authProviderHelper.computeHash(generatedPassword, salt);

        executor.execute(dsl -> dsl.insertInto(TB_USER,
                TB_USER.FIRSTNAME, TB_USER.LASTNAME, TB_USER.EMAIL, TB_USER.MOBILE, TB_USER.HASHEDPASSWORD,
                TB_USER.PASSWORDSALT, TB_USER.COMPANYCODE, TB_USER.CREATEDBY)
                .values(user.getFirstName(), user.getLastName(), user.getEmail(), user.getMobile(),
                        hash_password, salt, user.getCompanyCode(), user.getCreatedBy()))
                .onComplete(resultHandler);
        return this;
    }




    @Override
    public AdministrationService retrieveUser(String userId, Handler<AsyncResult<JsonObject>> resultHandler) {
        executor.findOneJson(dsl -> dsl.selectFrom(TB_USER).where(TB_USER.ID.eq(Long.valueOf(userId))))
                .onComplete(resultHandler);
        return this;
    }


}
