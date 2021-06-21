package il.org.multivec.Repositories;

import il.org.multivec.Models.BookSeries;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface BookSeriesRepository extends CrudRepository<BookSeries, BigInteger> {
    Optional<BookSeries> findById (BigInteger id);
}
