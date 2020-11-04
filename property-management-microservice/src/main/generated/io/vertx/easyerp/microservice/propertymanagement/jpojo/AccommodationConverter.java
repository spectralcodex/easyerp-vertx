package io.vertx.easyerp.microservice.propertymanagement.jpojo;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * Converter for {@link io.vertx.easyerp.microservice.propertymanagement.jpojo.Accommodation}.
 * NOTE: This class has been automatically generated from the {@link io.vertx.easyerp.microservice.propertymanagement.jpojo.Accommodation} original class using Vert.x codegen.
 */
public class AccommodationConverter {

  public static void fromJson(Iterable<java.util.Map.Entry<String, Object>> json, Accommodation obj) {
    for (java.util.Map.Entry<String, Object> member : json) {
      switch (member.getKey()) {
        case "abbreviation":
          if (member.getValue() instanceof String) {
            obj.setAbbreviation((String)member.getValue());
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
        case "dormBedsPerRoom":
          if (member.getValue() instanceof Number) {
            obj.setDormBedsPerRoom(((Number)member.getValue()).intValue());
          }
          break;
        case "id":
          if (member.getValue() instanceof Number) {
            obj.setId(((Number)member.getValue()).longValue());
          }
          break;
        case "name":
          if (member.getValue() instanceof String) {
            obj.setName((String)member.getValue());
          }
          break;
        case "serialNumber":
          if (member.getValue() instanceof String) {
            obj.setSerialNumber((String)member.getValue());
          }
          break;
        case "totalAccommodation":
          if (member.getValue() instanceof Number) {
            obj.setTotalAccommodation(((Number)member.getValue()).intValue());
          }
          break;
        case "units":
          if (member.getValue() instanceof String) {
            obj.setUnits((String)member.getValue());
          }
          break;
      }
    }
  }

  public static void toJson(Accommodation obj, JsonObject json) {
    toJson(obj, json.getMap());
  }

  public static void toJson(Accommodation obj, java.util.Map<String, Object> json) {
    if (obj.getAbbreviation() != null) {
      json.put("abbreviation", obj.getAbbreviation());
    }
    if (obj.getCreatedBy() != null) {
      json.put("createdBy", obj.getCreatedBy());
    }
    if (obj.getCreatedOn() != null) {
      json.put("createdOn", obj.getCreatedOn());
    }
    if (obj.getDormBedsPerRoom() != null) {
      json.put("dormBedsPerRoom", obj.getDormBedsPerRoom());
    }
    if (obj.getId() != null) {
      json.put("id", obj.getId());
    }
    if (obj.getName() != null) {
      json.put("name", obj.getName());
    }
    if (obj.getSerialNumber() != null) {
      json.put("serialNumber", obj.getSerialNumber());
    }
    if (obj.getTotalAccommodation() != null) {
      json.put("totalAccommodation", obj.getTotalAccommodation());
    }
    if (obj.getUnits() != null) {
      json.put("units", obj.getUnits());
    }
  }
}
