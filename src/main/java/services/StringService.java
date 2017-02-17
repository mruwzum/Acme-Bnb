package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.String;
import repositories.StringRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class StringService {

	// Managed Repository ------------------------
	@Autowired
	private StringRepository stringRepository;

	// Constructor -------------------------------
	public StringService() {
		super();
	}

	// Supporting services -----------------------

	// Simple CRUD methods -----------------------
	
	public String create() {
		return new String();
	}

	public String findOne(int stringId) {
		String result;

		result = stringRepository.findOne(stringId);

		return result;
	}

	public Collection<String> findAll() {
		Collection<String> result;

		result = stringRepository.findAll();

		return result;
	}

	public String save(String string) {
		Assert.notNull(string);
		return stringRepository.save(string);
	}

	// Other business methods -----------------------

}