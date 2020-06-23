package io.vertx.easyerp.microservice.administration;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.easyerp.microservice.administration.api.RestAdministrationAPIVerticle;
import io.vertx.easyerp.microservice.administration.impl.AdministrationImpl;
import io.vertx.easyerp.microservice.common.BaseMicroserviceVerticle;
import io.vertx.serviceproxy.ProxyHelper;
import io.vertx.serviceproxy.ServiceBinder;

public class AdministrationVerticle extends BaseMicroserviceVerticle {

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        super.start();

        AdministrationService service = new AdministrationImpl(vertx, config());



    }

    private Future<Void> deployRestService(AdministrationService service){
        Promise<String> promise = Promise.promise();
        vertx.deployVerticle(new RestAdministrationAPIVerticle(service),
                new DeploymentOptions().setConfig(config()),
                promise);
        return promise.future().map(r->null);
    }
}
