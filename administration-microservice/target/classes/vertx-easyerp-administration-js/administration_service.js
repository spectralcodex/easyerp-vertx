/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

/** @module vertx-easyerp-administration-js/administration_service */
var utils = require('vertx-js/util/utils');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JAdministrationService = Java.type('io.vertx.easyerp.microservice.administration.AdministrationService');
var User = Java.type('io.vertx.easyerp.microservice.administration.module.user.User');

/**
 A service interface managing products.
 <p>
 This service is an event bus service (aka. service proxy)
 </p>

 @class
*/
var AdministrationService = function(j_val) {

  var j_administrationService = j_val;
  var that = this;

  /**

   @public
   @param resultHandler {function} the result handler will be called as soon as the initialization has been accomplished. The async result indicates whether the operation was successful or not. 
   @return {AdministrationService}
   */
  this.initializePersistence = function(resultHandler) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      j_administrationService["initializePersistence(io.vertx.core.Handler)"](function(ar) {
      if (ar.succeeded()) {
        resultHandler(null, null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Add a product to the persistence.

   @public
   @param user {Object} a product entity that we want to add 
   @param resultHandler {function} the result handler will be called as soon as the product has been added. The async result indicates whether the operation was successful or not. 
   @return {AdministrationService}
   */
  this.addUser = function(user, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
      j_administrationService["addUser(io.vertx.easyerp.microservice.administration.module.user.User,io.vertx.core.Handler)"](user != null ? new User(new JsonObject(Java.asJSONCompatible(user))) : null, function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnDataObject(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param userId {string} 
   @param resultHandler {function} 
   @return {AdministrationService}
   */
  this.retrieveUser = function(userId, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'function') {
      j_administrationService["retrieveUser(java.lang.String,io.vertx.core.Handler)"](userId, function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnDataObject(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_administrationService;
};

AdministrationService._jclass = utils.getJavaClass("io.vertx.easyerp.microservice.administration.AdministrationService");
AdministrationService._jtype = {
  accept: function(obj) {
    return AdministrationService._jclass.isInstance(obj._jdel);
  },
  wrap: function(jdel) {
    var obj = Object.create(AdministrationService.prototype, {});
    AdministrationService.apply(obj, arguments);
    return obj;
  },
  unwrap: function(obj) {
    return obj._jdel;
  }
};
AdministrationService._create = function(jdel) {
  var obj = Object.create(AdministrationService.prototype, {});
  AdministrationService.apply(obj, arguments);
  return obj;
}
module.exports = AdministrationService;