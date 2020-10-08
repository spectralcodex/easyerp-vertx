package io.vertx.easyerp.microservice.propertymanagement.impl;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.easyerp.microservice.common.service.JooqRepositoryWrapper;
import io.vertx.easyerp.microservice.propertymanagement.PropertyManagementService;
import io.vertx.easyerp.microservice.propertymanagement.jpojo.Accomodation;
import io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyAmenity;
import io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyProfile;

import java.util.List;

public class PropertyManagementImpl extends JooqRepositoryWrapper implements PropertyManagementService {

    public PropertyManagementImpl(Vertx vertx, JsonObject config) {
        super(vertx, config);
    }

    @Override
    public PropertyManagementService addProfile(PropertyProfile profile, Handler<AsyncResult<Integer>> resultHandler) {
        return null;
    }

    @Override
    public PropertyManagementService createProfile(PropertyProfile profile, Handler<AsyncResult<Integer>> resultHandler) {
        return null;
    }

    @Override
    public PropertyManagementService updateProfile(PropertyProfile profile, Handler<AsyncResult<Integer>> resultHandler) {
        return null;
    }

    @Override
    public PropertyManagementService retrieveProfile(String serial, Handler<AsyncResult<JsonObject>> resultHandler) {
        return null;
    }

    @Override
    public PropertyManagementService deleteProfile(String serial, Handler<AsyncResult<Integer>> resultHandler) {
        return null;
    }

    @Override
    public PropertyManagementService retrieveAmenities(Handler<AsyncResult<JsonObject>> resultHandler) {
        return null;
    }

    @Override
    public PropertyManagementService addAmenity(PropertyAmenity amenity, Handler<AsyncResult<Integer>> resultHandler) {
        return null;
    }

    @Override
    public PropertyManagementService deleteAmenity(String serial, Handler<AsyncResult<Integer>> resultHandler) {
        return null;
    }

    @Override
    public PropertyManagementService addAccomodation(Accomodation accomodation, Handler<AsyncResult<Integer>> resultHandler) {
        return null;
    }

    @Override
    public PropertyManagementService updateAccomodation(Accomodation accomodation, Handler<AsyncResult<Integer>> resultHandler) {
        return null;
    }

    @Override
    public PropertyManagementService retrieveAllAccomodations(Handler<AsyncResult<List<JsonObject>>> resultHandler) {
        return null;
    }

    @Override
    public PropertyManagementService retrieveAccomodation(String serial, Handler<AsyncResult<JsonObject>> resultHandler) {
        return null;
    }

    @Override
    public PropertyManagementService deleteAccomodation(String serial, Handler<AsyncResult<Integer>> resultHandler) {
        return null;
    }
}
