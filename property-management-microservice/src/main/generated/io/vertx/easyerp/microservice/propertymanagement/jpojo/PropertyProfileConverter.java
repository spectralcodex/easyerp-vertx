package io.vertx.easyerp.microservice.propertymanagement.jpojo;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * Converter for {@link io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyProfile}.
 * NOTE: This class has been automatically generated from the {@link io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyProfile} original class using Vert.x codegen.
 */
public class PropertyProfileConverter {

  public static void fromJson(Iterable<java.util.Map.Entry<String, Object>> json, PropertyProfile obj) {
    for (java.util.Map.Entry<String, Object> member : json) {
      switch (member.getKey()) {
        case "address1":
          if (member.getValue() instanceof String) {
            obj.setAddress1((String)member.getValue());
          }
          break;
        case "address2":
          if (member.getValue() instanceof String) {
            obj.setAddress2((String)member.getValue());
          }
          break;
        case "city":
          if (member.getValue() instanceof String) {
            obj.setCity((String)member.getValue());
          }
          break;
        case "country":
          if (member.getValue() instanceof String) {
            obj.setCountry((String)member.getValue());
          }
          break;
        case "createdBy":
          if (member.getValue() instanceof String) {
            obj.setCreatedBy((String)member.getValue());
          }
          break;
        case "createdOn":
          if (member.getValue() instanceof String) {
            obj.setCreatedOn((String)member.getValue());
          }
          break;
        case "description":
          if (member.getValue() instanceof String) {
            obj.setDescription((String)member.getValue());
          }
          break;
        case "email":
          if (member.getValue() instanceof String) {
            obj.setEmail((String)member.getValue());
          }
          break;
        case "id":
          if (member.getValue() instanceof Number) {
            obj.setId(((Number)member.getValue()).longValue());
          }
          break;
        case "image":
          if (member.getValue() instanceof String) {
            obj.setImage((String)member.getValue());
          }
          break;
        case "locationCoordinate":
          if (member.getValue() instanceof String) {
            obj.setLocationCoordinate((String)member.getValue());
          }
          break;
        case "name":
          if (member.getValue() instanceof String) {
            obj.setName((String)member.getValue());
          }
          break;
        case "ownerFirstName":
          if (member.getValue() instanceof String) {
            obj.setOwnerFirstName((String)member.getValue());
          }
          break;
        case "ownerLastName":
          if (member.getValue() instanceof String) {
            obj.setOwnerLastName((String)member.getValue());
          }
          break;
        case "phone":
          if (member.getValue() instanceof String) {
            obj.setPhone((String)member.getValue());
          }
          break;
        case "postalCode":
          if (member.getValue() instanceof String) {
            obj.setPostalCode((String)member.getValue());
          }
          break;
        case "serialNumber":
          if (member.getValue() instanceof String) {
            obj.setSerialNumber((String)member.getValue());
          }
          break;
        case "type":
          if (member.getValue() instanceof String) {
            obj.setType((String)member.getValue());
          }
          break;
        case "website":
          if (member.getValue() instanceof String) {
            obj.setWebsite((String)member.getValue());
          }
          break;
      }
    }
  }

  public static void toJson(PropertyProfile obj, JsonObject json) {
    toJson(obj, json.getMap());
  }

  public static void toJson(PropertyProfile obj, java.util.Map<String, Object> json) {
    if (obj.getAddress1() != null) {
      json.put("address1", obj.getAddress1());
    }
    if (obj.getAddress2() != null) {
      json.put("address2", obj.getAddress2());
    }
    if (obj.getCity() != null) {
      json.put("city", obj.getCity());
    }
    if (obj.getCountry() != null) {
      json.put("country", obj.getCountry());
    }
    if (obj.getCreatedBy() != null) {
      json.put("createdBy", obj.getCreatedBy());
    }
    if (obj.getCreatedOn() != null) {
      json.put("createdOn", obj.getCreatedOn());
    }
    if (obj.getDescription() != null) {
      json.put("description", obj.getDescription());
    }
    if (obj.getEmail() != null) {
      json.put("email", obj.getEmail());
    }
    if (obj.getId() != null) {
      json.put("id", obj.getId());
    }
    if (obj.getImage() != null) {
      json.put("image", obj.getImage());
    }
    if (obj.getLocationCoordinate() != null) {
      json.put("locationCoordinate", obj.getLocationCoordinate());
    }
    if (obj.getName() != null) {
      json.put("name", obj.getName());
    }
    if (obj.getOwnerFirstName() != null) {
      json.put("ownerFirstName", obj.getOwnerFirstName());
    }
    if (obj.getOwnerLastName() != null) {
      json.put("ownerLastName", obj.getOwnerLastName());
    }
    if (obj.getPhone() != null) {
      json.put("phone", obj.getPhone());
    }
    if (obj.getPostalCode() != null) {
      json.put("postalCode", obj.getPostalCode());
    }
    if (obj.getSerialNumber() != null) {
      json.put("serialNumber", obj.getSerialNumber());
    }
    if (obj.getType() != null) {
      json.put("type", obj.getType());
    }
    if (obj.getWebsite() != null) {
      json.put("website", obj.getWebsite());
    }
  }
}
