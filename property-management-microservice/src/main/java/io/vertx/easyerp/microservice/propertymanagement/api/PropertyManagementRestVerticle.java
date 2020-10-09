package io.vertx.easyerp.microservice.propertymanagement.api;

import io.vertx.core.Promise;
import io.vertx.easyerp.microservice.common.RestAPIVerticle;
import io.vertx.easyerp.microservice.propertymanagement.PropertyManagementService;
import io.vertx.ext.web.Router;
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
        /*router.post(API_ADD).handler(this::apiAddUser);
        router.get(API_RETRIEVE).handler(this::apiRetrieveUser);
        router.get(API_RETRIEVE_ALL).handler(this::apiRetrieveAll);
        router.patch(API_UPDATE).handler(this::apiUpdateUser);
        router.delete(API_DELETE).handler(this::apiDeleteUser);
*/
        String host = config().getString("property.http.address", "0.0.0.0");
        int port = config().getInteger("property.http.port", 8085);

        createHttpServer(router, host, port)
                .compose(serverCreated -> publishHttpEndpoint(SERVICE_NAME, host, port))
                .onComplete(startPromise);
    }
}
