package io.vertx.easyerp.microservice.common.config;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import rx.Observable;
import io.vertx.core.Vertx;

import java.util.Objects;
import java.util.Optional;

public enum ConfigRetrieverHelper {
    configurationRetriever;

    private static final Logger logger = LoggerFactory.getLogger(ConfigRetrieverHelper.class);
    private ConfigRetrieverOptions options = new ConfigRetrieverOptions();
    private ConfigRetriever configRetriever;

    public ConfigRetrieverHelper usingScanPeriod(final long scanPeriod) {
        options.setScanPeriod(scanPeriod);
        return this;
    }

    public Future<JsonObject> createConfig(Vertx vertx) {
        logger.info("Config file loading...");
        configRetriever = ConfigRetriever.create(vertx, options);

        Promise<JsonObject> configPromise = Promise.promise();
        configRetriever.getConfig(config -> {
            if (config.failed()) {
                logger.info("Failed to retrieve configuration");
                configPromise.fail(config.cause());
            } else {

                configPromise.complete(config.result());
                logger.info(config.result());
            }
        });

        configRetriever.listen(config -> configPromise.complete(config.getNewConfiguration()));

        return configPromise.future();
    }

    public Observable<JsonObject> rxCreateConfig(final Vertx vertx) {
        configRetriever = ConfigRetriever.create(vertx, options);

        Observable<JsonObject> configObservable = Observable.create(subscriber -> {
            configRetriever.getConfig(ar -> {
                if (ar.failed()) {
                    logger.info("Failed to retrieve configuration::" + ar.cause());
                } else {
                    final JsonObject config =
                            vertx.getOrCreateContext().config().mergeIn(
                                    Optional.ofNullable(ar.result()).orElse(new JsonObject()));
                    subscriber.onNext(config);
                }
            });

            configRetriever.listen(ar -> {
                final JsonObject config =
                        vertx.getOrCreateContext().config().mergeIn(
                                Optional.ofNullable(ar.getNewConfiguration()).orElse(new JsonObject()));
                subscriber.onNext(config);
            });
        });

        configObservable.onErrorReturn(t -> {
            logger.error("Failed to emit configuration - Returning null", t);
            return null;
        });

        return configObservable.filter(Objects::nonNull);
    }

    public ConfigRetrieverHelper withFileStore(String path) {
        ConfigStoreOptions fileStore = new ConfigStoreOptions()
                .setType("file")
                .setConfig(new JsonObject().put("path", path));
        options.addStore(fileStore);
        return this;
    }
}
