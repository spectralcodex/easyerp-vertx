/*
 * This file is generated by jOOQ.
 */
package jooq.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import jooq.Keys;
import jooq.Public;
import jooq.tables.records.TbPropertyAmenityRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbPropertyAmenity extends TableImpl<TbPropertyAmenityRecord> {

    private static final long serialVersionUID = 2022714357;

    /**
     * The reference instance of <code>public.tb_property_amenity</code>
     */
    public static final TbPropertyAmenity TB_PROPERTY_AMENITY = new TbPropertyAmenity();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbPropertyAmenityRecord> getRecordType() {
        return TbPropertyAmenityRecord.class;
    }

    /**
     * The column <code>public.tb_property_amenity.id</code>.
     */
    public final TableField<TbPropertyAmenityRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(DSL.field("nextval('tb_property_amenity_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.tb_property_amenity.serialNumber</code>.
     */
    public final TableField<TbPropertyAmenityRecord, String> SERIALNUMBER = createField(DSL.name("serialNumber"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.tb_property_amenity.amenity</code>.
     */
    public final TableField<TbPropertyAmenityRecord, String> AMENITY = createField(DSL.name("amenity"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.tb_property_amenity.status</code>.
     */
    public final TableField<TbPropertyAmenityRecord, String> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.VARCHAR(5), this, "");

    /**
     * The column <code>public.tb_property_amenity.createdOn</code>.
     */
    public final TableField<TbPropertyAmenityRecord, LocalDateTime> CREATEDON = createField(DSL.name("createdOn"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.tb_property_amenity.createdBy</code>.
     */
    public final TableField<TbPropertyAmenityRecord, String> CREATEDBY = createField(DSL.name("createdBy"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * Create a <code>public.tb_property_amenity</code> table reference
     */
    public TbPropertyAmenity() {
        this(DSL.name("tb_property_amenity"), null);
    }

    /**
     * Create an aliased <code>public.tb_property_amenity</code> table reference
     */
    public TbPropertyAmenity(String alias) {
        this(DSL.name(alias), TB_PROPERTY_AMENITY);
    }

    /**
     * Create an aliased <code>public.tb_property_amenity</code> table reference
     */
    public TbPropertyAmenity(Name alias) {
        this(alias, TB_PROPERTY_AMENITY);
    }

    private TbPropertyAmenity(Name alias, Table<TbPropertyAmenityRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbPropertyAmenity(Name alias, Table<TbPropertyAmenityRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> TbPropertyAmenity(Table<O> child, ForeignKey<O, TbPropertyAmenityRecord> key) {
        super(child, key, TB_PROPERTY_AMENITY);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<TbPropertyAmenityRecord, Long> getIdentity() {
        return Keys.IDENTITY_TB_PROPERTY_AMENITY;
    }

    @Override
    public UniqueKey<TbPropertyAmenityRecord> getPrimaryKey() {
        return Keys.TB_PROPERTY_AMENITY_PKEY;
    }

    @Override
    public List<UniqueKey<TbPropertyAmenityRecord>> getKeys() {
        return Arrays.<UniqueKey<TbPropertyAmenityRecord>>asList(Keys.TB_PROPERTY_AMENITY_PKEY);
    }

    @Override
    public TbPropertyAmenity as(String alias) {
        return new TbPropertyAmenity(DSL.name(alias), this);
    }

    @Override
    public TbPropertyAmenity as(Name alias) {
        return new TbPropertyAmenity(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TbPropertyAmenity rename(String name) {
        return new TbPropertyAmenity(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TbPropertyAmenity rename(Name name) {
        return new TbPropertyAmenity(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, String, String, String, LocalDateTime, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
