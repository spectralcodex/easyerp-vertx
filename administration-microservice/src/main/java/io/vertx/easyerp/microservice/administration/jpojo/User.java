package io.vertx.easyerp.microservice.administration.jpojo;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Objects;

@DataObject(generateConverter = true)
public class User {

    private Long Id;
    private String firstName;
    private String lastName;
    private String age;

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
        this.age = other.age;
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

    public String getAge() {
        return age;
    }

    public User setAge(String age) {
        this.age = age;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(Id, user.Id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, firstName, lastName, age);
    }

    @Override
    public String toString() {
        return this.toJson().encodePrettily();
    }
}
