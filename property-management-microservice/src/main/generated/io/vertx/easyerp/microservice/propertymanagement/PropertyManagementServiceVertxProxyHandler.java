/*
* Copyright 2014 Red Hat, Inc.
*
* Red Hat licenses this file to you under the Apache License, version 2.0
* (the "License"); you may not use this file except in compliance with the
* License. You may obtain a copy of the License at:
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
* WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
* License for the specific language governing permissions and limitations
* under the License.
*/

package io.vertx.easyerp.microservice.propertymanagement;

import io.vertx.easyerp.microservice.propertymanagement.PropertyManagementService;
import io.vertx.core.Vertx;
import io.vertx.core.Handler;
import io.vertx.core.AsyncResult;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.ReplyException;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import io.vertx.serviceproxy.ServiceBinder;
import io.vertx.serviceproxy.ProxyHandler;
import io.vertx.serviceproxy.ServiceException;
import io.vertx.serviceproxy.ServiceExceptionMessageCodec;
import io.vertx.serviceproxy.HelperUtils;

import io.vertx.easyerp.microservice.propertymanagement.PropertyManagementService;
import java.util.List;
import io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyAmenity;
import io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyProfile;
import io.vertx.easyerp.microservice.propertymanagement.jpojo.Accommodation;
import io.vertx.core.json.JsonObject;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
/*
  Generated Proxy code - DO NOT EDIT
  @author Roger the Robot
*/

@SuppressWarnings({"unchecked", "rawtypes"})
public class PropertyManagementServiceVertxProxyHandler extends ProxyHandler {

  public static final long DEFAULT_CONNECTION_TIMEOUT = 5 * 60; // 5 minutes 
  private final Vertx vertx;
  private final PropertyManagementService service;
  private final long timerID;
  private long lastAccessed;
  private final long timeoutSeconds;

  public PropertyManagementServiceVertxProxyHandler(Vertx vertx, PropertyManagementService service){
    this(vertx, service, DEFAULT_CONNECTION_TIMEOUT);
  }

  public PropertyManagementServiceVertxProxyHandler(Vertx vertx, PropertyManagementService service, long timeoutInSecond){
    this(vertx, service, true, timeoutInSecond);
  }

  public PropertyManagementServiceVertxProxyHandler(Vertx vertx, PropertyManagementService service, boolean topLevel, long timeoutSeconds) {
      this.vertx = vertx;
      this.service = service;
      this.timeoutSeconds = timeoutSeconds;
      try {
        this.vertx.eventBus().registerDefaultCodec(ServiceException.class,
            new ServiceExceptionMessageCodec());
      } catch (IllegalStateException ex) {}
      if (timeoutSeconds != -1 && !topLevel) {
        long period = timeoutSeconds * 1000 / 2;
        if (period > 10000) {
          period = 10000;
        }
        this.timerID = vertx.setPeriodic(period, this::checkTimedOut);
      } else {
        this.timerID = -1;
      }
      accessed();
    }


  private void checkTimedOut(long id) {
    long now = System.nanoTime();
    if (now - lastAccessed > timeoutSeconds * 1000000000) {
      close();
    }
  }

    @Override
    public void close() {
      if (timerID != -1) {
        vertx.cancelTimer(timerID);
      }
      super.close();
    }

    private void accessed() {
      this.lastAccessed = System.nanoTime();
    }

  public void handle(Message<JsonObject> msg) {
    try{
      JsonObject json = msg.body();
      String action = msg.headers().get("action");
      if (action == null) throw new IllegalStateException("action not specified");
      accessed();
      switch (action) {
        case "createProfile": {
          service.createProfile(json.getJsonObject("profile") == null ? null : new io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyProfile(json.getJsonObject("profile")),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "initializeProfile": {
          service.initializeProfile(json.getJsonObject("profile") == null ? null : new io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyProfile(json.getJsonObject("profile")),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "updateProfile": {
          service.updateProfile(json.getJsonObject("profile") == null ? null : new io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyProfile(json.getJsonObject("profile")),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "retrieveProfile": {
          service.retrieveProfile((java.lang.String)json.getValue("serial"),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "deleteProfile": {
          service.deleteProfile((java.lang.String)json.getValue("serial"),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "retrieveAmenities": {
          service.retrieveAmenities(HelperUtils.createListHandler(msg));
          break;
        }
        case "createAmenity": {
          service.createAmenity(json.getJsonObject("amenity") == null ? null : new io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyAmenity(json.getJsonObject("amenity")),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "deleteAmenity": {
          service.deleteAmenity((java.lang.String)json.getValue("serial"),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "createAccommodation": {
          service.createAccommodation(json.getJsonObject("accommodation") == null ? null : new io.vertx.easyerp.microservice.propertymanagement.jpojo.Accommodation(json.getJsonObject("accommodation")),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "updateAccommodation": {
          service.updateAccommodation(json.getJsonObject("accommodation") == null ? null : new io.vertx.easyerp.microservice.propertymanagement.jpojo.Accommodation(json.getJsonObject("accommodation")),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "retrieveAllAccommodations": {
          service.retrieveAllAccommodations(HelperUtils.createListHandler(msg));
          break;
        }
        case "retrieveAccommodation": {
          service.retrieveAccommodation((java.lang.String)json.getValue("serial"),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "deleteAccommodation": {
          service.deleteAccommodation((java.lang.String)json.getValue("serial"),
                        HelperUtils.createHandler(msg));
          break;
        }
        default: throw new IllegalStateException("Invalid action: " + action);
      }
    } catch (Throwable t) {
      msg.reply(new ServiceException(500, t.getMessage()));
      throw t;
    }
  }
}