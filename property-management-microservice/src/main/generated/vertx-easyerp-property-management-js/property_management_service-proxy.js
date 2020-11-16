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

/// <reference path="./property_management_service-proxy.d.ts" />

/** @module vertx-easyerp-property-management-js/property_management_service */
!function (factory) {
  if (typeof require === 'function' && typeof module !== 'undefined') {
    factory();
  } else if (typeof define === 'function' && define.amd) {
    // AMD loader
    define('vertx-easyerp-property-management-js/property_management_service-proxy', [], factory);
  } else {
    // plain old include
    PropertyManagementService = factory();
  }
}(function () {

  /**
   A service interface managing Property.
   <p>
   This service is an event bus service (aka. service proxy)
   </p>

   @class
  */
  var PropertyManagementService = function(eb, address) {
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
     @param profile {Object} 
     @param resultHandler {function} the result handler will be called as soon as the initialization has been accomplished. The jooq.async result indicates whether the operation was successful or not. 
     @return {PropertyManagementService}
     */
    this.createProfile =  function(profile, resultHandler) {
      var __args = arguments;
      if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
        if (closed) {
          throw new Error('Proxy is closed');
        }
        j_eb.send(j_address, {"profile":__args[0]}, {"action":"createProfile"}, function(err, result) { __args[1](err, result && result.body); });
        return that;
      } else throw new TypeError('function invoked with invalid arguments');
    };

    /**

     @public
     @param profile {Object} 
     @param resultHandler {function} 
     @return {PropertyManagementService}
     */
    this.initializeProfile =  function(profile, resultHandler) {
      var __args = arguments;
      if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
        if (closed) {
          throw new Error('Proxy is closed');
        }
        j_eb.send(j_address, {"profile":__args[0]}, {"action":"initializeProfile"}, function(err, result) { __args[1](err, result && result.body); });
        return that;
      } else throw new TypeError('function invoked with invalid arguments');
    };

    /**

     @public
     @param profile {Object} 
     @param resultHandler {function} 
     @return {PropertyManagementService}
     */
    this.updateProfile =  function(profile, resultHandler) {
      var __args = arguments;
      if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
        if (closed) {
          throw new Error('Proxy is closed');
        }
        j_eb.send(j_address, {"profile":__args[0]}, {"action":"updateProfile"}, function(err, result) { __args[1](err, result && result.body); });
        return that;
      } else throw new TypeError('function invoked with invalid arguments');
    };

    /**

     @public
     @param serial {string} 
     @param resultHandler {function} 
     @return {PropertyManagementService}
     */
    this.retrieveProfile =  function(serial, resultHandler) {
      var __args = arguments;
      if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'function') {
        if (closed) {
          throw new Error('Proxy is closed');
        }
        j_eb.send(j_address, {"serial":__args[0]}, {"action":"retrieveProfile"}, function(err, result) { __args[1](err, result && result.body); });
        return that;
      } else throw new TypeError('function invoked with invalid arguments');
    };

    /**

     @public
     @param serial {string} 
     @param resultHandler {function} 
     @return {PropertyManagementService}
     */
    this.deleteProfile =  function(serial, resultHandler) {
      var __args = arguments;
      if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'function') {
        if (closed) {
          throw new Error('Proxy is closed');
        }
        j_eb.send(j_address, {"serial":__args[0]}, {"action":"deleteProfile"}, function(err, result) { __args[1](err, result && result.body); });
        return that;
      } else throw new TypeError('function invoked with invalid arguments');
    };

    /**

     @public
     @param resultHandler {function} 
     @return {PropertyManagementService}
     */
    this.retrieveAmenities =  function(resultHandler) {
      var __args = arguments;
      if (__args.length === 1 && typeof __args[0] === 'function') {
        if (closed) {
          throw new Error('Proxy is closed');
        }
        j_eb.send(j_address, {}, {"action":"retrieveAmenities"}, function(err, result) { __args[0](err, result && result.body); });
        return that;
      } else throw new TypeError('function invoked with invalid arguments');
    };

    /**

     @public
     @param amenity {Object} 
     @param resultHandler {function} 
     @return {PropertyManagementService}
     */
    this.createAmenity =  function(amenity, resultHandler) {
      var __args = arguments;
      if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
        if (closed) {
          throw new Error('Proxy is closed');
        }
        j_eb.send(j_address, {"amenity":__args[0]}, {"action":"createAmenity"}, function(err, result) { __args[1](err, result && result.body); });
        return that;
      } else throw new TypeError('function invoked with invalid arguments');
    };

    /**

     @public
     @param serial {string} 
     @param resultHandler {function} 
     @return {PropertyManagementService}
     */
    this.deleteAmenity =  function(serial, resultHandler) {
      var __args = arguments;
      if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'function') {
        if (closed) {
          throw new Error('Proxy is closed');
        }
        j_eb.send(j_address, {"serial":__args[0]}, {"action":"deleteAmenity"}, function(err, result) { __args[1](err, result && result.body); });
        return that;
      } else throw new TypeError('function invoked with invalid arguments');
    };

    /**

     @public
     @param accommodation {Object} 
     @param resultHandler {function} 
     @return {PropertyManagementService}
     */
    this.createAccommodation =  function(accommodation, resultHandler) {
      var __args = arguments;
      if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
        if (closed) {
          throw new Error('Proxy is closed');
        }
        j_eb.send(j_address, {"accommodation":__args[0]}, {"action":"createAccommodation"}, function(err, result) { __args[1](err, result && result.body); });
        return that;
      } else throw new TypeError('function invoked with invalid arguments');
    };

    /**

     @public
     @param accommodation {Object} 
     @param resultHandler {function} 
     @return {PropertyManagementService}
     */
    this.updateAccommodation =  function(accommodation, resultHandler) {
      var __args = arguments;
      if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
        if (closed) {
          throw new Error('Proxy is closed');
        }
        j_eb.send(j_address, {"accommodation":__args[0]}, {"action":"updateAccommodation"}, function(err, result) { __args[1](err, result && result.body); });
        return that;
      } else throw new TypeError('function invoked with invalid arguments');
    };

    /**

     @public
     @param resultHandler {function} 
     @return {PropertyManagementService}
     */
    this.retrieveAllAccommodations =  function(resultHandler) {
      var __args = arguments;
      if (__args.length === 1 && typeof __args[0] === 'function') {
        if (closed) {
          throw new Error('Proxy is closed');
        }
        j_eb.send(j_address, {}, {"action":"retrieveAllAccommodations"}, function(err, result) { __args[0](err, result && result.body); });
        return that;
      } else throw new TypeError('function invoked with invalid arguments');
    };

    /**

     @public
     @param serial {string} 
     @param resultHandler {function} 
     @return {PropertyManagementService}
     */
    this.retrieveAccommodation =  function(serial, resultHandler) {
      var __args = arguments;
      if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'function') {
        if (closed) {
          throw new Error('Proxy is closed');
        }
        j_eb.send(j_address, {"serial":__args[0]}, {"action":"retrieveAccommodation"}, function(err, result) { __args[1](err, result && result.body); });
        return that;
      } else throw new TypeError('function invoked with invalid arguments');
    };

    /**

     @public
     @param serial {string} 
     @param resultHandler {function} 
     @return {PropertyManagementService}
     */
    this.deleteAccommodation =  function(serial, resultHandler) {
      var __args = arguments;
      if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'function') {
        if (closed) {
          throw new Error('Proxy is closed');
        }
        j_eb.send(j_address, {"serial":__args[0]}, {"action":"deleteAccommodation"}, function(err, result) { __args[1](err, result && result.body); });
        return that;
      } else throw new TypeError('function invoked with invalid arguments');
    };

  };

  if (typeof exports !== 'undefined') {
    if (typeof module !== 'undefined' && module.exports) {
      exports = module.exports = PropertyManagementService;
    } else {
      exports.PropertyManagementService = PropertyManagementService;
    }
  } else {
    return PropertyManagementService;
  }
});