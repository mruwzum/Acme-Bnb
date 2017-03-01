package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Administrator;
import repositories.AdministratorRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class AdministratorService {

	// Managed Repository ------------------------
	@Autowired
	private AdministratorRepository administratorRepository;

	// Constructor -------------------------------
	public AdministratorService() {
		super();
	}

	// Supporting services -----------------------

	// Simple CRUD methods -----------------------
	
	public Administrator create() {
		return new Administrator();
	}

	public Administrator findOne(int administratorId) {
		Administrator result;

		result = administratorRepository.findOne(administratorId);

		return result;
	}

	public Collection<Administrator> findAll() {
		Collection<Administrator> result;

		result = administratorRepository.findAll();

		return result;
	}

	public Administrator save(Administrator administrator) {
		Assert.notNull(administrator);
		return administratorRepository.save(administrator);
	}
	
	public void delete(Administrator administrator) {
		Assert.notNull(administrator);
		Assert.isTrue(administratorRepository.exists(administrator.getId()));
		administratorRepository.delete(administrator);
	}

	// Other business methods -----------------------


	public Administrator findByPrincipal() {
		Administrator result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}

	private Administrator findByUserAccount(UserAccount userAccount) {
		Assert.notNull(userAccount);

		Administrator result;

		result = administratorRepository.findByUserAccountId(userAccount.getId());

		return result;
	}
}