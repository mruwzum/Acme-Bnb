package services;

import java.util.Collection;

import javax.transaction.Transactional;

import domain.Auditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Actor;
import domain.Administrator;
import repositories.ActorRepository;
import repositories.AuditorRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class AuditorService {

	// Managed Repository ------------------------
	@Autowired
	private AuditorRepository auditorRepository;

	// Constructor -------------------------------
	public AuditorService() {
		super();
	}

	// Supporting services -----------------------

	// Simple CRUD methods -----------------------
	
	public Auditor create() {
		return new Auditor();
	}

	public Auditor findOne(int auditorId) {
		Auditor result;

		result = auditorRepository.findOne(auditorId);

		return result;
	}

	public Collection<Auditor> findAll() {
		Collection<Auditor> result;

		result = auditorRepository.findAll();

		return result;
	}

	public Auditor save(Auditor auditor) {
		Assert.notNull(auditor);
		return auditorRepository.save(auditor);
	}

	// Other business methods -----------------------

}