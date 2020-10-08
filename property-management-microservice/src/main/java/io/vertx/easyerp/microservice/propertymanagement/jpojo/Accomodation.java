package io.vertx.easyerp.microservice.propertymanagement.jpojo;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Objects;

@DataObject(generateConverter = true)
public class Accomodation {
    private Long Id;
    private String serialNumber;
    private String name;
    private String abbreviation;
    private String units;
    private String dormBedsPerRoom;
    private String totalAccommodation;
    private String createdOn;
    private String createdBy;

    public Accomodation(JsonObject json) {
       // PropertyProfileConverter.fromJson(json, this);
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        //PropertyProfileConverter.toJson(this, json);
        return json;
    }

    public Accomodation(Accomodation other) {
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

    public Accomodation setId(Long id) {
        Id = id;
        return this;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Accomodation setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public String getName() {
        return name;
    }

    public Accomodation setName(String name) {
        this.name = name;
        return this;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Accomodation setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
        return this;
    }

    public String getUnits() {
        return units;
    }

    public Accomodation setUnits(String units) {
        this.units = units;
        return this;
    }

    public String getDormBedsPerRoom() {
        return dormBedsPerRoom;
    }

    public Accomodation setDormBedsPerRoom(String dormBedsPerRoom) {
        this.dormBedsPerRoom = dormBedsPerRoom;
        return this;
    }

    public String getTotalAccommodation() {
        return totalAccommodation;
    }

    public Accomodation setTotalAccommodation(String totalAccommodation) {
        this.totalAccommodation = totalAccommodation;
        return this;
    }


    public String getCreatedOn() {
        return createdOn;
    }

    public Accomodation setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Accomodation setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accomodation that = (Accomodation) o;
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
