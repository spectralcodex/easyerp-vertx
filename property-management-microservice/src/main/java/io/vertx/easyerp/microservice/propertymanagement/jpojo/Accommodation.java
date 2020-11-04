package io.vertx.easyerp.microservice.propertymanagement.jpojo;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Objects;

@DataObject(generateConverter = true)
public class Accommodation {
    private Long Id;
    private String serialNumber;
    private String name;
    private String abbreviation;
    private String units;
    private Integer dormBedsPerRoom;
    private Integer totalAccommodation;
    private String createdOn;
    private String createdBy;

    public Accommodation(JsonObject json) {
       // AccomodationConverter.fromJson(json, this);
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        //AccomodationConverter.toJson(this, json);
        return json;
    }

    public Accommodation(Accommodation other) {
        Id = other.Id;
        this.serialNumber = other.serialNumber;
        this.name = other.name;
        this.abbreviation = other.abbreviation;
        this.units = other.units;
        this.dormBedsPerRoom = other.dormBedsPerRoom;
        this.totalAccommodation = other.totalAccommodation;
        this.createdOn = other.createdOn;
        this.createdBy = other.createdBy;
    }

    public Long getId() {
        return Id;
    }

    public Accommodation setId(Long id) {
        Id = id;
        return this;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Accommodation setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public String getName() {
        return name;
    }

    public Accommodation setName(String name) {
        this.name = name;
        return this;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Accommodation setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
        return this;
    }

    public String getUnits() {
        return units;
    }

    public Accommodation setUnits(String units) {
        this.units = units;
        return this;
    }

    public Integer getDormBedsPerRoom() {
        return dormBedsPerRoom;
    }

    public Accommodation setDormBedsPerRoom(Integer dormBedsPerRoom) {
        this.dormBedsPerRoom = dormBedsPerRoom;
        return this;
    }

    public Integer getTotalAccommodation() {
        return totalAccommodation;
    }

    public Accommodation setTotalAccommodation(Integer totalAccommodation) {
        this.totalAccommodation = totalAccommodation;
        return this;
    }


    public String getCreatedOn() {
        return createdOn;
    }

    public Accommodation setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Accommodation setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accommodation that = (Accommodation) o;
        return Objects.equals(Id, that.Id) &&
                Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(name, that.name) &&
                Objects.equals(abbreviation, that.abbreviation) &&
                Objects.equals(units, that.units) &&
                Objects.equals(dormBedsPerRoom, that.dormBedsPerRoom) &&
                Objects.equals(totalAccommodation, that.totalAccommodation) &&
                Objects.equals(createdOn, that.createdOn) &&
                Objects.equals(createdBy, that.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, serialNumber, name, abbreviation, units, dormBedsPerRoom, totalAccommodation, createdOn, createdBy);
    }
}
