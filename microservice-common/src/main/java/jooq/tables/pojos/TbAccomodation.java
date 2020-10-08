/*
 * This file is generated by jOOQ.
 */
package jooq.tables.pojos;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.time.OffsetDateTime;

import jooq.tables.interfaces.ITbAccomodation;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbAccomodation implements VertxPojo, ITbAccomodation {

    private static final long serialVersionUID = 153725225;

    private Long           id;
    private String         serialnumber;
    private String         name;
    private String         abbrevation;
    private String         units;
    private Integer        dormbedsperroom;
    private Integer        totalaccomodation;
    private OffsetDateTime createdon;
    private String         createdby;

    public TbAccomodation() {}

    public TbAccomodation(ITbAccomodation value) {
        this.id = value.getId();
        this.serialnumber = value.getSerialnumber();
        this.name = value.getName();
        this.abbrevation = value.getAbbrevation();
        this.units = value.getUnits();
        this.dormbedsperroom = value.getDormbedsperroom();
        this.totalaccomodation = value.getTotalaccomodation();
        this.createdon = value.getCreatedon();
        this.createdby = value.getCreatedby();
    }

    public TbAccomodation(
        Long           id,
        String         serialnumber,
        String         name,
        String         abbrevation,
        String         units,
        Integer        dormbedsperroom,
        Integer        totalaccomodation,
        OffsetDateTime createdon,
        String         createdby
    ) {
        this.id = id;
        this.serialnumber = serialnumber;
        this.name = name;
        this.abbrevation = abbrevation;
        this.units = units;
        this.dormbedsperroom = dormbedsperroom;
        this.totalaccomodation = totalaccomodation;
        this.createdon = createdon;
        this.createdby = createdby;
    }

    public TbAccomodation(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public TbAccomodation setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String getSerialnumber() {
        return this.serialnumber;
    }

    @Override
    public TbAccomodation setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
        return this;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public TbAccomodation setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String getAbbrevation() {
        return this.abbrevation;
    }

    @Override
    public TbAccomodation setAbbrevation(String abbrevation) {
        this.abbrevation = abbrevation;
        return this;
    }

    @Override
    public String getUnits() {
        return this.units;
    }

    @Override
    public TbAccomodation setUnits(String units) {
        this.units = units;
        return this;
    }

    @Override
    public Integer getDormbedsperroom() {
        return this.dormbedsperroom;
    }

    @Override
    public TbAccomodation setDormbedsperroom(Integer dormbedsperroom) {
        this.dormbedsperroom = dormbedsperroom;
        return this;
    }

    @Override
    public Integer getTotalaccomodation() {
        return this.totalaccomodation;
    }

    @Override
    public TbAccomodation setTotalaccomodation(Integer totalaccomodation) {
        this.totalaccomodation = totalaccomodation;
        return this;
    }

    @Override
    public OffsetDateTime getCreatedon() {
        return this.createdon;
    }

    @Override
    public TbAccomodation setCreatedon(OffsetDateTime createdon) {
        this.createdon = createdon;
        return this;
    }

    @Override
    public String getCreatedby() {
        return this.createdby;
    }

    @Override
    public TbAccomodation setCreatedby(String createdby) {
        this.createdby = createdby;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TbAccomodation (");

        sb.append(id);
        sb.append(", ").append(serialnumber);
        sb.append(", ").append(name);
        sb.append(", ").append(abbrevation);
        sb.append(", ").append(units);
        sb.append(", ").append(dormbedsperroom);
        sb.append(", ").append(totalaccomodation);
        sb.append(", ").append(createdon);
        sb.append(", ").append(createdby);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ITbAccomodation from) {
        setId(from.getId());
        setSerialnumber(from.getSerialnumber());
        setName(from.getName());
        setAbbrevation(from.getAbbrevation());
        setUnits(from.getUnits());
        setDormbedsperroom(from.getDormbedsperroom());
        setTotalaccomodation(from.getTotalaccomodation());
        setCreatedon(from.getCreatedon());
        setCreatedby(from.getCreatedby());
    }

    @Override
    public <E extends ITbAccomodation> E into(E into) {
        into.from(this);
        return into;
    }
}
