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
public class DateService {

	// Managed Repository ------------------------
	@Autowired
	private DateRepository dateRepository;

	// Constructor -------------------------------
	public DateService() {
		super();
	}

	// Supporting services -----------------------

	// Simple CRUD methods -----------------------
	
	public Date create() {
		return new Date();
	}

	public Date findOne(int dateId) {
		Date result;

		result = dateRepository.findOne(dateId);

		return result;
	}

	public Collection<Date> findAll() {
		Collection<Date> result;

		result = dateRepository.findAll();

		return result;
	}

	public Date save(Date date) {
		Assert.notNull(date);
		return dateRepository.save(date);
	}

	// Other business methods -----------------------

}