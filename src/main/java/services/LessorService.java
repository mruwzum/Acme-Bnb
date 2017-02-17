package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Lessor;
import repositories.LessorRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class LessorService {

	// Managed Repository ------------------------
	@Autowired
	private LessorRepository lessorRepository;

	// Constructor -------------------------------
	public LessorService() {
		super();
	}

	// Supporting services -----------------------

	// Simple CRUD methods -----------------------
	
	public Lessor create() {
		return new Lessor();
	}

	public Lessor findOne(int lessorId) {
		Lessor result;

		result = lessorRepository.findOne(lessorId);

		return result;
	}

	public Collection<Lessor> findAll() {
		Collection<Lessor> result;

		result = lessorRepository.findAll();

		return result;
	}

	public Lessor save(Lessor lessor) {
		Assert.notNull(lessor);
		return lessorRepository.save(lessor);
	}
	
	public void delete(Lessor lessor) {
		Assert.notNull(lessor);
		Assert.isTrue(lessorRepository.exists(lessor.getId()));
		lessorRepository.delete(lessor);
	}

	// Other business methods -----------------------

}