package repositories;

import domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import domain.Lessor;

import java.util.Collection;

@Repository
public interface LessorRepository extends JpaRepository<Lessor, Integer> {
    @Query("select c from Lessor c where c.userAccount.id = ?1")
    Lessor findByUserAccountId(int userAccountId);

    @Query("select u.propertys from Lessor u where u.id =?1")
    Collection<Property> getAllProperties(int id);

}
