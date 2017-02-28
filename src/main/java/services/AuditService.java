package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Audit;
import repositories.AuditRepository;

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
	
	public void delete(Audit audit) {
		Assert.notNull(audit);
		Assert.isTrue(auditRepository.exists(audit.getId()));
		auditRepository.delete(audit);
	}

	// Other business methods -----------------------

}