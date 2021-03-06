package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Tenant;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {
    @Query("select c from Tenant c where c.userAccount.id = ?1")
    Tenant findByUserAccountId(int userAccountId);
}
