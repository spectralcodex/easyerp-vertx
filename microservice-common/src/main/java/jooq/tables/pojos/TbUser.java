/*
 * This file is generated by jOOQ.
 */
package jooq.tables.pojos;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.time.OffsetDateTime;

import jooq.tables.interfaces.ITbUser;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbUser implements VertxPojo, ITbUser {

    private static final long serialVersionUID = 1636160226;

    private Long           id;
    private String         roleid;
    private String         firstname;
    private String         lastname;
    private String         email;
    private String         mobile;
    private String         hashedpassword;
    private String         passwordsalt;
    private String         companycode;
    private OffsetDateTime createdon;
    private String         createdby;

    public TbUser() {}

    public TbUser(ITbUser value) {
        this.id = value.getId();
        this.roleid = value.getRoleid();
        this.firstname = value.getFirstname();
        this.lastname = value.getLastname();
        this.email = value.getEmail();
        this.mobile = value.getMobile();
        this.hashedpassword = value.getHashedpassword();
        this.passwordsalt = value.getPasswordsalt();
        this.companycode = value.getCompanycode();
        this.createdon = value.getCreatedon();
        this.createdby = value.getCreatedby();
    }

    public TbUser(
        Long           id,
        String         roleid,
        String         firstname,
        String         lastname,
        String         email,
        String         mobile,
        String         hashedpassword,
        String         passwordsalt,
        String         companycode,
        OffsetDateTime createdon,
        String         createdby
    ) {
        this.id = id;
        this.roleid = roleid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.mobile = mobile;
        this.hashedpassword = hashedpassword;
        this.passwordsalt = passwordsalt;
        this.companycode = companycode;
        this.createdon = createdon;
        this.createdby = createdby;
    }

    public TbUser(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public TbUser setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String getRoleid() {
        return this.roleid;
    }

    @Override
    public TbUser setRoleid(String roleid) {
        this.roleid = roleid;
        return this;
    }

    @Override
    public String getFirstname() {
        return this.firstname;
    }

    @Override
    public TbUser setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    @Override
    public String getLastname() {
        return this.lastname;
    }

    @Override
    public TbUser setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public TbUser setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String getMobile() {
        return this.mobile;
    }

    @Override
    public TbUser setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    @Override
    public String getHashedpassword() {
        return this.hashedpassword;
    }

    @Override
    public TbUser setHashedpassword(String hashedpassword) {
        this.hashedpassword = hashedpassword;
        return this;
    }

    @Override
    public String getPasswordsalt() {
        return this.passwordsalt;
    }

    @Override
    public TbUser setPasswordsalt(String passwordsalt) {
        this.passwordsalt = passwordsalt;
        return this;
    }

    @Override
    public String getCompanycode() {
        return this.companycode;
    }

    @Override
    public TbUser setCompanycode(String companycode) {
        this.companycode = companycode;
        return this;
    }

    @Override
    public OffsetDateTime getCreatedon() {
        return this.createdon;
    }

    @Override
    public TbUser setCreatedon(OffsetDateTime createdon) {
        this.createdon = createdon;
        return this;
    }

    @Override
    public String getCreatedby() {
        return this.createdby;
    }

    @Override
    public TbUser setCreatedby(String createdby) {
        this.createdby = createdby;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TbUser (");

        sb.append(id);
        sb.append(", ").append(roleid);
        sb.append(", ").append(firstname);
        sb.append(", ").append(lastname);
        sb.append(", ").append(email);
        sb.append(", ").append(mobile);
        sb.append(", ").append(hashedpassword);
        sb.append(", ").append(passwordsalt);
        sb.append(", ").append(companycode);
        sb.append(", ").append(createdon);
        sb.append(", ").append(createdby);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ITbUser from) {
        setId(from.getId());
        setRoleid(from.getRoleid());
        setFirstname(from.getFirstname());
        setLastname(from.getLastname());
        setEmail(from.getEmail());
        setMobile(from.getMobile());
        setHashedpassword(from.getHashedpassword());
        setPasswordsalt(from.getPasswordsalt());
        setCompanycode(from.getCompanycode());
        setCreatedon(from.getCreatedon());
        setCreatedby(from.getCreatedby());
    }

    @Override
    public <E extends ITbUser> E into(E into) {
        into.from(this);
        return into;
    }
}
