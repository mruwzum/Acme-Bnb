package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import domain.String;

@Repository
public interface StringRepository extends JpaRepository<String, Integer> {

}
