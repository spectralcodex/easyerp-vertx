/*
 * This file is generated by jOOQ.
 */
package jooq.tables;


import java.time.OffsetTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import jooq.Indexes;
import jooq.Keys;
import jooq.Public;
import jooq.tables.records.TbUserRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This table contains user login credentials and assigned user role
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbUser extends TableImpl<TbUserRecord> {

    private static final long serialVersionUID = -1629584800;

    /**
     * The reference instance of <code>public.tb_user</code>
     */
    public static final TbUser TB_USER = new TbUser();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbUserRecord> getRecordType() {
        return TbUserRecord.class;
    }

    /**
     * The column <code>public.tb_user.id</code>.
     */
    public final TableField<TbUserRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(DSL.field("nextval('user_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.tb_user.role_id</code>.
     */
    public final TableField<TbUserRecord, Long> ROLE_ID = createField("role_id", org.jooq.impl.SQLDataType.BIGINT.defaultValue(DSL.field("0", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.tb_user.first_name</code>.
     */
    public final TableField<TbUserRecord, String> FIRST_NAME = createField("first_name", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.tb_user.last_name</code>.
     */
    public final TableField<TbUserRecord, String> LAST_NAME = createField("last_name", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.tb_user.email</code>.
     */
    public final TableField<TbUserRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.tb_user.mobile</code>.
     */
    public final TableField<TbUserRecord, String> MOBILE = createField("mobile", org.jooq.impl.SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * The column <code>public.tb_user.secret</code>.
     */
    public final TableField<TbUserRecord, String> SECRET = createField("secret", org.jooq.impl.SQLDataType.VARCHAR(500), this, "");

    /**
     * The column <code>public.tb_user.salt</code>.
     */
    public final TableField<TbUserRecord, String> SALT = createField("salt", org.jooq.impl.SQLDataType.VARCHAR(500), this, "");

    /**
     * The column <code>public.tb_user.company_code</code>.
     */
    public final TableField<TbUserRecord, String> COMPANY_CODE = createField("company_code", org.jooq.impl.SQLDataType.VARCHAR(4).nullable(false), this, "");

    /**
     * The column <code>public.tb_user.created_on</code>.
     */
    public final TableField<TbUserRecord, OffsetTime> CREATED_ON = createField("created_on", org.jooq.impl.SQLDataType.TIMEWITHTIMEZONE.defaultValue(DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMEWITHTIMEZONE)), this, "");

    /**
     * The column <code>public.tb_user.created_by</code>.
     */
    public final TableField<TbUserRecord, String> CREATED_BY = createField("created_by", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * Create a <code>public.tb_user</code> table reference
     */
    public TbUser() {
        this(DSL.name("tb_user"), null);
    }

    /**
     * Create an aliased <code>public.tb_user</code> table reference
     */
    public TbUser(String alias) {
        this(DSL.name(alias), TB_USER);
    }

    /**
     * Create an aliased <code>public.tb_user</code> table reference
     */
    public TbUser(Name alias) {
        this(alias, TB_USER);
    }

    private TbUser(Name alias, Table<TbUserRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbUser(Name alias, Table<TbUserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("This table contains user login credentials and assigned user role"));
    }

    public <O extends Record> TbUser(Table<O> child, ForeignKey<O, TbUserRecord> key) {
        super(child, key, TB_USER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TB_USER_EMAIL_KEY, Indexes.TB_USER_MOBILE_KEY, Indexes.USER_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TbUserRecord, Long> getIdentity() {
        return Keys.IDENTITY_TB_USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TbUserRecord> getPrimaryKey() {
        return Keys.USER_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TbUserRecord>> getKeys() {
        return Arrays.<UniqueKey<TbUserRecord>>asList(Keys.USER_PKEY, Keys.TB_USER_EMAIL_KEY, Keys.TB_USER_MOBILE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbUser as(String alias) {
        return new TbUser(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbUser as(Name alias) {
        return new TbUser(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TbUser rename(String name) {
        return new TbUser(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TbUser rename(Name name) {
        return new TbUser(name, null);
    }
}
