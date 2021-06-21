package il.org.multivec.Repositories;

import il.org.multivec.Models.Person;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, BigInteger> {
    Optional<Person> findById(BigInteger id);
}
