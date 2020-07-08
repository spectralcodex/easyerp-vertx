package io.vertx.easyerp.microservice.administration.jpojo;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * Converter for {@link io.vertx.easyerp.microservice.administration.jpojo.User}.
 * NOTE: This class has been automatically generated from the {@link io.vertx.easyerp.microservice.administration.jpojo.User} original class using Vert.x codegen.
 */
public class UserConverter {

  public static void fromJson(Iterable<java.util.Map.Entry<String, Object>> json, User obj) {
    for (java.util.Map.Entry<String, Object> member : json) {
      switch (member.getKey()) {
        case "companyCode":
          if (member.getValue() instanceof String) {
            obj.setCompanyCode((String)member.getValue());
          }
          break;
        case "createdBy":
          if (member.getValue() instanceof String) {
            obj.setCreatedBy((String)member.getValue());
          }
          break;
        case "email":
          if (member.getValue() instanceof String) {
            obj.setEmail((String)member.getValue());
          }
          break;
        case "firstName":
          if (member.getValue() instanceof String) {
            obj.setFirstName((String)member.getValue());
          }
          break;
        case "id":
          if (member.getValue() instanceof Number) {
            obj.setId(((Number)member.getValue()).longValue());
          }
          break;
        case "lastName":
          if (member.getValue() instanceof String) {
            obj.setLastName((String)member.getValue());
          }
          break;
        case "mobile":
          if (member.getValue() instanceof String) {
            obj.setMobile((String)member.getValue());
          }
          break;
        case "salt":
          if (member.getValue() instanceof String) {
            obj.setSalt((String)member.getValue());
          }
          break;
        case "secret":
          if (member.getValue() instanceof String) {
            obj.setSecret((String)member.getValue());
          }
          break;
      }
    }
  }

  public static void toJson(User obj, JsonObject json) {
    toJson(obj, json.getMap());
  }

  public static void toJson(User obj, java.util.Map<String, Object> json) {
    if (obj.getCompanyCode() != null) {
      json.put("companyCode", obj.getCompanyCode());
    }
    if (obj.getCreatedBy() != null) {
      json.put("createdBy", obj.getCreatedBy());
    }
    if (obj.getEmail() != null) {
      json.put("email", obj.getEmail());
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
    if (obj.getMobile() != null) {
      json.put("mobile", obj.getMobile());
    }
    if (obj.getSalt() != null) {
      json.put("salt", obj.getSalt());
    }
    if (obj.getSecret() != null) {
      json.put("secret", obj.getSecret());
    }
  }
}
