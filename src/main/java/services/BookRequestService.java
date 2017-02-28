package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.BookRequest;
import repositories.BookRequestRepository;

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
	
	public void delete(BookRequest bookRequest) {
		Assert.notNull(bookRequest);
		Assert.isTrue(bookRequestRepository.exists(bookRequest.getId()));
		bookRequestRepository.delete(bookRequest);
	}

	// Other business methods -----------------------

}