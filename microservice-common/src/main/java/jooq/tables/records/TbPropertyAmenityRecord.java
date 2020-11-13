/*
 * This file is generated by jOOQ.
 */
package jooq.tables.records;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.sql.Timestamp;

import javax.annotation.Generated;

import jooq.tables.TbPropertyAmenity;
import jooq.tables.interfaces.ITbPropertyAmenity;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


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
public class TbPropertyAmenityRecord extends UpdatableRecordImpl<TbPropertyAmenityRecord> implements VertxPojo, Record6<Long, String, String, String, Timestamp, String>, ITbPropertyAmenity {

    private static final long serialVersionUID = 1428885243;

    /**
     * Setter for <code>public.tb_property_amenity.id</code>.
     */
    @Override
    public TbPropertyAmenityRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.tb_property_amenity.id</code>.
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.tb_property_amenity.serialNumber</code>.
     */
    @Override
    public TbPropertyAmenityRecord setSerialnumber(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.tb_property_amenity.serialNumber</code>.
     */
    @Override
    public String getSerialnumber() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.tb_property_amenity.amenity</code>.
     */
    @Override
    public TbPropertyAmenityRecord setAmenity(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.tb_property_amenity.amenity</code>.
     */
    @Override
    public String getAmenity() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.tb_property_amenity.status</code>.
     */
    @Override
    public TbPropertyAmenityRecord setStatus(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.tb_property_amenity.status</code>.
     */
    @Override
    public String getStatus() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.tb_property_amenity.createdOn</code>.
     */
    @Override
    public TbPropertyAmenityRecord setCreatedon(Timestamp value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.tb_property_amenity.createdOn</code>.
     */
    @Override
    public Timestamp getCreatedon() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>public.tb_property_amenity.createdBy</code>.
     */
    @Override
    public TbPropertyAmenityRecord setCreatedby(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.tb_property_amenity.createdBy</code>.
     */
    @Override
    public String getCreatedby() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Long, String, String, String, Timestamp, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Long, String, String, String, Timestamp, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return TbPropertyAmenity.TB_PROPERTY_AMENITY.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TbPropertyAmenity.TB_PROPERTY_AMENITY.SERIALNUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TbPropertyAmenity.TB_PROPERTY_AMENITY.AMENITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return TbPropertyAmenity.TB_PROPERTY_AMENITY.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return TbPropertyAmenity.TB_PROPERTY_AMENITY.CREATEDON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return TbPropertyAmenity.TB_PROPERTY_AMENITY.CREATEDBY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getSerialnumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getAmenity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getCreatedon();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getCreatedby();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getSerialnumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getAmenity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getCreatedon();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getCreatedby();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbPropertyAmenityRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbPropertyAmenityRecord value2(String value) {
        setSerialnumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbPropertyAmenityRecord value3(String value) {
        setAmenity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbPropertyAmenityRecord value4(String value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbPropertyAmenityRecord value5(Timestamp value) {
        setCreatedon(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbPropertyAmenityRecord value6(String value) {
        setCreatedby(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbPropertyAmenityRecord values(Long value1, String value2, String value3, String value4, Timestamp value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
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

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TbPropertyAmenityRecord
     */
    public TbPropertyAmenityRecord() {
        super(TbPropertyAmenity.TB_PROPERTY_AMENITY);
    }

    /**
     * Create a detached, initialised TbPropertyAmenityRecord
     */
    public TbPropertyAmenityRecord(Long id, String serialnumber, String amenity, String status, Timestamp createdon, String createdby) {
        super(TbPropertyAmenity.TB_PROPERTY_AMENITY);

        set(0, id);
        set(1, serialnumber);
        set(2, amenity);
        set(3, status);
        set(4, createdon);
        set(5, createdby);
    }

    public TbPropertyAmenityRecord(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }
}
