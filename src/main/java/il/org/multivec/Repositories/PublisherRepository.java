package il.org.multivec.Repositories;

import il.org.multivec.Models.Publisher;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface PublisherRepository extends CrudRepository<Publisher, BigInteger> {
    Optional<Publisher> findById(BigInteger id);
}
