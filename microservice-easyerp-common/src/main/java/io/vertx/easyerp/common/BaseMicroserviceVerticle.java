package io.vertx.easyerp.common;

import io.vertx.circuitbreaker.CircuitBreaker;
import io.vertx.circuitbreaker.CircuitBreakerOptions;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.impl.ConcurrentHashSet;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.rxjava.servicediscovery.types.HttpEndpoint;
import io.vertx.rxjava.servicediscovery.types.MessageSource;
import io.vertx.servicediscovery.Record;
import io.vertx.servicediscovery.ServiceDiscovery;
import io.vertx.servicediscovery.ServiceDiscoveryOptions;
import io.vertx.servicediscovery.types.EventBusService;
import io.vertx.servicediscovery.types.JDBCDataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class BaseMicroserviceVerticle extends AbstractVerticle {
    private static final String LOG_EVENT_ADDRESS = "events.log";
    private static final Logger logger = LoggerFactory.getLogger(BaseMicroserviceVerticle.class);

    protected ServiceDiscovery discovery;
    protected CircuitBreaker circuitBreaker;
    protected Set<Record> registeredRecords = new ConcurrentHashSet<>();

    @Override
    public void start() throws Exception {
        logger.info("Initializing discovery and circuit breaker");

        //Initialize service discovery
        discovery = ServiceDiscovery.create(vertx, new ServiceDiscoveryOptions().setBackendConfiguration(config()));
        // init circuit breaker instance
        JsonObject cbOpts = config().getJsonObject("circuit-breaker") != null ?
                config().getJsonObject("circuit-breaker") : new JsonObject();

        circuitBreaker = CircuitBreaker.create(cbOpts.getString("name", "circuit-breaker"), vertx,
                new CircuitBreakerOptions()
                        .setMaxFailures(cbOpts.getInteger("max-failures", 5))
                        .setTimeout(cbOpts.getLong("timeout", 10000L))
                        .setFallbackOnFailure(true)
                        .setResetTimeout(cbOpts.getLong("reset-timeout", 30000L))
        );

    }

    /**
     * Helper methods for adding resources to the discovery service
     *
     * @param name resource name
     * @param host resource host
     * @param port resource port
     * @return async result
     */
    protected Future<Void> publishHttpEndpoint(String name, String host, int port) {
        Record record = HttpEndpoint.createRecord(name, host, port, "/",
                new JsonObject().put("api.name", config().getString("api.name", "")));
        return publish(record);

    }

    protected Future<Void> publishApiGateway(String host, int port) {
        Record record = HttpEndpoint.createRecord("api-gateway", true, host, port, "/", null)
                .setType("api-gateway");
        return publish(record);
    }

    protected Future<Void> publishMessageSource(String name, String address) {
        Record record = MessageSource.createRecord(name, address);
        return publish(record);
    }


    protected Future<Void> publishJDBCDataSource(String name, JsonObject location) {
        Record record = JDBCDataSource.createRecord(name, location, new JsonObject());
        return publish(record);
    }

    protected Future<Void> publishEventBusService(String name, String address, Class serviceClass) {
        Record record = EventBusService.createRecord(name, address, serviceClass);
        return publish(record);
    }


    /**
     * A helper method that simply publish logs on the event bus.
     *
     * @param type log type
     * @param data log message data
     */
    protected void publishLogEvent(String type, JsonObject data) {
        JsonObject msg = new JsonObject().put("type", type)
                .put("message", data);
        vertx.eventBus().publish(LOG_EVENT_ADDRESS, msg);
    }

    protected void publishLogEvent(String type, JsonObject data, boolean succeeded) {
        JsonObject msg = new JsonObject().put("type", type)
                .put("status", succeeded)
                .put("message", data);
        vertx.eventBus().publish(LOG_EVENT_ADDRESS, msg);
    }

    /**
     * @param record resource record
     * @return Async result
     */
    protected Future<Void> publish(Record record) {
        if (discovery == null) {
            try {
                start();
            } catch (Exception e) {
                throw new IllegalStateException("Cannot create discovery service");
            }
        }

        Future<Void> future = Future.future();
        discovery.publish(record, ar -> {
            if (ar.succeeded()) {
                registeredRecords.add(record);
                logger.info("Service <" + ar.result().getName() + "> published");
                future.complete();
            } else {
                logger.info("Error::Service <" + ar.result().getName() + "> failed published");
                future.fail(ar.cause());
            }
        });

        return future;
    }

    /**
     * Shutdown and cleanup all resources in discovery service
     *
     * @param stopFuture
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        List<Future> futures = new ArrayList<>();
        registeredRecords.forEach(record -> {
            Future<Void> cleanUpFuture = Future.future();
            discovery.unpublish(record.getRegistration(), cleanUpFuture.completer());
            futures.add(cleanUpFuture);
        });

        if (futures.isEmpty()) {
            discovery.close();
            stopFuture.complete();
        } else {
            CompositeFuture.all(futures)
                    .setHandler(ar -> {
                        discovery.close();
                        if (ar.failed()) {
                            stopFuture.fail(ar.cause());
                        } else {
                            stopFuture.complete();
                        }
                    });
        }
    }
}
