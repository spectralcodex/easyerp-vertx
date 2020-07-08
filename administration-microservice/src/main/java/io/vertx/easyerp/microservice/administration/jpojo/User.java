package io.vertx.easyerp.microservice.administration.jpojo;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Objects;

@DataObject(generateConverter = true)
public class User {

    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String secret;
    private String salt;
    private String companyCode;
    private String createdBy;

    public User(JsonObject json) {
        UserConverter.fromJson(json, this);
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        UserConverter.toJson(this, json);
        return json;
    }

    public User(User other) {
        this.Id = other.Id;
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.email = other.email;
        this.mobile = other.mobile;
        this.secret = other.secret;
        this.salt = other.salt;
        this.companyCode = other.companyCode;
        this.createdBy = other.createdBy;
    }

    public Long getId() {
        return Id;
    }

    public User setId(Long id) {
        this.Id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }


    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public User setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public User setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public User setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public User setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public User setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    @Override
    public String toString() {
        return this.toJson().encodePrettily();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(Id, user.Id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(mobile, user.mobile) &&
                Objects.equals(secret, user.secret) &&
                Objects.equals(salt, user.salt) &&
                Objects.equals(companyCode, user.companyCode) &&
                Objects.equals(createdBy, user.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, firstName, lastName, email, mobile, secret, salt, companyCode, createdBy);
    }
}
