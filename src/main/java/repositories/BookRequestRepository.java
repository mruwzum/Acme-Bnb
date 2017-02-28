package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.BookRequest;

@Repository
public interface BookRequestRepository extends JpaRepository<BookRequest, Integer> {

}
