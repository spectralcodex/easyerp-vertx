package io.vertx.easyerp.microservice.propertymanagement;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.easyerp.microservice.propertymanagement.jpojo.Accomodation;
import io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyAmenity;
import io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyProfile;

import java.util.List;

/**
 * A service interface managing Property.
 * <p>
 * This service is an event bus service (aka. service proxy)
 * </p>
 *
 * @author Spectral
 */
@VertxGen
@ProxyGen
public interface PropertyManagementService {
    /**
     * The name of the event bus service.
     */
    String SERVICE_NAME = "property_management-eb-service";

    /**
     * The address on which the service is published.
     */
    String SERVICE_ADDRESS = "service.property_management";

    //Property Management
    /**
     * @param  profile
     * @param resultHandler the result handler will be called as soon as the initialization has been accomplished.
     *                      The jooq.async result indicates whether the operation was successful or not.
     */

    @Fluent
    PropertyManagementService addProfile(PropertyProfile profile, Handler<AsyncResult<Integer>> resultHandler);

    /**
     * @param profile
     * @param resultHandler
     * @return
     */
    @Fluent
    PropertyManagementService createProfile(PropertyProfile profile, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    PropertyManagementService updateProfile(PropertyProfile profile, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    PropertyManagementService retrieveProfile(String serial, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    PropertyManagementService deleteProfile(String serial, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    PropertyManagementService retrieveAmenities(Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    PropertyManagementService addAmenity(PropertyAmenity amenity, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    PropertyManagementService deleteAmenity(String serial, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    PropertyManagementService addAccomodation(Accomodation accomodation, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    PropertyManagementService updateAccomodation(Accomodation accomodation, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    PropertyManagementService retrieveAllAccomodations(Handler<AsyncResult<List<JsonObject>>> resultHandler);

    @Fluent
    PropertyManagementService retrieveAccomodation(String serial, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    PropertyManagementService deleteAccomodation(String serial, Handler<AsyncResult<Integer>> resultHandler);

}
