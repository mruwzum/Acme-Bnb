package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Actor;
import domain.Administrator;
import repositories.ActorRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class BookRequestService {

	// Managed Repository ------------------------
	@Autowired
	private BookRequestRepository bookRequestRepository;

	// Constructor -------------------------------
	public BookRequestService() {
		super();
	}

	// Supporting services -----------------------

	// Simple CRUD methods -----------------------
	
	public BookRequest create() {
		return new BookRequest();
	}

	public BookRequest findOne(int bookRequestId) {
		BookRequest result;

		result = bookRequestRepository.findOne(bookRequestId);

		return result;
	}

	public Collection<BookRequest> findAll() {
		Collection<BookRequest> result;

		result = bookRequestRepository.findAll();

		return result;
	}

	public BookRequest save(BookRequest bookRequest) {
		Assert.notNull(bookRequest);
		return bookRequestRepository.save(bookRequest);
	}

	// Other business methods -----------------------

}