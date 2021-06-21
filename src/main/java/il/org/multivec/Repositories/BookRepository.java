package il.org.multivec.Repositories;

import il.org.multivec.Models.Book;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, BigInteger> {
    Optional<Book> findById(BigInteger id);
}
