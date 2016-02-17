
package crud.backend;

import java.util.List;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.N1qlSecondaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;
import org.springframework.data.domain.Pageable;

/**
 * Empty JpaRepository is enough for a simple crud.
 */
@ViewIndexed(designDoc = "person", viewName = "all")
@N1qlPrimaryIndexed
@N1qlSecondaryIndexed(indexName = "person")
public interface PersonRepository extends CouchbasePagingAndSortingRepository<Person, String> {
    
    /* A version to fetch List instead of Page to avoid extra count query. */
    List<Person> findAllBy(Pageable pageable);
}
