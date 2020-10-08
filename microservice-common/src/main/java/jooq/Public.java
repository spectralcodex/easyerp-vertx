/*
 * This file is generated by jOOQ.
 */
package jooq;


import java.util.Arrays;
import java.util.List;

import jooq.tables.TbAccomodation;
import jooq.tables.TbPropertyAmenity;
import jooq.tables.TbPropertyProfile;
import jooq.tables.TbUser;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 889629684;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.tb_accomodation</code>.
     */
    public final TbAccomodation TB_ACCOMODATION = TbAccomodation.TB_ACCOMODATION;

    /**
     * The table <code>public.tb_property_amenity</code>.
     */
    public final TbPropertyAmenity TB_PROPERTY_AMENITY = TbPropertyAmenity.TB_PROPERTY_AMENITY;

    /**
     * The table <code>public.tb_property_profile</code>.
     */
    public final TbPropertyProfile TB_PROPERTY_PROFILE = TbPropertyProfile.TB_PROPERTY_PROFILE;

    /**
     * The table <code>public.tb_user</code>.
     */
    public final TbUser TB_USER = TbUser.TB_USER;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        return Arrays.<Sequence<?>>asList(
            Sequences.TB_ACCOMODATION_ID_SEQ,
            Sequences.TB_PROPERTY_AMENITY_ID_SEQ,
            Sequences.TB_PROPERTY_PROFILE_ID_SEQ,
            Sequences.TB_USER_ID_SEQ);
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            TbAccomodation.TB_ACCOMODATION,
            TbPropertyAmenity.TB_PROPERTY_AMENITY,
            TbPropertyProfile.TB_PROPERTY_PROFILE,
            TbUser.TB_USER);
    }
}
