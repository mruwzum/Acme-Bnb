package services;

import domain.Lessor;
import domain.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repositories.TenantRepository;
import security.LoginService;
import security.UserAccount;
import security.UserAccountService;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class TenantService {

	// Managed Repository ------------------------
	@Autowired
	private TenantRepository tenantRepository;
    @Autowired
    private UserAccountService userAccountService;


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

	public Tenant findByPrincipal() {
		Tenant result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}
	private Tenant findByUserAccount(UserAccount userAccount) {
		Assert.notNull(userAccount);

		Tenant result;

		result = tenantRepository.findByUserAccountId(userAccount.getId());

		return result;
	}

}