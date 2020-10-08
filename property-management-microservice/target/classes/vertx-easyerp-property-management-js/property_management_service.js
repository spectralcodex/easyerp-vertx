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

/** @module vertx-easyerp-property-management-js/property_management_service */
var utils = require('vertx-js/util/utils');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JPropertyManagementService = Java.type('io.vertx.easyerp.microservice.propertymanagement.PropertyManagementService');
var Accomodation = Java.type('io.vertx.easyerp.microservice.propertymanagement.jpojo.Accomodation');
var PropertyAmenity = Java.type('io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyAmenity');
var PropertyProfile = Java.type('io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyProfile');

/**
 A service interface managing Property.
 <p>
 This service is an event bus service (aka. service proxy)
 </p>

 @class
*/
var PropertyManagementService = function(j_val) {

  var j_propertyManagementService = j_val;
  var that = this;

  var __super_addProfile = this.addProfile;
  var __super_createProfile = this.createProfile;
  var __super_updateProfile = this.updateProfile;
  var __super_retrieveProfile = this.retrieveProfile;
  var __super_deleteProfile = this.deleteProfile;
  var __super_retrieveAmenities = this.retrieveAmenities;
  var __super_addAmenity = this.addAmenity;
  var __super_deleteAmenity = this.deleteAmenity;
  var __super_addAccomodation = this.addAccomodation;
  var __super_updateAccomodation = this.updateAccomodation;
  var __super_retrieveAllAccomodations = this.retrieveAllAccomodations;
  var __super_retrieveAccomodation = this.retrieveAccomodation;
  var __super_deleteAccomodation = this.deleteAccomodation;
  /**

   @public
   @param profile {Object} 
   @param resultHandler {function} the result handler will be called as soon as the initialization has been accomplished. The jooq.async result indicates whether the operation was successful or not. 
   @return {PropertyManagementService}
   */
  this.addProfile =  function(profile, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
      j_propertyManagementService["addProfile(io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyProfile,io.vertx.core.Handler)"](__args[0]  != null ? new PropertyProfile(new JsonObject(Java.asJSONCompatible(__args[0]))) : null, function(ar) {
        if (ar.succeeded()) {
          __args[1](ar.result(), null);
        } else {
          __args[1](null, ar.cause());
        }
      }) ;
      return that;
    } else if (typeof __super_addProfile != 'undefined') {
      return __super_addProfile.apply(this, __args);
    }
    else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param profile {Object} 
   @param resultHandler {function} 
   @return {PropertyManagementService} 
   */
  this.createProfile =  function(profile, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
      j_propertyManagementService["createProfile(io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyProfile,io.vertx.core.Handler)"](__args[0]  != null ? new PropertyProfile(new JsonObject(Java.asJSONCompatible(__args[0]))) : null, function(ar) {
        if (ar.succeeded()) {
          __args[1](ar.result(), null);
        } else {
          __args[1](null, ar.cause());
        }
      }) ;
      return that;
    } else if (typeof __super_createProfile != 'undefined') {
      return __super_createProfile.apply(this, __args);
    }
    else throw new TypeError('function invoked with invalid arguments');
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
      j_propertyManagementService["updateProfile(io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyProfile,io.vertx.core.Handler)"](__args[0]  != null ? new PropertyProfile(new JsonObject(Java.asJSONCompatible(__args[0]))) : null, function(ar) {
        if (ar.succeeded()) {
          __args[1](ar.result(), null);
        } else {
          __args[1](null, ar.cause());
        }
      }) ;
      return that;
    } else if (typeof __super_updateProfile != 'undefined') {
      return __super_updateProfile.apply(this, __args);
    }
    else throw new TypeError('function invoked with invalid arguments');
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
      j_propertyManagementService["retrieveProfile(java.lang.String,io.vertx.core.Handler)"](__args[0], function(ar) {
        if (ar.succeeded()) {
          __args[1](utils.convReturnJson(ar.result()), null);
        } else {
          __args[1](null, ar.cause());
        }
      }) ;
      return that;
    } else if (typeof __super_retrieveProfile != 'undefined') {
      return __super_retrieveProfile.apply(this, __args);
    }
    else throw new TypeError('function invoked with invalid arguments');
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
      j_propertyManagementService["deleteProfile(java.lang.String,io.vertx.core.Handler)"](__args[0], function(ar) {
        if (ar.succeeded()) {
          __args[1](ar.result(), null);
        } else {
          __args[1](null, ar.cause());
        }
      }) ;
      return that;
    } else if (typeof __super_deleteProfile != 'undefined') {
      return __super_deleteProfile.apply(this, __args);
    }
    else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param resultHandler {function} 
   @return {PropertyManagementService}
   */
  this.retrieveAmenities =  function(resultHandler) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      j_propertyManagementService["retrieveAmenities(io.vertx.core.Handler)"](function(ar) {
        if (ar.succeeded()) {
          __args[0](utils.convReturnJson(ar.result()), null);
        } else {
          __args[0](null, ar.cause());
        }
      }) ;
      return that;
    } else if (typeof __super_retrieveAmenities != 'undefined') {
      return __super_retrieveAmenities.apply(this, __args);
    }
    else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param amenity {Object} 
   @param resultHandler {function} 
   @return {PropertyManagementService}
   */
  this.addAmenity =  function(amenity, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
      j_propertyManagementService["addAmenity(io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyAmenity,io.vertx.core.Handler)"](__args[0]  != null ? new PropertyAmenity(new JsonObject(Java.asJSONCompatible(__args[0]))) : null, function(ar) {
        if (ar.succeeded()) {
          __args[1](ar.result(), null);
        } else {
          __args[1](null, ar.cause());
        }
      }) ;
      return that;
    } else if (typeof __super_addAmenity != 'undefined') {
      return __super_addAmenity.apply(this, __args);
    }
    else throw new TypeError('function invoked with invalid arguments');
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
      j_propertyManagementService["deleteAmenity(java.lang.String,io.vertx.core.Handler)"](__args[0], function(ar) {
        if (ar.succeeded()) {
          __args[1](ar.result(), null);
        } else {
          __args[1](null, ar.cause());
        }
      }) ;
      return that;
    } else if (typeof __super_deleteAmenity != 'undefined') {
      return __super_deleteAmenity.apply(this, __args);
    }
    else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param accomodation {Object} 
   @param resultHandler {function} 
   @return {PropertyManagementService}
   */
  this.addAccomodation =  function(accomodation, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
      j_propertyManagementService["addAccomodation(io.vertx.easyerp.microservice.propertymanagement.jpojo.Accomodation,io.vertx.core.Handler)"](__args[0]  != null ? new Accomodation(new JsonObject(Java.asJSONCompatible(__args[0]))) : null, function(ar) {
        if (ar.succeeded()) {
          __args[1](ar.result(), null);
        } else {
          __args[1](null, ar.cause());
        }
      }) ;
      return that;
    } else if (typeof __super_addAccomodation != 'undefined') {
      return __super_addAccomodation.apply(this, __args);
    }
    else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param accomodation {Object} 
   @param resultHandler {function} 
   @return {PropertyManagementService}
   */
  this.updateAccomodation =  function(accomodation, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
      j_propertyManagementService["updateAccomodation(io.vertx.easyerp.microservice.propertymanagement.jpojo.Accomodation,io.vertx.core.Handler)"](__args[0]  != null ? new Accomodation(new JsonObject(Java.asJSONCompatible(__args[0]))) : null, function(ar) {
        if (ar.succeeded()) {
          __args[1](ar.result(), null);
        } else {
          __args[1](null, ar.cause());
        }
      }) ;
      return that;
    } else if (typeof __super_updateAccomodation != 'undefined') {
      return __super_updateAccomodation.apply(this, __args);
    }
    else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param resultHandler {function} 
   @return {PropertyManagementService}
   */
  this.retrieveAllAccomodations =  function(resultHandler) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      j_propertyManagementService["retrieveAllAccomodations(io.vertx.core.Handler)"](function(ar) {
        if (ar.succeeded()) {
          __args[0](utils.convReturnListSetJson(ar.result()), null);
        } else {
          __args[0](null, ar.cause());
        }
      }) ;
      return that;
    } else if (typeof __super_retrieveAllAccomodations != 'undefined') {
      return __super_retrieveAllAccomodations.apply(this, __args);
    }
    else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param serial {string} 
   @param resultHandler {function} 
   @return {PropertyManagementService}
   */
  this.retrieveAccomodation =  function(serial, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'function') {
      j_propertyManagementService["retrieveAccomodation(java.lang.String,io.vertx.core.Handler)"](__args[0], function(ar) {
        if (ar.succeeded()) {
          __args[1](utils.convReturnJson(ar.result()), null);
        } else {
          __args[1](null, ar.cause());
        }
      }) ;
      return that;
    } else if (typeof __super_retrieveAccomodation != 'undefined') {
      return __super_retrieveAccomodation.apply(this, __args);
    }
    else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param serial {string} 
   @param resultHandler {function} 
   @return {PropertyManagementService}
   */
  this.deleteAccomodation =  function(serial, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'function') {
      j_propertyManagementService["deleteAccomodation(java.lang.String,io.vertx.core.Handler)"](__args[0], function(ar) {
        if (ar.succeeded()) {
          __args[1](ar.result(), null);
        } else {
          __args[1](null, ar.cause());
        }
      }) ;
      return that;
    } else if (typeof __super_deleteAccomodation != 'undefined') {
      return __super_deleteAccomodation.apply(this, __args);
    }
    else throw new TypeError('function invoked with invalid arguments');
  };

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_propertyManagementService;
};

PropertyManagementService._jclass = utils.getJavaClass("io.vertx.easyerp.microservice.propertymanagement.PropertyManagementService");
PropertyManagementService._jtype = {accept: function(obj) {
    return PropertyManagementService._jclass.isInstance(obj._jdel);
  },wrap: function(jdel) {
    var obj = Object.create(PropertyManagementService.prototype, {});
    PropertyManagementService.apply(obj, arguments);
    return obj;
  },
  unwrap: function(obj) {
    return obj._jdel;
  }
};
PropertyManagementService._create = function(jdel) {var obj = Object.create(PropertyManagementService.prototype, {});
  PropertyManagementService.apply(obj, arguments);
  return obj;
}
PropertyManagementService.SERVICE_NAME = JPropertyManagementService.SERVICE_NAME;
PropertyManagementService.SERVICE_ADDRESS = JPropertyManagementService.SERVICE_ADDRESS;
module.exports = PropertyManagementService;