package io.vertx.easyerp.microservice.common.config;


import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;

import io.vertx.ext.auth.VertxContextPRNG;
import io.vertx.ext.auth.jdbc.JDBCAuth;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthProviderHelper {
    private  final JDBCAuth auth;
    private final static Logger logger = LoggerFactory.getLogger(AuthProviderHelper.class);

    public AuthProviderHelper(Vertx vertx){
        auth = JDBCAuth.create(vertx, null);
        auth.setNonces(new JsonArray().add(VertxContextPRNG.current().nextString(32)));//generate random nonce
    }

    public  String generateSalt(){
        final String salt = auth.generateSalt();
        return salt;
    }

    public  String computeHash(String password, String password_salt){
        final String hash = auth.computeHash(password, password_salt, 1);
        return hash;
    }

    public String generatingRandomAlphanumeric() {
        final String generatedPassword = RandomStringUtils.randomAlphanumeric(7);
        logger.info("RANDOM generated password --> " + generatedPassword);
      return generatedPassword;
    }
}
