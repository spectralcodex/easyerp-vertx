package io.vertx.easyerp.microservice.propertymanagement;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.easyerp.microservice.propertymanagement.jpojo.Accommodation;
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
    PropertyManagementService createProfile(PropertyProfile profile, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    PropertyManagementService initializeProfile(PropertyProfile profile, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    PropertyManagementService updateProfile(PropertyProfile profile, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    PropertyManagementService retrieveProfile(String serial, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    PropertyManagementService deleteProfile(String serial, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    PropertyManagementService retrieveAmenities(Handler<AsyncResult<List<JsonObject>>> resultHandler);

    @Fluent
    PropertyManagementService createAmenity(PropertyAmenity amenity, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    PropertyManagementService deleteAmenity(String serial, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    PropertyManagementService createAccommodation(Accommodation accommodation, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    PropertyManagementService updateAccommodation(Accommodation accommodation, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    PropertyManagementService retrieveAllAccommodations(Handler<AsyncResult<List<JsonObject>>> resultHandler);

    @Fluent
    PropertyManagementService retrieveAccommodation(String serial, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    PropertyManagementService deleteAccommodation(String serial, Handler<AsyncResult<Integer>> resultHandler);

}
