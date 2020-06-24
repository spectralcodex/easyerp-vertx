package io.vertx.easyerp.microservice.administration;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.easyerp.microservice.administration.api.RestAdministrationAPIVerticle;
import io.vertx.easyerp.microservice.administration.impl.AdministrationImpl;
import io.vertx.easyerp.microservice.common.BaseMicroserviceVerticle;
import io.vertx.serviceproxy.ProxyHelper;

public class AdministrationVerticle extends BaseMicroserviceVerticle {

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        super.start();

        // create the service instance
        AdministrationService service = new AdministrationImpl(vertx, config());

        // register the service proxy on event bus NB: must change from ProxyHelper to ServiceBinder
        ProxyHelper.registerService(AdministrationService.class, vertx, service, service.SERVICE_ADDRESS);

        /* ping database and-then publish the service in the discovery infrastructure
         */
        pingPersistence(service)
                .compose(databaseOK -> publishEventBusService(service.SERVICE_NAME, service.SERVICE_ADDRESS, AdministrationService.class))
                .compose(servicePublised -> deployRestService(service))
                .onComplete(startPromise);
    }

    private Future<Void> pingPersistence(AdministrationService service){
        Promise<Void> initPromise = Promise.promise();
        service.initializePersistence(initPromise);
        return initPromise.future().map(r->{
            ///Perform some init db operations here
            return null;
        });

    }

    private Future<Void> deployRestService(AdministrationService service){
        Promise<String> promise = Promise.promise();
        vertx.deployVerticle(new RestAdministrationAPIVerticle(service),
                new DeploymentOptions().setConfig(config()),
                promise);
        return promise.future().map(r->null);
    }
}
