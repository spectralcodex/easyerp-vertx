package io.vertx.easyerp.common;

import io.vertx.circuitbreaker.CircuitBreaker;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.impl.ConcurrentHashSet;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.servicediscovery.Record;
import io.vertx.servicediscovery.ServiceDiscovery;

import java.util.Set;

public class BaseMicroserviceVerticle extends AbstractVerticle {
    private static final String LOG_EVENT_ADDRESS = "events.log";
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseMicroserviceVerticle.class);

    protected ServiceDiscovery discovery;
    protected CircuitBreaker circuitBreaker;
    protected Set<Record> registeredRecords = new ConcurrentHashSet<>();

    @Override
    public void start() throws Exception {
        super.start();
    }
}
