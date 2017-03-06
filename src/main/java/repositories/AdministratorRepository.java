package repositories;

import domain.BookRequest;
import domain.Lessor;
import domain.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Administrator;

import java.util.Collection;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
    @Query("select c from Administrator c where c.userAccount.id = ?1")
    Administrator findByUserAccountId(int userAccountId);


    @Query("select avg (u.propertys) from Lessor u group by u")
    Double averageAcceptedRequestPerLessor();

    @Query("select avg (u.bookRequests.size) from Tenant u")
    Double averageAcceptedRequestPerTenat();

    @Query("select u.bookRequests from Property u")
    Collection<BookRequest> bookRequestsFromProperty();

    //TODO
    @Query("select l from Lessor l join l.propertys cont join cont.bookRequests b where b.status = 1  ")
    Collection<Lessor> lessorsWhoHasAcceptedBookRequests();

    @Query("select l from Lessor l join l.propertys cont join cont.bookRequests b where b.status = 0  ")
    Collection<Lessor> lessorsWhoHasDeniedBookRequests();


    @Query("select max(s.bookRequests) from Tenant s group by s")
    Collection<Integer> maximumNumberOfRecipesQualifiedForAContest();






}
