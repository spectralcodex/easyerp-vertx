package io.vertx.easyerp.microservice.administration;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.easyerp.microservice.administration.api.AdministrationRestAPIVerticle;
import io.vertx.easyerp.microservice.administration.impl.AdministrationImpl;
import io.vertx.easyerp.microservice.common.BaseMicroserviceVerticle;
import static io.vertx.easyerp.microservice.common.config.ConfigRetrieverHelper.configurationRetriever;
import io.vertx.serviceproxy.ProxyHelper;

public class AdministrationVerticle extends BaseMicroserviceVerticle {
    private static final long SCAN_PERIOD = 20000L;
    private static  final String PATH = "/conf/vertx.conf";
    private final static Logger logger = LoggerFactory.getLogger(AdministrationVerticle.class);

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        super.start();

        //Smuggling the service instance
       loadConfigsAndRegisterService(PATH)
               /* ping database and-then publish the service in the discovery infrastructure
                */
               .compose(loadOk -> pingPersistence(loadOk))
               .compose(databaseOK -> publishEventBusService(AdministrationService.SERVICE_NAME, AdministrationService.SERVICE_ADDRESS, databaseOK))
               .compose(servicePublisedOk -> deployRestService(servicePublisedOk))
               .onComplete(startPromise);
    }

    /**
     * Ping the persistence backend to see if its up
     *
     * @param service instance
     * @return service instance to be used in next stage
     */
    private Future<AdministrationService> pingPersistence(final AdministrationService service){
        Promise<Void> initPromise = Promise.promise();
        service.initializePersistence(initPromise);
        return initPromise.future().map(r->{
            ///Perform some init db operations here
            return service;
        });

    }

    /**
     * Deploy the admin microservice
     *
     * @param service instance
     * @return
     */
    private Future<Void> deployRestService(AdministrationService service){
        Promise<String> promise = Promise.promise();
        vertx.deployVerticle(new AdministrationRestAPIVerticle(service),
                new DeploymentOptions().setConfig(config()),
                promise);
        return promise.future().map(
                ret -> null
        );
    }


    /**
     * Load configurations, create and register the service for propagation
     *
     * @param path configuration file path
     * @return  service instance to be use in next stage
     */
    private Future<AdministrationService> loadConfigsAndRegisterService(final String path) {
        Promise<JsonObject> initConfigPromise = Promise.promise();

        //get environmental variables using the path provided
        configurationRetriever
                .usingScanPeriod(SCAN_PERIOD)
                .withFileStore(path)
                .createConfig(vertx)
                .onComplete(initConfigPromise);
        return initConfigPromise.future().map(conf -> {

            // create the service instance
            final AdministrationService service = new AdministrationImpl(vertx, config().mergeIn(conf));

            // register the service proxy on event bus NB: must change from ProxyHelper to ServiceBinder
            ProxyHelper.registerService(AdministrationService.class, vertx, service, service.SERVICE_ADDRESS);

            logger.info("Initializing config:::" + config());
            return service;
        });
    }
}
