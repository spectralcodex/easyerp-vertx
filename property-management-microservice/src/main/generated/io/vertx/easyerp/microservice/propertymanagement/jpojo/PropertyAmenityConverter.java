package io.vertx.easyerp.microservice.propertymanagement.jpojo;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * Converter for {@link io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyAmenity}.
 * NOTE: This class has been automatically generated from the {@link io.vertx.easyerp.microservice.propertymanagement.jpojo.PropertyAmenity} original class using Vert.x codegen.
 */
public class PropertyAmenityConverter {

  public static void fromJson(Iterable<java.util.Map.Entry<String, Object>> json, PropertyAmenity obj) {
    for (java.util.Map.Entry<String, Object> member : json) {
      switch (member.getKey()) {
        case "amenity":
          if (member.getValue() instanceof String) {
            obj.setAmenity((String)member.getValue());
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
        case "id":
          if (member.getValue() instanceof Number) {
            obj.setId(((Number)member.getValue()).longValue());
          }
          break;
        case "serialNumber":
          if (member.getValue() instanceof String) {
            obj.setSerialNumber((String)member.getValue());
          }
          break;
        case "status":
          if (member.getValue() instanceof String) {
            obj.setStatus((String)member.getValue());
          }
          break;
      }
    }
  }

  public static void toJson(PropertyAmenity obj, JsonObject json) {
    toJson(obj, json.getMap());
  }

  public static void toJson(PropertyAmenity obj, java.util.Map<String, Object> json) {
    if (obj.getAmenity() != null) {
      json.put("amenity", obj.getAmenity());
    }
    if (obj.getCreatedBy() != null) {
      json.put("createdBy", obj.getCreatedBy());
    }
    if (obj.getCreatedOn() != null) {
      json.put("createdOn", obj.getCreatedOn());
    }
    if (obj.getId() != null) {
      json.put("id", obj.getId());
    }
    if (obj.getSerialNumber() != null) {
      json.put("serialNumber", obj.getSerialNumber());
    }
    if (obj.getStatus() != null) {
      json.put("status", obj.getStatus());
    }
  }
}
