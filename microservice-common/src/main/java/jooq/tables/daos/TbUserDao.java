/*
 * This file is generated by jOOQ.
 */
package jooq.tables.daos;


import io.github.jklingsporn.vertx.jooq.shared.async.AbstractAsyncVertxDAO;

import java.time.OffsetDateTime;
import java.util.Collection;

import jooq.tables.TbUser;
import jooq.tables.records.TbUserRecord;

import org.jooq.Configuration;


import java.util.List;
import io.vertx.core.Future;
import io.github.jklingsporn.vertx.jooq.classic.async.AsyncClassicQueryExecutor;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbUserDao extends AbstractAsyncVertxDAO<TbUserRecord, jooq.tables.pojos.TbUser, Long, Future<List<jooq.tables.pojos.TbUser>>, Future<jooq.tables.pojos.TbUser>, Future<Integer>, Future<Long>> implements io.github.jklingsporn.vertx.jooq.classic.VertxDAO<TbUserRecord,jooq.tables.pojos.TbUser,Long> {

    /**
     * @param configuration Used for rendering, so only SQLDialect must be set and must be one of the MYSQL types or POSTGRES.
     * @param delegate A configured AsyncSQLClient that is used for query execution
     */
    public TbUserDao(Configuration configuration, io.vertx.ext.asyncsql.AsyncSQLClient delegate) {
        super(TbUser.TB_USER, jooq.tables.pojos.TbUser.class, new AsyncClassicQueryExecutor<TbUserRecord,jooq.tables.pojos.TbUser,Long>(configuration,delegate,jooq.tables.pojos.TbUser::new, TbUser.TB_USER));
    }

    @Override
    protected Long getId(jooq.tables.pojos.TbUser object) {
        return object.getId();
    }

    /**
     * Find records that have <code>roleId IN (values)</code> asynchronously
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByRoleid(Collection<String> values) {
        return findManyByCondition(TbUser.TB_USER.ROLEID.in(values));
    }

    /**
     * Find records that have <code>roleId IN (values)</code> asynchronously limited by the given limit
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByRoleid(Collection<String> values, int limit) {
        return findManyByCondition(TbUser.TB_USER.ROLEID.in(values),limit);
    }

    /**
     * Find records that have <code>firstName IN (values)</code> asynchronously
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByFirstname(Collection<String> values) {
        return findManyByCondition(TbUser.TB_USER.FIRSTNAME.in(values));
    }

    /**
     * Find records that have <code>firstName IN (values)</code> asynchronously limited by the given limit
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByFirstname(Collection<String> values, int limit) {
        return findManyByCondition(TbUser.TB_USER.FIRSTNAME.in(values),limit);
    }

    /**
     * Find records that have <code>lastName IN (values)</code> asynchronously
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByLastname(Collection<String> values) {
        return findManyByCondition(TbUser.TB_USER.LASTNAME.in(values));
    }

    /**
     * Find records that have <code>lastName IN (values)</code> asynchronously limited by the given limit
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByLastname(Collection<String> values, int limit) {
        return findManyByCondition(TbUser.TB_USER.LASTNAME.in(values),limit);
    }

    /**
     * Find records that have <code>email IN (values)</code> asynchronously
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByEmail(Collection<String> values) {
        return findManyByCondition(TbUser.TB_USER.EMAIL.in(values));
    }

    /**
     * Find records that have <code>email IN (values)</code> asynchronously limited by the given limit
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByEmail(Collection<String> values, int limit) {
        return findManyByCondition(TbUser.TB_USER.EMAIL.in(values),limit);
    }

    /**
     * Find records that have <code>mobile IN (values)</code> asynchronously
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByMobile(Collection<String> values) {
        return findManyByCondition(TbUser.TB_USER.MOBILE.in(values));
    }

    /**
     * Find records that have <code>mobile IN (values)</code> asynchronously limited by the given limit
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByMobile(Collection<String> values, int limit) {
        return findManyByCondition(TbUser.TB_USER.MOBILE.in(values),limit);
    }

    /**
     * Find records that have <code>hashedPassword IN (values)</code> asynchronously
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByHashedpassword(Collection<String> values) {
        return findManyByCondition(TbUser.TB_USER.HASHEDPASSWORD.in(values));
    }

    /**
     * Find records that have <code>hashedPassword IN (values)</code> asynchronously limited by the given limit
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByHashedpassword(Collection<String> values, int limit) {
        return findManyByCondition(TbUser.TB_USER.HASHEDPASSWORD.in(values),limit);
    }

    /**
     * Find records that have <code>passwordSalt IN (values)</code> asynchronously
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByPasswordsalt(Collection<String> values) {
        return findManyByCondition(TbUser.TB_USER.PASSWORDSALT.in(values));
    }

    /**
     * Find records that have <code>passwordSalt IN (values)</code> asynchronously limited by the given limit
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByPasswordsalt(Collection<String> values, int limit) {
        return findManyByCondition(TbUser.TB_USER.PASSWORDSALT.in(values),limit);
    }

    /**
     * Find records that have <code>companyCode IN (values)</code> asynchronously
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByCompanycode(Collection<String> values) {
        return findManyByCondition(TbUser.TB_USER.COMPANYCODE.in(values));
    }

    /**
     * Find records that have <code>companyCode IN (values)</code> asynchronously limited by the given limit
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByCompanycode(Collection<String> values, int limit) {
        return findManyByCondition(TbUser.TB_USER.COMPANYCODE.in(values),limit);
    }

    /**
     * Find records that have <code>createdOn IN (values)</code> asynchronously
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByCreatedon(Collection<OffsetDateTime> values) {
        return findManyByCondition(TbUser.TB_USER.CREATEDON.in(values));
    }

    /**
     * Find records that have <code>createdOn IN (values)</code> asynchronously limited by the given limit
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByCreatedon(Collection<OffsetDateTime> values, int limit) {
        return findManyByCondition(TbUser.TB_USER.CREATEDON.in(values),limit);
    }

    /**
     * Find records that have <code>createdBy IN (values)</code> asynchronously
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByCreatedby(Collection<String> values) {
        return findManyByCondition(TbUser.TB_USER.CREATEDBY.in(values));
    }

    /**
     * Find records that have <code>createdBy IN (values)</code> asynchronously limited by the given limit
     */
    public Future<List<jooq.tables.pojos.TbUser>> findManyByCreatedby(Collection<String> values, int limit) {
        return findManyByCondition(TbUser.TB_USER.CREATEDBY.in(values),limit);
    }

    @Override
    public AsyncClassicQueryExecutor<TbUserRecord,jooq.tables.pojos.TbUser,Long> queryExecutor(){
        return (AsyncClassicQueryExecutor<TbUserRecord,jooq.tables.pojos.TbUser,Long>) super.queryExecutor();
    }

    @Override
    protected java.util.function.Function<Object,Long> keyConverter(){
        return lastId -> Long.valueOf(((io.vertx.core.json.JsonArray)lastId).getLong(0).longValue());
    }
}
