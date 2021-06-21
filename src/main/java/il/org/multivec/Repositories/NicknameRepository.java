package il.org.multivec.Repositories;

import il.org.multivec.Models.Nickname;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface NicknameRepository extends CrudRepository<Nickname, BigInteger> {
    Optional<Nickname> findById (BigInteger id);
}
