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

/// <reference path="./administration_service-proxy.d.ts" />

/** @module vertx-easyerp-administration-js/administration_service */
!function (factory) {
  if (typeof require === 'function' && typeof module !== 'undefined') {
    factory();
  } else if (typeof define === 'function' && define.amd) {
    // AMD loader
    define('vertx-easyerp-administration-js/administration_service-proxy', [], factory);
  } else {
    // plain old include
    AdministrationService = factory();
  }
}(function () {

  /**
   A service interface managing Users.
   <p>
   This service is an event bus service (aka. service proxy)
   </p>

   @class
  */
  var AdministrationService = function(eb, address) {
    var j_eb = eb;
    var j_address = address;
    var closed = false;
    var that = this;
    var convCharCollection = function(coll) {
      var ret = [];
      for (var i = 0;i < coll.length;i++) {
        ret.push(String.fromCharCode(coll[i]));
      }
      return ret;
    };

    /**

     @public
     @param resultHandler {function} the result handler will be called as soon as the initialization has been accomplished. The jooq.async result indicates whether the operation was successful or not. 
     @return {AdministrationService}
     */
    this.initializePersistence =  function(resultHandler) {
      var __args = arguments;
      if (__args.length === 1 && typeof __args[0] === 'function') {
        if (closed) {
          throw new Error('Proxy is closed');
        }
        j_eb.send(j_address, {}, {"action":"initializePersistence"}, function(err, result) { __args[0](err, result && result.body); });
        return that;
      } else throw new TypeError('function invoked with invalid arguments');
    };

    /**
     Add a User to the persistence.

     @public
     @param user {Object} a User entity that we want to add 
     @param resultHandler {function} the result handler will be called as soon as the User has been added. The jooq.async result indicates whether the operation was successful or not. 
     @return {AdministrationService}
     */
    this.addUser =  function(user, resultHandler) {
      var __args = arguments;
      if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
        if (closed) {
          throw new Error('Proxy is closed');
        }
        j_eb.send(j_address, {"user":__args[0]}, {"action":"addUser"}, function(err, result) { __args[1](err, result && result.body); });
        return that;
      } else throw new TypeError('function invoked with invalid arguments');
    };

    /**

     @public
     @param userId {string} 
     @param resultHandler {function} 
     @return {AdministrationService}
     */
    this.retrieveUser =  function(userId, resultHandler) {
      var __args = arguments;
      if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'function') {
        if (closed) {
          throw new Error('Proxy is closed');
        }
        j_eb.send(j_address, {"userId":__args[0]}, {"action":"retrieveUser"}, function(err, result) { __args[1](err, result && result.body); });
        return that;
      } else throw new TypeError('function invoked with invalid arguments');
    };

  };

  if (typeof exports !== 'undefined') {
    if (typeof module !== 'undefined' && module.exports) {
      exports = module.exports = AdministrationService;
    } else {
      exports.AdministrationService = AdministrationService;
    }
  } else {
    return AdministrationService;
  }
});