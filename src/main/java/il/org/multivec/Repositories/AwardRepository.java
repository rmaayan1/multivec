package il.org.multivec.Repositories;

import il.org.multivec.Models.Award;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface AwardRepository extends CrudRepository<Award, BigInteger> {
    Optional<Award> findById(BigInteger id);
}
