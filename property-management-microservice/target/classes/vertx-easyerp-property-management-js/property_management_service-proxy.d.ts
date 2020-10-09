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


/**
 A service interface managing Property.
 <p>
 This service is an event bus service (aka. service proxy)
 </p>

 @class
*/
export default class PropertyManagementService {

  constructor (eb: any, address: string);

  createProfile(profile: any, resultHandler: (err: any, result: any) => any) : PropertyManagementService;

  updateProfile(profile: any, resultHandler: (err: any, result: any) => any) : PropertyManagementService;

  retrieveProfile(serial: string, resultHandler: (err: any, result: Object) => any) : PropertyManagementService;

  deleteProfile(serial: string, resultHandler: (err: any, result: any) => any) : PropertyManagementService;

  retrieveAmenities(resultHandler: (err: any, result: Array<Object>) => any) : PropertyManagementService;

  createAmenity(amenity: any, resultHandler: (err: any, result: any) => any) : PropertyManagementService;

  deleteAmenity(serial: string, resultHandler: (err: any, result: any) => any) : PropertyManagementService;

  createAccommodation(accomodation: any, resultHandler: (err: any, result: any) => any) : PropertyManagementService;

  updateAccommodation(accomodation: any, resultHandler: (err: any, result: any) => any) : PropertyManagementService;

  retrieveAllAccommodations(resultHandler: (err: any, result: Array<Object>) => any) : PropertyManagementService;

  retrieveAccommodation(serial: string, resultHandler: (err: any, result: Object) => any) : PropertyManagementService;

  deleteAccommodation(serial: string, resultHandler: (err: any, result: any) => any) : PropertyManagementService;
}