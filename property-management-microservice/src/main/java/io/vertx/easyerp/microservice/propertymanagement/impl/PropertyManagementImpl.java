package io.vertx.easyerp.microservice.propertymanagement.impl;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.easyerp.microservice.common.service.JooqRepositoryWrapper;
import io.vertx.easyerp.microservice.propertymanagement.PropertyManagementService;
import io.vertx.easyerp.microservice.propertymanagement.jpojo.Accommodation;
import io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyAmenity;
import io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyProfile;

import java.util.List;
import java.util.UUID;

import static jooq.Tables.*;

public class PropertyManagementImpl extends JooqRepositoryWrapper implements PropertyManagementService {

    public PropertyManagementImpl(Vertx vertx, JsonObject config) {
        super(vertx, config);
    }


    /** Profile
     *
     * @param  profile
     * @param resultHandler the result handler will be called as soon as the initialization has been accomplished.
     * @return
     */
    @Override
    public PropertyManagementService createProfile(PropertyProfile profile, Handler<AsyncResult<Integer>> resultHandler) {
        executor.execute(dsl -> dsl.insertInto(TB_PROPERTY_PROFILE, TB_PROPERTY_PROFILE.SERIALNUMBER,
                TB_PROPERTY_PROFILE.TYPE, TB_PROPERTY_PROFILE.DESCRIPTION, TB_PROPERTY_PROFILE.IMAGE,
                TB_PROPERTY_PROFILE.NAME, TB_PROPERTY_PROFILE.PHONE, TB_PROPERTY_PROFILE.EMAIL,
                TB_PROPERTY_PROFILE.WEBSITE, TB_PROPERTY_PROFILE.OWNERFIRSTNAME, TB_PROPERTY_PROFILE.OWNERLASTNAME,
                TB_PROPERTY_PROFILE.COUNTRY, TB_PROPERTY_PROFILE.ADDRESS1, TB_PROPERTY_PROFILE.ADDRESS2,
                TB_PROPERTY_PROFILE.CITY, TB_PROPERTY_PROFILE.POSTALCODE, TB_PROPERTY_PROFILE.LOCATIONCOORDINATE,
                TB_PROPERTY_PROFILE.CREATEDBY).values(UUID.randomUUID().toString(), profile.getType(), profile.getDescription(), profile.getImage(),
                profile.getName(), profile.getPhone(), profile.getEmail(), profile.getWebsite(), profile.getOwnerFirstName(), profile.getOwnerLastName(),
                profile.getCountry(), profile.getAddress1(), profile.getAddress2(), profile.getCity(), profile.getPostalCode(), profile.getLocationCoordinate(),
                profile.getCreatedBy())).onComplete(resultHandler);
        return this;
    }

    @Override
    public PropertyManagementService initializeProfile(PropertyProfile profile, Handler<AsyncResult<Integer>> resultHandler) {
        executor.execute(dsl -> dsl.insertInto(TB_PROPERTY_PROFILE, TB_PROPERTY_PROFILE.SERIALNUMBER,
                TB_PROPERTY_PROFILE.TYPE,
                TB_PROPERTY_PROFILE.NAME,
                TB_PROPERTY_PROFILE.PROFILECODE,
                TB_PROPERTY_PROFILE.CREATEDBY)
                .values(UUID.randomUUID().toString(),  profile.getType(),profile.getName(), profile.getProfileCode(),
                profile.getCreatedBy())).onComplete(resultHandler);
        return this;
    }

    @Override
    public PropertyManagementService updateProfile(PropertyProfile profile, Handler<AsyncResult<Integer>> resultHandler) {
        executor.execute(dsl -> dsl.update(TB_PROPERTY_PROFILE).set(TB_PROPERTY_PROFILE.TYPE, profile.getType())
                .set(TB_PROPERTY_PROFILE.DESCRIPTION, profile.getDescription())
                .set(TB_PROPERTY_PROFILE.IMAGE, profile.getImage())
                .set(TB_PROPERTY_PROFILE.NAME, profile.getName())
                .set(TB_PROPERTY_PROFILE.PHONE, profile.getPhone())
                .set(TB_PROPERTY_PROFILE.EMAIL, profile.getEmail())
                .set(TB_PROPERTY_PROFILE.WEBSITE, profile.getWebsite())
                .set(TB_PROPERTY_PROFILE.OWNERFIRSTNAME, profile.getOwnerFirstName())
                .set(TB_PROPERTY_PROFILE.OWNERLASTNAME, profile.getOwnerLastName())
                .set(TB_PROPERTY_PROFILE.COUNTRY, profile.getCountry())
                .set(TB_PROPERTY_PROFILE.ADDRESS1, profile.getAddress1())
                .set(TB_PROPERTY_PROFILE.ADDRESS2, profile.getAddress2())
                .set(TB_PROPERTY_PROFILE.CITY, profile.getCity())
                .set(TB_PROPERTY_PROFILE.POSTALCODE, profile.getPostalCode())
                .set(TB_PROPERTY_PROFILE.LOCATIONCOORDINATE, profile.getLocationCoordinate())
                .set(TB_PROPERTY_PROFILE.CREATEDBY, profile.getCreatedBy())
                .where(TB_PROPERTY_PROFILE.SERIALNUMBER.eq(profile.getSerialNumber())))
                .onComplete(resultHandler);
        return this;
    }

    @Override
    public PropertyManagementService retrieveProfile(String serial, Handler<AsyncResult<JsonObject>> resultHandler) {
        executor.findOneJson(dsl -> dsl.selectFrom(TB_PROPERTY_PROFILE).where(TB_PROPERTY_PROFILE.SERIALNUMBER.eq(serial)))
                .onComplete(resultHandler);
        return this;
    }

    @Override
    public PropertyManagementService deleteProfile(String serial, Handler<AsyncResult<Integer>> resultHandler) {
        executor.execute(dsl -> dsl.deleteFrom(TB_PROPERTY_PROFILE).where(TB_PROPERTY_PROFILE.SERIALNUMBER.eq(serial)))
                .onComplete(resultHandler);
        return this;
    }

    /**Amenity
     **/

    @Override
    public PropertyManagementService createAmenity(PropertyAmenity amenity, Handler<AsyncResult<Integer>> resultHandler) {
        executor.execute(dsl -> dsl.insertInto(TB_PROPERTY_AMENITY, TB_PROPERTY_AMENITY.SERIALNUMBER,TB_PROPERTY_AMENITY.AMENITY,
                TB_PROPERTY_AMENITY.STATUS, TB_PROPERTY_AMENITY.CREATEDBY).values(amenity.getSerialNumber(), amenity.getAmenity(),
                amenity.getStatus(), amenity.getCreatedBy())).onComplete(resultHandler);
        return this;
    }

    @Override
    public PropertyManagementService retrieveAmenities(Handler<AsyncResult<List<JsonObject>>> resultHandler) {
        executor.findManyJson(dsl -> dsl.selectFrom(TB_PROPERTY_AMENITY))
                .onComplete(resultHandler);
        return this;
    }

    @Override
    public PropertyManagementService deleteAmenity(String serial, Handler<AsyncResult<Integer>> resultHandler) {
        executor.execute(dsl -> dsl.deleteFrom(TB_PROPERTY_AMENITY).where(TB_PROPERTY_AMENITY.SERIALNUMBER.eq(serial)))
                .onComplete(resultHandler);
        return this;
    }

    /** Accommodation
     *
     * @param accommodation
     * @param resultHandler
     * @return
     */

    @Override
    public PropertyManagementService createAccommodation(Accommodation accommodation, Handler<AsyncResult<Integer>> resultHandler) {
        executor.execute(dsl -> dsl.insertInto(TB_ACCOMODATION, TB_ACCOMODATION.SERIALNUMBER, TB_ACCOMODATION.NAME,
                TB_ACCOMODATION.ABBREVATION, TB_ACCOMODATION.UNITS, TB_ACCOMODATION.DORMBEDSPERROOM,
                TB_ACCOMODATION.TOTALACCOMODATION, TB_ACCOMODATION.CREATEDBY).values(UUID.randomUUID().toString(),
                accommodation.getName(), accommodation.getAbbreviation(), accommodation.getUnits(), accommodation.getDormBedsPerRoom(),
                accommodation.getTotalAccommodation(), accommodation.getCreatedBy())).onComplete(resultHandler);
        return this;
    }

    @Override
    public PropertyManagementService updateAccommodation(Accommodation accommodation, Handler<AsyncResult<Integer>> resultHandler) {
        executor.execute(dsl -> dsl.update(TB_ACCOMODATION).set(TB_ACCOMODATION.NAME, accommodation.getName())
        .set(TB_ACCOMODATION.ABBREVATION, accommodation.getAbbreviation())
        .set(TB_ACCOMODATION.UNITS, accommodation.getUnits())
        .set(TB_ACCOMODATION.DORMBEDSPERROOM, accommodation.getDormBedsPerRoom())
        .set(TB_ACCOMODATION.TOTALACCOMODATION, accommodation.getTotalAccommodation())
        .set(TB_ACCOMODATION.CREATEDBY, accommodation.getCreatedBy())
                        .where(TB_ACCOMODATION.SERIALNUMBER.eq(accommodation.getSerialNumber()))
        ).onComplete(resultHandler);
        return this;
    }

    @Override
    public PropertyManagementService retrieveAllAccommodations(Handler<AsyncResult<List<JsonObject>>> resultHandler) {
        executor.findManyJson(dsl -> dsl.selectFrom(TB_ACCOMODATION))
                .onComplete(resultHandler);
        return this;
    }

    @Override
    public PropertyManagementService retrieveAccommodation(String serial, Handler<AsyncResult<JsonObject>> resultHandler) {
        executor.findOneJson(dsl -> dsl.selectFrom(TB_ACCOMODATION).where(TB_ACCOMODATION.SERIALNUMBER.eq(serial)))
                .onComplete(resultHandler);
        return this;
    }

    @Override
    public PropertyManagementService deleteAccommodation(String serial, Handler<AsyncResult<Integer>> resultHandler) {
        executor.execute(dsl -> dsl.deleteFrom(TB_ACCOMODATION)
                .where(TB_ACCOMODATION.SERIALNUMBER.eq(serial)))
                .onComplete(resultHandler);
        return this;
    }
}
