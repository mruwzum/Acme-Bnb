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
public class PropertyService {

	// Managed Repository ------------------------
	@Autowired
	private PropertyRepository propertyRepository;

	// Constructor -------------------------------
	public PropertyService() {
		super();
	}

	// Supporting services -----------------------

	// Simple CRUD methods -----------------------
	
	public Property create() {
		return new Property();
	}

	public Property findOne(int propertyId) {
		Property result;

		result = propertyRepository.findOne(propertyId);

		return result;
	}

	public Collection<Property> findAll() {
		Collection<Property> result;

		result = propertyRepository.findAll();

		return result;
	}

	public Property save(Property property) {
		Assert.notNull(property);
		return propertyRepository.save(property);
	}

	// Other business methods -----------------------

}