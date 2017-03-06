package repositories;

import domain.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by daviddelatorre on 6/3/17.
 */
public interface AttributeRepository extends JpaRepository<Attribute, Integer> {
}
