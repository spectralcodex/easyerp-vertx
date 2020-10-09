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

import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.Vertx;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;

import java.util.List;

import io.vertx.easyerp.microservice.propertymanagement.jpojo.Accommodation;
import io.vertx.serviceproxy.ServiceException;
import io.vertx.serviceproxy.ServiceExceptionMessageCodec;
import io.vertx.serviceproxy.ProxyUtils;

import io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyAmenity;
import io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyProfile;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
/*
  Generated Proxy code - DO NOT EDIT
  @author Roger the Robot
*/

@SuppressWarnings({"unchecked", "rawtypes"})
public class PropertyManagementServiceVertxEBProxy implements PropertyManagementService {
  private Vertx _vertx;
  private String _address;
  private DeliveryOptions _options;
  private boolean closed;

  public PropertyManagementServiceVertxEBProxy(Vertx vertx, String address) {
    this(vertx, address, null);
  }

  public PropertyManagementServiceVertxEBProxy(Vertx vertx, String address, DeliveryOptions options) {
    this._vertx = vertx;
    this._address = address;
    this._options = options;
    try{
      this._vertx.eventBus().registerDefaultCodec(ServiceException.class, new ServiceExceptionMessageCodec());
    } catch (IllegalStateException ex) {}
  }

  @Override
  public  PropertyManagementService createProfile(PropertyProfile profile, Handler<AsyncResult<Integer>> resultHandler){
    if (closed) {
      resultHandler.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return this;
    }
    JsonObject _json = new JsonObject();
    _json.put("profile", profile == null ? null : profile.toJson());

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "createProfile");
    _vertx.eventBus().<Integer>request(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        resultHandler.handle(Future.failedFuture(res.cause()));
      } else {
        resultHandler.handle(Future.succeededFuture(res.result().body()));
      }
    });
    return this;
  }
  @Override
  public  PropertyManagementService updateProfile(PropertyProfile profile, Handler<AsyncResult<Integer>> resultHandler){
    if (closed) {
      resultHandler.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return this;
    }
    JsonObject _json = new JsonObject();
    _json.put("profile", profile == null ? null : profile.toJson());

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "updateProfile");
    _vertx.eventBus().<Integer>request(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        resultHandler.handle(Future.failedFuture(res.cause()));
      } else {
        resultHandler.handle(Future.succeededFuture(res.result().body()));
      }
    });
    return this;
  }
  @Override
  public  PropertyManagementService retrieveProfile(String serial, Handler<AsyncResult<JsonObject>> resultHandler){
    if (closed) {
      resultHandler.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return this;
    }
    JsonObject _json = new JsonObject();
    _json.put("serial", serial);

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "retrieveProfile");
    _vertx.eventBus().<JsonObject>request(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        resultHandler.handle(Future.failedFuture(res.cause()));
      } else {
        resultHandler.handle(Future.succeededFuture(res.result().body()));
      }
    });
    return this;
  }
  @Override
  public  PropertyManagementService deleteProfile(String serial, Handler<AsyncResult<Integer>> resultHandler){
    if (closed) {
      resultHandler.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return this;
    }
    JsonObject _json = new JsonObject();
    _json.put("serial", serial);

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "deleteProfile");
    _vertx.eventBus().<Integer>request(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        resultHandler.handle(Future.failedFuture(res.cause()));
      } else {
        resultHandler.handle(Future.succeededFuture(res.result().body()));
      }
    });
    return this;
  }
  @Override
  public  PropertyManagementService retrieveAmenities(Handler<AsyncResult<List<JsonObject>>> resultHandler){
    if (closed) {
      resultHandler.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return this;
    }
    JsonObject _json = new JsonObject();

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "retrieveAmenities");
    _vertx.eventBus().<JsonArray>request(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        resultHandler.handle(Future.failedFuture(res.cause()));
      } else {
        resultHandler.handle(Future.succeededFuture(ProxyUtils.convertList(res.result().body().getList())));
      }
    });
    return this;
  }
  @Override
  public  PropertyManagementService createAmenity(PropertyAmenity amenity, Handler<AsyncResult<Integer>> resultHandler){
    if (closed) {
      resultHandler.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return this;
    }
    JsonObject _json = new JsonObject();
    _json.put("amenity", amenity == null ? null : amenity.toJson());

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "createAmenity");
    _vertx.eventBus().<Integer>request(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        resultHandler.handle(Future.failedFuture(res.cause()));
      } else {
        resultHandler.handle(Future.succeededFuture(res.result().body()));
      }
    });
    return this;
  }
  @Override
  public  PropertyManagementService deleteAmenity(String serial, Handler<AsyncResult<Integer>> resultHandler){
    if (closed) {
      resultHandler.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return this;
    }
    JsonObject _json = new JsonObject();
    _json.put("serial", serial);

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "deleteAmenity");
    _vertx.eventBus().<Integer>request(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        resultHandler.handle(Future.failedFuture(res.cause()));
      } else {
        resultHandler.handle(Future.succeededFuture(res.result().body()));
      }
    });
    return this;
  }
  @Override
  public  PropertyManagementService createAccommodation(Accommodation accommodation, Handler<AsyncResult<Integer>> resultHandler){
    if (closed) {
      resultHandler.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return this;
    }
    JsonObject _json = new JsonObject();
    _json.put("accomodation", accommodation == null ? null : accommodation.toJson());

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "createAccommodation");
    _vertx.eventBus().<Integer>request(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        resultHandler.handle(Future.failedFuture(res.cause()));
      } else {
        resultHandler.handle(Future.succeededFuture(res.result().body()));
      }
    });
    return this;
  }
  @Override
  public  PropertyManagementService updateAccommodation(Accommodation accommodation, Handler<AsyncResult<Integer>> resultHandler){
    if (closed) {
      resultHandler.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return this;
    }
    JsonObject _json = new JsonObject();
    _json.put("accomodation", accommodation == null ? null : accommodation.toJson());

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "updateAccommodation");
    _vertx.eventBus().<Integer>request(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        resultHandler.handle(Future.failedFuture(res.cause()));
      } else {
        resultHandler.handle(Future.succeededFuture(res.result().body()));
      }
    });
    return this;
  }
  @Override
  public  PropertyManagementService retrieveAllAccommodations(Handler<AsyncResult<List<JsonObject>>> resultHandler){
    if (closed) {
      resultHandler.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return this;
    }
    JsonObject _json = new JsonObject();

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "retrieveAllAccommodations");
    _vertx.eventBus().<JsonArray>request(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        resultHandler.handle(Future.failedFuture(res.cause()));
      } else {
        resultHandler.handle(Future.succeededFuture(ProxyUtils.convertList(res.result().body().getList())));
      }
    });
    return this;
  }
  @Override
  public  PropertyManagementService retrieveAccommodation(String serial, Handler<AsyncResult<JsonObject>> resultHandler){
    if (closed) {
      resultHandler.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return this;
    }
    JsonObject _json = new JsonObject();
    _json.put("serial", serial);

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "retrieveAccommodation");
    _vertx.eventBus().<JsonObject>request(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        resultHandler.handle(Future.failedFuture(res.cause()));
      } else {
        resultHandler.handle(Future.succeededFuture(res.result().body()));
      }
    });
    return this;
  }
  @Override
  public  PropertyManagementService deleteAccommodation(String serial, Handler<AsyncResult<Integer>> resultHandler){
    if (closed) {
      resultHandler.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return this;
    }
    JsonObject _json = new JsonObject();
    _json.put("serial", serial);

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "deleteAccommodation");
    _vertx.eventBus().<Integer>request(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        resultHandler.handle(Future.failedFuture(res.cause()));
      } else {
        resultHandler.handle(Future.succeededFuture(res.result().body()));
      }
    });
    return this;
  }
}
