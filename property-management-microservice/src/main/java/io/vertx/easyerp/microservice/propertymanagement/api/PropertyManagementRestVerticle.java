package io.vertx.easyerp.microservice.propertymanagement.api;

import io.vertx.core.Promise;
import io.vertx.easyerp.microservice.common.RestAPIVerticle;
import io.vertx.easyerp.microservice.propertymanagement.PropertyManagementService;
import io.vertx.easyerp.microservice.propertymanagement.jpojo.Accommodation;
import io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyAmenity;
import io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyProfile;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyManagementRestVerticle extends RestAPIVerticle {
    public static final String SERVICE_NAME = "propertymanagement-rest-api";

    private final PropertyManagementService service;

    private static final String API_PROFILE_ADD = "/profile";
    private static final String API_PROFILE_RETRIEVE = "/profile/:id";
    private static final String API_PROFILE_RETRIEVE_ALL = "/profile/all";
    private static final String API_PROFILE_UPDATE = "/profile/:id";
    private static final String API_PROFILE_DELETE = "/profile/:id";

    private static final String API_AMENITY_ADD = "/amenity";
    private static final String API_AMENITY_RETRIEVE_ALL = "/amenity/all";
    private static final String API_AMENITY_DELETE = "/amenity/:id";

    private static final String API_ACCOM_ADD = "/accommodation";
    private static final String API_ACCOM_RETRIEVE = "/accommodation/:id";
    private static final String API_ACCOM_RETRIEVE_ALL = "/accommodation/all";
    private static final String API_ACCOM_UPDATE = "/accommodation/:id";
    private static final String API_ACCOM_DELETE = "/accommodation/:id";

    protected final static Logger logger = LoggerFactory.getLogger(PropertyManagementRestVerticle.class);

    public PropertyManagementRestVerticle(PropertyManagementService service){
        this.service = service;
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        super.start();

        final Router router = enableRouteLoggingSupport(Router.router(vertx));

        // api route handler

        router.post(API_PROFILE_ADD).handler(this::addPropProfile);
        router.get(API_PROFILE_RETRIEVE).handler(this::fetcPropProfile);
        router.get(API_PROFILE_UPDATE).handler(this::editPropProfile);
        router.get(API_PROFILE_DELETE).handler(this::deletePropProfile);

        router.get(API_AMENITY_ADD).handler(this::addPropAmenity);
        router.get(API_AMENITY_RETRIEVE_ALL).handler(this::fetchPropAmenities);
        router.get(API_AMENITY_DELETE).handler(this::deletePropAmenity);

        router.get(API_ACCOM_ADD).handler(this::addAccommodation);
        router.get(API_ACCOM_RETRIEVE).handler(this::fetchAccommodation);
        router.get(API_ACCOM_RETRIEVE_ALL).handler(this::fetchAccommodations);
        router.get(API_ACCOM_UPDATE).handler(this::editPropAccommodation);
        router.get(API_ACCOM_DELETE).handler(this::deleteAccommodation);

        String host = config().getString("property.http.address", "0.0.0.0");
        int port = config().getInteger("property.http.port", 8085);

        createHttpServer(router, host, port)
                .compose(serverCreated -> publishHttpEndpoint(SERVICE_NAME, host, port))
                .onComplete(startPromise);
    }

    private void addPropProfile(RoutingContext context){
        PropertyProfile profile = new PropertyProfile(context.getBodyAsJson());
        service.createProfile(profile, resultHandler(context, 201));
    }

    private void editPropProfile(RoutingContext context){
        notImplemented(context);
    }

    private void fetcPropProfile(RoutingContext context){
        String id = context.request().getParam("id");
        service.retrieveProfile(id, resultHandlerNonEmpty(context));
    }

    private void deletePropProfile(RoutingContext context){
        String serialNo = context.request().getParam("id");
        service.deleteProfile(serialNo, deleteResultHandler(context));
    }

    private void addPropAmenity(RoutingContext context){
        PropertyAmenity propertyAmenity = new PropertyAmenity((context.getBodyAsJson()));
        service.createAmenity(propertyAmenity, resultHandler(context, 201));
    }

    private void editPropAmenity(RoutingContext context){
        notImplemented(context);
    }

    private void fetchPropAmenities(RoutingContext context){
        service.retrieveAmenities(resultHandlerNonEmpty(context));
    }

    private void deletePropAmenity(RoutingContext context){
        String serialNo = context.request().getParam("id");
        service.deleteAmenity(serialNo, deleteResultHandler(context));
    }

    private void addAccommodation(RoutingContext context){
        Accommodation accommodation = new Accommodation(context.getBodyAsJson());
        service.createAccommodation(accommodation, resultHandler(context, 201));
    }

    private void fetchAccommodations(RoutingContext context){
        service.retrieveAllAccommodations(resultHandlerNonEmpty(context));
    }

    private void fetchAccommodation(RoutingContext context){
        String id = context.request().getParam("id");
        service.retrieveAccommodation(id , resultHandlerNonEmpty(context));
    }

    private void deleteAccommodation(RoutingContext context){
        String serialNo = context.request().getParam("id");
        service.deleteAccommodation(serialNo, deleteResultHandler(context));
    }

    private void editPropAccommodation(RoutingContext context){
        notImplemented(context);
    }

}


