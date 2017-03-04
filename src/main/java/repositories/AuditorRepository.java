package repositories;

import domain.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Auditor;

import java.util.Collection;

@Repository
public interface AuditorRepository extends JpaRepository<Auditor, Integer> {
    @Query("select c from Auditor c where c.userAccount.id = ?1")
    Auditor findByUserAccountId(int userAccountId);

    @Query("select u.audits from Auditor u where u.id =?1")
    Collection<Audit> myAudits(int userAccountId);
}
