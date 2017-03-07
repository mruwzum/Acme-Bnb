package repositories;

import domain.Value;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by daviddelatorre on 6/3/17.
 */
public interface ValueRepository extends JpaRepository<Value, Integer> {
}
