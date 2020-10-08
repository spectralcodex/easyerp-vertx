/*
 * This file is generated by jOOQ.
 */
package jooq.tables.daos;


import io.github.jklingsporn.vertx.jooq.shared.async.AbstractAsyncVertxDAO;

import java.time.OffsetDateTime;
import java.util.Collection;

import jooq.tables.TbAccomodation;
import jooq.tables.records.TbAccomodationRecord;

import org.jooq.Configuration;


import java.util.List;
import io.vertx.core.Future;
import io.github.jklingsporn.vertx.jooq.classic.async.AsyncClassicQueryExecutor;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbAccomodationDao extends AbstractAsyncVertxDAO<TbAccomodationRecord, jooq.tables.pojos.TbAccomodation, Long, Future<List<jooq.tables.pojos.TbAccomodation>>, Future<jooq.tables.pojos.TbAccomodation>, Future<Integer>, Future<Long>> implements io.github.jklingsporn.vertx.jooq.classic.VertxDAO<TbAccomodationRecord,jooq.tables.pojos.TbAccomodation,Long> {

    /**
     * @param configuration Used for rendering, so only SQLDialect must be set and must be one of the MYSQL types or POSTGRES.
     * @param delegate A configured AsyncSQLClient that is used for query execution
     */
    public TbAccomodationDao(Configuration configuration, io.vertx.ext.asyncsql.AsyncSQLClient delegate) {
        super(TbAccomodation.TB_ACCOMODATION, jooq.tables.pojos.TbAccomodation.class, new AsyncClassicQueryExecutor<TbAccomodationRecord,jooq.tables.pojos.TbAccomodation,Long>(configuration,delegate,jooq.tables.pojos.TbAccomodation::new, TbAccomodation.TB_ACCOMODATION));
    }

    @Override
    protected Long getId(jooq.tables.pojos.TbAccomodation object) {
        return object.getId();
    }

    /**
     * Find records that have <code>serialNumber IN (values)</code> asynchronously
     */
    public Future<List<jooq.tables.pojos.TbAccomodation>> findManyBySerialnumber(Collection<String> values) {
        return findManyByCondition(TbAccomodation.TB_ACCOMODATION.SERIALNUMBER.in(values));
    }

    /**
     * Find records that have <code>serialNumber IN (values)</code> asynchronously limited by the given limit
     */
    public Future<List<jooq.tables.pojos.TbAccomodation>> findManyBySerialnumber(Collection<String> values, int limit) {
        return findManyByCondition(TbAccomodation.TB_ACCOMODATION.SERIALNUMBER.in(values),limit);
    }

    /**
     * Find records that have <code>name IN (values)</code> asynchronously
     */
    public Future<List<jooq.tables.pojos.TbAccomodation>> findManyByName(Collection<String> values) {
        return findManyByCondition(TbAccomodation.TB_ACCOMODATION.NAME.in(values));
    }

    /**
     * Find records that have <code>name IN (values)</code> asynchronously limited by the given limit
     */
    public Future<List<jooq.tables.pojos.TbAccomodation>> findManyByName(Collection<String> values, int limit) {
        return findManyByCondition(TbAccomodation.TB_ACCOMODATION.NAME.in(values),limit);
    }

    /**
     * Find records that have <code>abbrevation IN (values)</code> asynchronously
     */
    public Future<List<jooq.tables.pojos.TbAccomodation>> findManyByAbbrevation(Collection<String> values) {
        return findManyByCondition(TbAccomodation.TB_ACCOMODATION.ABBREVATION.in(values));
    }

    /**
     * Find records that have <code>abbrevation IN (values)</code> asynchronously limited by the given limit
     */
    public Future<List<jooq.tables.pojos.TbAccomodation>> findManyByAbbrevation(Collection<String> values, int limit) {
        return findManyByCondition(TbAccomodation.TB_ACCOMODATION.ABBREVATION.in(values),limit);
    }

    /**
     * Find records that have <code>units IN (values)</code> asynchronously
     */
    public Future<List<jooq.tables.pojos.TbAccomodation>> findManyByUnits(Collection<String> values) {
        return findManyByCondition(TbAccomodation.TB_ACCOMODATION.UNITS.in(values));
    }

    /**
     * Find records that have <code>units IN (values)</code> asynchronously limited by the given limit
     */
    public Future<List<jooq.tables.pojos.TbAccomodation>> findManyByUnits(Collection<String> values, int limit) {
        return findManyByCondition(TbAccomodation.TB_ACCOMODATION.UNITS.in(values),limit);
    }

    /**
     * Find records that have <code>dormBedsPerRoom IN (values)</code> asynchronously
     */
    public Future<List<jooq.tables.pojos.TbAccomodation>> findManyByDormbedsperroom(Collection<Integer> values) {
        return findManyByCondition(TbAccomodation.TB_ACCOMODATION.DORMBEDSPERROOM.in(values));
    }

    /**
     * Find records that have <code>dormBedsPerRoom IN (values)</code> asynchronously limited by the given limit
     */
    public Future<List<jooq.tables.pojos.TbAccomodation>> findManyByDormbedsperroom(Collection<Integer> values, int limit) {
        return findManyByCondition(TbAccomodation.TB_ACCOMODATION.DORMBEDSPERROOM.in(values),limit);
    }

    /**
     * Find records that have <code>totalAccomodation IN (values)</code> asynchronously
     */
    public Future<List<jooq.tables.pojos.TbAccomodation>> findManyByTotalaccomodation(Collection<Integer> values) {
        return findManyByCondition(TbAccomodation.TB_ACCOMODATION.TOTALACCOMODATION.in(values));
    }

    /**
     * Find records that have <code>totalAccomodation IN (values)</code> asynchronously limited by the given limit
     */
    public Future<List<jooq.tables.pojos.TbAccomodation>> findManyByTotalaccomodation(Collection<Integer> values, int limit) {
        return findManyByCondition(TbAccomodation.TB_ACCOMODATION.TOTALACCOMODATION.in(values),limit);
    }

    /**
     * Find records that have <code>createdOn IN (values)</code> asynchronously
     */
    public Future<List<jooq.tables.pojos.TbAccomodation>> findManyByCreatedon(Collection<OffsetDateTime> values) {
        return findManyByCondition(TbAccomodation.TB_ACCOMODATION.CREATEDON.in(values));
    }

    /**
     * Find records that have <code>createdOn IN (values)</code> asynchronously limited by the given limit
     */
    public Future<List<jooq.tables.pojos.TbAccomodation>> findManyByCreatedon(Collection<OffsetDateTime> values, int limit) {
        return findManyByCondition(TbAccomodation.TB_ACCOMODATION.CREATEDON.in(values),limit);
    }

    /**
     * Find records that have <code>createdBy IN (values)</code> asynchronously
     */
    public Future<List<jooq.tables.pojos.TbAccomodation>> findManyByCreatedby(Collection<String> values) {
        return findManyByCondition(TbAccomodation.TB_ACCOMODATION.CREATEDBY.in(values));
    }

    /**
     * Find records that have <code>createdBy IN (values)</code> asynchronously limited by the given limit
     */
    public Future<List<jooq.tables.pojos.TbAccomodation>> findManyByCreatedby(Collection<String> values, int limit) {
        return findManyByCondition(TbAccomodation.TB_ACCOMODATION.CREATEDBY.in(values),limit);
    }

    @Override
    public AsyncClassicQueryExecutor<TbAccomodationRecord,jooq.tables.pojos.TbAccomodation,Long> queryExecutor(){
        return (AsyncClassicQueryExecutor<TbAccomodationRecord,jooq.tables.pojos.TbAccomodation,Long>) super.queryExecutor();
    }

    @Override
    protected java.util.function.Function<Object,Long> keyConverter(){
        return lastId -> Long.valueOf(((io.vertx.core.json.JsonArray)lastId).getLong(0).longValue());
    }
}
