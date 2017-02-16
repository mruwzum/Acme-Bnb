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
public class AuditService {

	// Managed Repository ------------------------
	@Autowired
	private AuditRepository auditRepository;

	// Constructor -------------------------------
	public AuditService() {
		super();
	}

	// Supporting services -----------------------

	// Simple CRUD methods -----------------------
	
	public Audit create() {
		return new Audit();
	}

	public Audit findOne(int auditId) {
		Audit result;

		result = auditRepository.findOne(auditId);

		return result;
	}

	public Collection<Audit> findAll() {
		Collection<Audit> result;

		result = auditRepository.findAll();

		return result;
	}

	public Audit save(Audit audit) {
		Assert.notNull(audit);
		return auditRepository.save(audit);
	}

	// Other business methods -----------------------

}