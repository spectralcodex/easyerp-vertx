/*
 * This file is generated by jOOQ.
 */
package jooq.tables.interfaces;


import io.github.jklingsporn.vertx.jooq.shared.UnexpectedJsonValueType;
import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface ITbUser extends VertxPojo, Serializable {

    /**
     * Setter for <code>public.tb_user.id</code>.
     */
    public ITbUser setId(Long value);

    /**
     * Getter for <code>public.tb_user.id</code>.
     */
    public Long getId();

    /**
     * Setter for <code>public.tb_user.roleId</code>.
     */
    public ITbUser setRoleid(Long value);

    /**
     * Getter for <code>public.tb_user.roleId</code>.
     */
    public Long getRoleid();

    /**
     * Setter for <code>public.tb_user.firstName</code>.
     */
    public ITbUser setFirstname(String value);

    /**
     * Getter for <code>public.tb_user.firstName</code>.
     */
    public String getFirstname();

    /**
     * Setter for <code>public.tb_user.lastName</code>.
     */
    public ITbUser setLastname(String value);

    /**
     * Getter for <code>public.tb_user.lastName</code>.
     */
    public String getLastname();

    /**
     * Setter for <code>public.tb_user.email</code>.
     */
    public ITbUser setEmail(String value);

    /**
     * Getter for <code>public.tb_user.email</code>.
     */
    public String getEmail();

    /**
     * Setter for <code>public.tb_user.mobile</code>.
     */
    public ITbUser setMobile(String value);

    /**
     * Getter for <code>public.tb_user.mobile</code>.
     */
    public String getMobile();

    /**
     * Setter for <code>public.tb_user.hashedPassword</code>.
     */
    public ITbUser setHashedpassword(String value);

    /**
     * Getter for <code>public.tb_user.hashedPassword</code>.
     */
    public String getHashedpassword();

    /**
     * Setter for <code>public.tb_user.passwordSalt</code>.
     */
    public ITbUser setPasswordsalt(String value);

    /**
     * Getter for <code>public.tb_user.passwordSalt</code>.
     */
    public String getPasswordsalt();

    /**
     * Setter for <code>public.tb_user.companyCode</code>.
     */
    public ITbUser setCompanycode(String value);

    /**
     * Getter for <code>public.tb_user.companyCode</code>.
     */
    public String getCompanycode();

    /**
     * Setter for <code>public.tb_user.createdOn</code>.
     */
    public ITbUser setCreatedon(String value);

    /**
     * Getter for <code>public.tb_user.createdOn</code>.
     */
    public String getCreatedon();

    /**
     * Setter for <code>public.tb_user.createdBy</code>.
     */
    public ITbUser setCreatedby(String value);

    /**
     * Getter for <code>public.tb_user.createdBy</code>.
     */
    public String getCreatedby();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface ITbUser
     */
    public void from(ITbUser from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface ITbUser
     */
    public <E extends ITbUser> E into(E into);

    @Override
    public default ITbUser fromJson(io.vertx.core.json.JsonObject json) {
        try {
            setId(json.getLong("id"));
        } catch (ClassCastException e) {
            throw new UnexpectedJsonValueType("id","java.lang.Long",e);
        }
        try {
            setRoleid(json.getLong("roleId"));
        } catch (ClassCastException e) {
            throw new UnexpectedJsonValueType("roleId","java.lang.Long",e);
        }
        try {
            setFirstname(json.getString("firstName"));
        } catch (ClassCastException e) {
            throw new UnexpectedJsonValueType("firstName","java.lang.String",e);
        }
        try {
            setLastname(json.getString("lastName"));
        } catch (ClassCastException e) {
            throw new UnexpectedJsonValueType("lastName","java.lang.String",e);
        }
        try {
            setEmail(json.getString("email"));
        } catch (ClassCastException e) {
            throw new UnexpectedJsonValueType("email","java.lang.String",e);
        }
        try {
            setMobile(json.getString("mobile"));
        } catch (ClassCastException e) {
            throw new UnexpectedJsonValueType("mobile","java.lang.String",e);
        }
        try {
            setHashedpassword(json.getString("hashedPassword"));
        } catch (ClassCastException e) {
            throw new UnexpectedJsonValueType("hashedPassword","java.lang.String",e);
        }
        try {
            setPasswordsalt(json.getString("passwordSalt"));
        } catch (ClassCastException e) {
            throw new UnexpectedJsonValueType("passwordSalt","java.lang.String",e);
        }
        try {
            setCompanycode(json.getString("companyCode"));
        } catch (ClassCastException e) {
            throw new UnexpectedJsonValueType("companyCode","java.lang.String",e);
        }
        try {
            setCreatedon(json.getString("createdOn"));
        } catch (ClassCastException e) {
            throw new UnexpectedJsonValueType("createdOn","java.lang.String",e);
        }
        try {
            setCreatedby(json.getString("createdBy"));
        } catch (ClassCastException e) {
            throw new UnexpectedJsonValueType("createdBy","java.lang.String",e);
        }
        return this;
    }


    @Override
    public default io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("id",getId());
        json.put("roleId",getRoleid());
        json.put("firstName",getFirstname());
        json.put("lastName",getLastname());
        json.put("email",getEmail());
        json.put("mobile",getMobile());
        json.put("hashedPassword",getHashedpassword());
        json.put("passwordSalt",getPasswordsalt());
        json.put("companyCode",getCompanycode());
        json.put("createdOn",getCreatedon());
        json.put("createdBy",getCreatedby());
        return json;
    }

}
