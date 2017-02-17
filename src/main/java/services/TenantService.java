package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Tenant;
import repositories.TenantRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class TenantService {

	// Managed Repository ------------------------
	@Autowired
	private TenantRepository tenantRepository;

	// Constructor -------------------------------
	public TenantService() {
		super();
	}

	// Supporting services -----------------------

	// Simple CRUD methods -----------------------
	
	public Tenant create() {
		return new Tenant();
	}

	public Tenant findOne(int tenantId) {
		Tenant result;

		result = tenantRepository.findOne(tenantId);

		return result;
	}

	public Collection<Tenant> findAll() {
		Collection<Tenant> result;

		result = tenantRepository.findAll();

		return result;
	}

	public Tenant save(Tenant tenant) {
		Assert.notNull(tenant);
		return tenantRepository.save(tenant);
	}
	
	public void delete(Tenant tenant) {
		Assert.notNull(tenant);
		Assert.isTrue(tenantRepository.exists(tenant.getId()));
		tenantRepository.delete(tenant);
	}

	// Other business methods -----------------------

}