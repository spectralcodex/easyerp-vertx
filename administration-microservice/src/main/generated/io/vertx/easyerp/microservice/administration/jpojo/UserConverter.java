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

package io.vertx.easyerp.microservice.administration.jpojo;

import io.vertx.core.json.JsonObject;

/**
 * Converter for {@link User}.
 *
 * NOTE: This class has been automatically generated from the {@link User} original class using Vert.x codegen.
 */
public class UserConverter {

  public static void fromJson(JsonObject json, User obj) {
    if (json.getValue("age") instanceof String) {
      obj.setAge((String)json.getValue("age"));
    }
    if (json.getValue("firstName") instanceof String) {
      obj.setFirstName((String)json.getValue("firstName"));
    }
    if (json.getValue("id") instanceof Number) {
      obj.setId(((Number)json.getValue("id")).longValue());
    }
    if (json.getValue("lastName") instanceof String) {
      obj.setLastName((String)json.getValue("lastName"));
    }
  }

  public static void toJson(User obj, JsonObject json) {
    if (obj.getAge() != null) {
      json.put("age", obj.getAge());
    }
    if (obj.getFirstName() != null) {
      json.put("firstName", obj.getFirstName());
    }
    if (obj.getId() != null) {
      json.put("id", obj.getId());
    }
    if (obj.getLastName() != null) {
      json.put("lastName", obj.getLastName());
    }
  }
}