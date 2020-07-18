package io.vertx.easyerp.microservice.common.config;

import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;
import rx.functions.Action1;

import java.net.URI;
import java.util.Objects;

public class Log4jConfigurationServiceHandler {
    private static final Logger logger = LoggerFactory.getLogger(Log4jConfigurationServiceHandler.class);
    private static LoggerContext loggerCtx;


    public static Action1<JsonObject> log4jSubscriber = config -> {
        if (Objects.isNull(loggerCtx)) {
            LoggerContext lc = initLoggerContext(config);
            logger.info("Initialized logger:: "+lc.getName());
        } else {
            updateLoggerContext(config);
        }
    };

    private static LoggerContext initLoggerContext(final JsonObject config) {
        return loggerCtx = Configurator.initialize(null, getLog4jConfigUri(config));
    }

    private static void updateLoggerContext(final JsonObject config) {
        try {
            loggerCtx.setConfigLocation(new URI(getLog4jConfigUri(config)));
        } catch (final Exception e) {
            logger.error(e);
        }
    }

    private static String getLog4jConfigUri(final JsonObject config) {
        return config.getString("log4j.config.uri", "log4j2.xml");
    }
}
