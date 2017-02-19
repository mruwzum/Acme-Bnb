package services;

import domain.Actor;
import domain.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repositories.ActorRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class ActorService {

	// Managed Repository ------------------------
	@Autowired
	private ActorRepository actorRepository;

	// Constructor -------------------------------
	public ActorService() {
		super();
	}

	// Supporting services -----------------------

	// Simple CRUD methods -----------------------
	
	public Actor create() {
		return new Actor();
	}

	public Actor findOne(int actorId) {
		Actor result;

		result = actorRepository.findOne(actorId);

		return result;
	}

	public Collection<Actor> findAll() {
		Collection<Actor> result;

		result = actorRepository.findAll();

		return result;
	}

	public Actor save(Actor actor) {
		Assert.notNull(actor);
		return actorRepository.save(actor);
	}
	
	public void delete(Actor actor) {
		Assert.notNull(actor);
		Assert.isTrue(actorRepository.exists(actor.getId()));
		actorRepository.delete(actor);
	}

	// Other business methods -----------------------


    public Actor findByPrincipal() {
        Actor result;
        UserAccount userAccount;

        userAccount = LoginService.getPrincipal();
        Assert.notNull(userAccount);
        result = findByUserAccount(userAccount);
        Assert.notNull(result);

        return result;
    }

    private Actor findByUserAccount(UserAccount userAccount) {
        Assert.notNull(userAccount);

        Actor result;

        result = actorRepository.findByUserAccountId(userAccount.getId());

        return result;
    }

    public Tenant registerAsTenant(Actor u) {
        Assert.notNull(u);
        Authority autoh = new Authority();
        autoh.setAuthority("USER");
        UserAccount res = new UserAccount();
        res.addAuthority(autoh);
        Md5PasswordEncoder encoder;
        encoder = new Md5PasswordEncoder();
        String hash = encoder.encodePassword(u.getUserAccount().getPassword(), null);
        res.setUsername(u.getUserAccount().getUsername());
        res.setPassword(hash);
        //TODO meter las prop. de Tenant para registrarlo
        //Tenant resu = tenantRepository.save(u);
        //
        // return resu;
        return null;
    }
}