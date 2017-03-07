package repositories;

import domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
    @Query("select c from Administrator c where c.userAccount.id = ?1")
    Administrator findByUserAccountId(int userAccountId);


    @Query("select avg (u.propertys.size) from Lessor u join u.propertys a join a.bookRequests b where b.status=1")
    Double averageAcceptedRequestPerLessor();
    @Query("select avg (u.propertys.size) from Lessor u join u.propertys a join a.bookRequests b where b.status=0")
    Double averageDeniedRequestPerLessor();

    @Query("select avg (u.bookRequests.size) from Tenant u join u.bookRequests b where b.status=1")
    Double averageAcceptedRequestPerTenat();

    @Query("select avg (u.bookRequests.size) from Tenant u join u.bookRequests b where b.status=0")
    Double averageDeniedRequestPerTenat();

    @Query("select l from Lessor l join l.propertys a join a.bookRequests b where b.status=1 order by a.bookRequests.size")
    Collection<Lessor> lessorsWhoHasAcceptedBookRequests();
    @Query("select l from Lessor l join l.propertys a join a.bookRequests b where b.status=0 order by a.bookRequests.size")
    Collection<Lessor> lessorsWhoHasDeniedBookRequests();
    @Query("select l from Lessor l join l.propertys a join a.bookRequests b where b.status=2 order by a.bookRequests.size")
    Collection<Lessor> lessorsWhoHasPendingBookRequests();

    @Query("select a from Tenant a join a.bookRequests b where b.status=1 order by a.bookRequests.size")
    Collection<Tenant> getTenantWithMoreApprovedBookRequest();
    @Query("select a from Tenant a join a.bookRequests b where b.status=0 order by a.bookRequests.size")
    Collection<Tenant> getTenantWithMoreDeniedBookRequest();
    @Query("select a from Tenant a join a.bookRequests b where b.status=2 order by a.bookRequests.size")
    Collection<Tenant> getTenantWithMorePendingBookRequest();


    @Query("select a.bookRequests.size from Lessor l join l.propertys a where l.id =?1")
    Integer numberOfBookRequestsPerLessor(int id);

    @Query("select a.bookRequests.size from Lessor l join l.propertys a join a.bookRequests b where l.id =?1 and b.status=1")
    Integer numberOfAprovedBookRequestsPerLessor(int id);


    @Query("select l.bookRequests.size from Tenant l  where l.id =?1")
    Integer numberOfBookRequestsPerTenant(int id);

    @Query("select l.bookRequests.size from Tenant l  join l.bookRequests b where l.id =?1 and b.status=1")
    Integer numberOfAprovedBookRequestsPerTenant(int id);


    @Query("select avg(f.numberOfFinderResults)from Finder f")
    Double averageResultPerFinder();

    @Query("select max(f.numberOfFinderResults)from Finder f")
    Integer MaximumResultPerFinder();

    @Query("select min(f.numberOfFinderResults)from Finder f")
    Integer MinimumResultPerFinder();


    //LEVEL B

    @Query("select avg(p.audits.size) from Property p")
    Double averageNumberOfAuditsPerProperties();

    //Aqui hay que sacar en el servicio el primero para hacer el max, y el ultimo para hacer el min
    @Query("select p.name from Property p order by p.audits.size asc")
    List<String> maximumNumberOfAuditsPerProperties();


    @Query("select l.values.size from Property l ")
    Collection<Integer> numberOfTimesInWithAnAtributteHasBeenUserToDescribeAProperty();

    @Query("select l from Lessor l join l.propertys p order by p.audits.size asc")
    Collection<Lessor> lessorOrderByNumberOfAuditsHisPropertiesHaveGot();

    @Query("select l from Lessor l join l.propertys p order by p.bookRequests.size asc")
    Collection<Lessor> lessorOrderByNumberOfRequestHisPropertiesHaveGot();

    @Query("select l from Lessor l join l.propertys p join p.bookRequests b where b.status=1 order by p.bookRequests.size asc")
    Collection<Lessor> lessorOrderByNumberOfAprovedRequestHisPropertiesHaveGot();

    @Query("select l from Lessor l join l.propertys p join p.bookRequests b where b.status=0 order by p.bookRequests.size asc")
    Collection<Lessor> lessorOrderByNumberOfDeniedRequestHisPropertiesHaveGot();

    @Query("select l from Lessor l join l.propertys p join p.bookRequests b where b.status=2 order by p.bookRequests.size asc")
    Collection<Lessor> lessorOrderByNumberOfPendigRequestHisPropertiesHaveGot();

    //LEVEL A

    @Query("select avg(p.socialIdentitys.size) from Actor p")
    Double averageNumberOfSocialIdentitiesPerActor();

    @Query("select max(p.socialIdentitys.size) from Actor p")
    Integer maximumNumberOfSocialIdentitesPerActor();

    @Query("select min(p.socialIdentitys.size) from Actor p")
    Integer minimumNumberOfSocialIdentitesPerActor();

    @Query("select avg(p.invoices.size) from Tenant p")
    Double averageNumberOfInvoicePerTenant();

    @Query("select max(p.invoices.size) from Tenant p")
    Double maximumNumberOfInvoicePerTenant();

    @Query("select min(p.invoices.size) from Tenant p")
    Double minimumNumberOfInvoicePerTenant();

    @Query("select sum(i.totalAmount) from Invoice i")
    Double totalInvoiceAmmountOnTheSystem();


    //Estas dos queries hay que dividirlas en el servicio
    @Query("select avg(p) from Property p where p.audits.size is not null ")
    Double averageOfPropertiesWithAudits();
    @Query("select avg(p) from Property p where p.audits.size is null")
    Double averageOfPropertiesWithoutAudits();


}
