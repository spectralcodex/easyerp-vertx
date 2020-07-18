package jooq.async;

import io.github.jklingsporn.vertx.jooq.classic.async.AsyncClassicGenericQueryExecutor;
import io.github.jklingsporn.vertx.jooq.shared.internal.QueryExecutor;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.sql.UpdateResult;
import org.jooq.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class AsyncClassicQueryExecutor<R extends UpdatableRecord<R>,P,T> extends AsyncClassicGenericQueryExecutor implements QueryExecutor<R,T,Future<List<P>>,Future<P>,Future<Integer>,Future<T>> {

    private final Function<JsonObject,P> pojoMapper;

    public AsyncClassicQueryExecutor(Configuration configuration, AsyncSQLClient delegate, Function<JsonObject, P> pojoMapper, Table<R> table) {
        super(configuration,delegate);
        this.pojoMapper = convertFromSQL(table).andThen(pojoMapper);
    }

    @Override
    public Future<List<P>> findMany(Function<DSLContext, ? extends ResultQuery<R>> queryFunction) {
        return findManyJson(queryFunction).map(ls -> ls.stream().map(pojoMapper).collect(Collectors.toList()));
    }

    @Override
    public Future<P> findOne(Function<DSLContext, ? extends ResultQuery<R>> queryFunction) {
        return findOneJson(queryFunction).map(val -> val == null ? null : pojoMapper.apply(val));
    }

    @Override
    public Future<T> insertReturning(Function<DSLContext, ? extends InsertResultStep<R>> queryFunction, Function<Object, T> keyMapper) {
        return getConnection().compose(safeExecute(sqlConnection->{
            Query query = createQuery(queryFunction);
            log(query);
            Promise<Object> promise = Promise.promise();
            if(isMysql){
                sqlConnection.updateWithParams(
                        query.getSQL(),
                        getBindValues(query),
                        this.executeAndClose(UpdateResult::getKeys,
                                sqlConnection,
                                promise)
                );
            }else{
                sqlConnection.queryWithParams(
                        query.getSQL(),
                        getBindValues(query),
                        this.executeAndClose(res -> res.getResults().get(0),
                                sqlConnection,
                                promise)
                );
            }
            return promise.future().map(keyMapper);
        }));
    }

}
