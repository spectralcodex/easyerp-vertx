package io.vertx.easyerp.microservice.propertymanagement.jpojo;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import java.util.Objects;

@DataObject(generateConverter = true)
public class PropertyAmenity {
    private Long Id;
    private String serialNumber;
    private String amenity;
    private String status;
    private String createdOn;
    private String createdBy;

    public PropertyAmenity(JsonObject json){
        PropertyAmenityConverter.fromJson(json, this);
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        PropertyAmenityConverter.toJson(this, json);
        return json;
    }

    public PropertyAmenity(PropertyAmenity other) {
        Id = other.Id;
        this.serialNumber = other.serialNumber;
        this.amenity = other.amenity;
        this.status = other.status;
        this.createdOn = other.createdOn;
        this.createdBy = other.createdBy;
    }

    public Long getId() {
        return Id;
    }

    public PropertyAmenity setId(Long id) {
        Id = id;
        return this;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public PropertyAmenity setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public String getAmenity() {
        return amenity;
    }

    public PropertyAmenity setAmenity(String amenity) {
        this.amenity = amenity;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public PropertyAmenity setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public PropertyAmenity setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public PropertyAmenity setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyAmenity that = (PropertyAmenity) o;
        return Objects.equals(Id, that.Id) &&
                Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(amenity, that.amenity) &&
                Objects.equals(status, that.status) &&
                Objects.equals(createdOn, that.createdOn) &&
                Objects.equals(createdBy, that.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, serialNumber, amenity, status, createdOn, createdBy);
    }
}
