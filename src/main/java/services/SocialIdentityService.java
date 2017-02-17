package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.SocialIdentity;
import repositories.SocialIdentityRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class SocialIdentityService {

	// Managed Repository ------------------------
	@Autowired
	private SocialIdentityRepository socialIdentityRepository;

	// Constructor -------------------------------
	public SocialIdentityService() {
		super();
	}

	// Supporting services -----------------------

	// Simple CRUD methods -----------------------
	
	public SocialIdentity create() {
		return new SocialIdentity();
	}

	public SocialIdentity findOne(int socialIdentityId) {
		SocialIdentity result;

		result = socialIdentityRepository.findOne(socialIdentityId);

		return result;
	}

	public Collection<SocialIdentity> findAll() {
		Collection<SocialIdentity> result;

		result = socialIdentityRepository.findAll();

		return result;
	}

	public SocialIdentity save(SocialIdentity socialIdentity) {
		Assert.notNull(socialIdentity);
		return socialIdentityRepository.save(socialIdentity);
	}
	
	public void delete(SocialIdentity socialIdentity) {
		Assert.notNull(socialIdentity);
		Assert.isTrue(socialIdentityRepository.exists(socialIdentity.getId()));
		socialIdentityRepository.delete(socialIdentity);
	}

	// Other business methods -----------------------

}