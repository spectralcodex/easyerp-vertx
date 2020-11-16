package io.vertx.easyerp.microservice.propertymanagement;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.easyerp.microservice.common.BaseMicroserviceVerticle;
import io.vertx.easyerp.microservice.propertymanagement.api.PropertyManagementRestVerticle;
import io.vertx.easyerp.microservice.propertymanagement.impl.PropertyManagementImpl;
import io.vertx.serviceproxy.ProxyHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyManagementVerticle extends BaseMicroserviceVerticle {
    private final static Logger logger = LoggerFactory.getLogger(PropertyManagementImpl.class);

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        super.start();

        // create the service instance
        final PropertyManagementService service = new PropertyManagementImpl(vertx, config());

        // register the service proxy on event bus NB: must change from ProxyHelper to ServiceBinder
        ProxyHelper.registerService(PropertyManagementService.class, vertx, service, service.SERVICE_ADDRESS);

        logger.info("Initializing config::: {}", config());

        //Smuggling the service instance
        //loadConfigsAndRegisterService()
        /*
         * Ping database and-then publish the service in the discovery infrastructure
         */
       publishEventBusService(PropertyManagementService.SERVICE_NAME, PropertyManagementService.SERVICE_ADDRESS, service)
                .compose(servicePublishedOk -> deployRestService(servicePublishedOk))
                .onComplete(startPromise);
    }

    /**
     * Ping the persistence backend to see if its up
     *
     * @param service instance
     * @return service instance to be used in next stage

    private Future<PropertyManagementService> init(final PropertyManagementService service) {
        Promise<Void> initPromise = Promise.promise();
        //service.initializePersistence(initPromise);
        return initPromise.future().map(r -> {
            ///Perform some init db operations here
            return service;
        });
    }*/

    /**
     * Deploy the admin microservice
     *
     * @param service instance
     * @return future deployed Verticle
     */
    private Future<Void> deployRestService(PropertyManagementService service) {
        Promise<String> promise = Promise.promise();
        vertx.deployVerticle(new PropertyManagementRestVerticle(service),
                new DeploymentOptions().setConfig(config()),
                promise);
        return promise.future().map(ret -> null);
    }


}
