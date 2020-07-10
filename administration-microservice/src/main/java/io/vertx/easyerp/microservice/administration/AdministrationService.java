package io.vertx.easyerp.microservice.administration;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.easyerp.microservice.administration.jpojo.User;

/**
 * A service interface managing Users.
 * <p>
 * This service is an event bus service (aka. service proxy)
 * </p>
 *
 * @author Spectral
 */
@VertxGen
@ProxyGen
public interface AdministrationService{
    /**
     * The name of the event bus service.
     */
    String SERVICE_NAME = "administration-eb-service";

    /**
     * The address on which the service is published.
     */
    String SERVICE_ADDRESS = "service.administration";


    //User operations

    /**
     * @param resultHandler the result handler will be called as soon as the initialization has been accomplished.
     *                      The jooq.async result indicates whether the operation was successful or not.
     *
     *
     */
    @Fluent
    AdministrationService initializePersistence(Handler<AsyncResult<Void>> resultHandler);


    /**
     * Add a User to the persistence.
     *
     * @param user       a  User entity that we want to add
     * @param resultHandler the result handler will be called as soon as the User has been added. The jooq.async result
     *                      indicates whether the operation was successful or not.
     */
    @Fluent
    AdministrationService addUser(User user, Handler<AsyncResult<Integer>> resultHandler);

   // @Fluent
    //AdministrationService retrieveUser(String userId, Handler<AsyncResult<User>> resultHandler);

    @Fluent
    AdministrationService retrieveUser(String userId, Handler<AsyncResult<JsonObject>> resultHandler);



}
