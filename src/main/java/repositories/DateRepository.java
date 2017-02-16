package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import domain.Date;

@Repository
public interface DateRepository extends JpaRepository<Date, Integer> {

}
