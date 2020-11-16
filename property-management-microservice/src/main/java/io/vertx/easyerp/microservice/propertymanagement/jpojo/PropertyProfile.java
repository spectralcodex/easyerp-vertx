package io.vertx.easyerp.microservice.propertymanagement.jpojo;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Objects;

@DataObject(generateConverter = true)
public class PropertyProfile {
    private Long Id;
    private String serialNumber;
    private String type;
    private String description;
    private String profileCode;
    private String image;
    private String name;
    private String phone;
    private String email;
    private String website;
    private String ownerFirstName;
    private String ownerLastName;
    private String country;
    private String address1;
    private String address2;
    private String city;
    private String postalCode;
    private String locationCoordinate;
    private String createdOn;
    private String createdBy;


    public PropertyProfile(JsonObject json) {
        PropertyProfileConverter.fromJson(json, this);
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        PropertyProfileConverter.toJson(this, json);
        return json;
    }

    public PropertyProfile(PropertyProfile other) {
        this.Id = other.Id;
        this.serialNumber = other.serialNumber;
        this.type = other.type;
        this.description = other.description;
        this.profileCode = other.profileCode;
        this.image = other.image;
        this.name = other.name;
        this.phone = other.phone;
        this.email = other.email;
        this.website = other.website;
        this.ownerFirstName = other.ownerFirstName;
        this.ownerLastName = other.ownerLastName;
        this.country = other.country;
        this.address1 = other.address1;
        this.address2 = other.address2;
        this.city = other.city;
        this.postalCode = other.postalCode;
        this.locationCoordinate = other.locationCoordinate;
        this.createdOn = other.createdOn;
        this.createdBy = other.createdBy;
    }

    public Long getId() {
        return Id;
    }

    public PropertyProfile setId(Long id) {
        this.Id = id;
        return this;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public PropertyProfile setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public String getType() {
        return type;
    }

    public PropertyProfile setType(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PropertyProfile setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImage() {
        return image;
    }

    public PropertyProfile setImage(String image) {
        this.image = image;
        return this;
    }

    public String getName() {
        return name;
    }

    public PropertyProfile setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public PropertyProfile setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PropertyProfile setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public PropertyProfile setWebsite(String website) {
        this.website = website;
        return this;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public PropertyProfile setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
        return this;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public PropertyProfile setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public PropertyProfile setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getAddress1() {
        return address1;
    }

    public PropertyProfile setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public String getAddress2() {
        return address2;
    }

    public PropertyProfile setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public String getCity() {
        return city;
    }

    public PropertyProfile setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public PropertyProfile setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getLocationCoordinate() {
        return locationCoordinate;
    }

    public PropertyProfile setLocationCoordinate(String locationCoordinates) {
        this.locationCoordinate = locationCoordinate;
        return this;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public PropertyProfile setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public PropertyProfile setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getProfileCode() {
        return profileCode;
    }

    public PropertyProfile setProfileCode(String profileCode) {
        this.profileCode = profileCode;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyProfile that = (PropertyProfile) o;
        return Objects.equals(Id, that.Id) &&
                Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(type, that.type) &&
                Objects.equals(description, that.description) &&
                Objects.equals(profileCode, that.profileCode) &&
                Objects.equals(image, that.image) &&
                Objects.equals(name, that.name) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(website, that.website) &&
                Objects.equals(ownerFirstName, that.ownerFirstName) &&
                Objects.equals(ownerLastName, that.ownerLastName) &&
                Objects.equals(country, that.country) &&
                Objects.equals(address1, that.address1) &&
                Objects.equals(address2, that.address2) &&
                Objects.equals(city, that.city) &&
                Objects.equals(postalCode, that.postalCode) &&
                Objects.equals(locationCoordinate, that.locationCoordinate) &&
                Objects.equals(createdOn, that.createdOn) &&
                Objects.equals(createdBy, that.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, serialNumber, type, description, profileCode, image, name, phone, email, website, ownerFirstName, ownerLastName, country, address1, address2, city, postalCode, locationCoordinate, createdOn, createdBy);
    }

    @Override
    public String toString() {
        return "PropertyProfile{" +
                "Id=" + Id +
                ", serialNumber='" + serialNumber + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", profileCode='" + profileCode + '\'' +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", ownerFirstName='" + ownerFirstName + '\'' +
                ", ownerLastName='" + ownerLastName + '\'' +
                ", country='" + country + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", locationCoordinate='" + locationCoordinate + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
