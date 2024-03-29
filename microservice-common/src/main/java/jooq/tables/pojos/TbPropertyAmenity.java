/*
 * This file is generated by jOOQ.
 */
package jooq.tables.pojos;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.sql.Timestamp;

import javax.annotation.Generated;

import jooq.tables.interfaces.ITbPropertyAmenity;


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
public class TbPropertyAmenity implements VertxPojo, ITbPropertyAmenity {

    private static final long serialVersionUID = 1700635697;

    private Long      id;
    private String    serialnumber;
    private String    amenity;
    private String    status;
    private Timestamp createdon;
    private String    createdby;

    public TbPropertyAmenity() {}

    public TbPropertyAmenity(ITbPropertyAmenity value) {
        this.id = value.getId();
        this.serialnumber = value.getSerialnumber();
        this.amenity = value.getAmenity();
        this.status = value.getStatus();
        this.createdon = value.getCreatedon();
        this.createdby = value.getCreatedby();
    }

    public TbPropertyAmenity(
        Long      id,
        String    serialnumber,
        String    amenity,
        String    status,
        Timestamp createdon,
        String    createdby
    ) {
        this.id = id;
        this.serialnumber = serialnumber;
        this.amenity = amenity;
        this.status = status;
        this.createdon = createdon;
        this.createdby = createdby;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public TbPropertyAmenity setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String getSerialnumber() {
        return this.serialnumber;
    }

    @Override
    public TbPropertyAmenity setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
        return this;
    }

    @Override
    public String getAmenity() {
        return this.amenity;
    }

    @Override
    public TbPropertyAmenity setAmenity(String amenity) {
        this.amenity = amenity;
        return this;
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public TbPropertyAmenity setStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public Timestamp getCreatedon() {
        return this.createdon;
    }

    @Override
    public TbPropertyAmenity setCreatedon(Timestamp createdon) {
        this.createdon = createdon;
        return this;
    }

    @Override
    public String getCreatedby() {
        return this.createdby;
    }

    @Override
    public TbPropertyAmenity setCreatedby(String createdby) {
        this.createdby = createdby;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TbPropertyAmenity (");

        sb.append(id);
        sb.append(", ").append(serialnumber);
        sb.append(", ").append(amenity);
        sb.append(", ").append(status);
        sb.append(", ").append(createdon);
        sb.append(", ").append(createdby);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public void from(ITbPropertyAmenity from) {
        setId(from.getId());
        setSerialnumber(from.getSerialnumber());
        setAmenity(from.getAmenity());
        setStatus(from.getStatus());
        setCreatedon(from.getCreatedon());
        setCreatedby(from.getCreatedby());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends ITbPropertyAmenity> E into(E into) {
        into.from(this);
        return into;
    }

    public TbPropertyAmenity(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }
}
