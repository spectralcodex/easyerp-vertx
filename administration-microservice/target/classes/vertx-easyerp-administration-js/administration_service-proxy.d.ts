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
 A service interface managing Users.
 <p>
 This service is an event bus service (aka. service proxy)
 </p>

 @class
*/
export default class AdministrationService {

  constructor (eb: any, address: string);

  initializePersistence(resultHandler: (err: any, result: any) => any) : AdministrationService;

  addUser(user: any, resultHandler: (err: any, result: any) => any) : AdministrationService;

  retrieveUser(userId: string, resultHandler: (err: any, result: Object) => any) : AdministrationService;
}