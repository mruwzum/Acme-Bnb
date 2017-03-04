package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
	@Autowired
	private PropertyService propertyService;
	@Autowired
	private FeeService	feeService;


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

	public Lessor findByPrincipal() {
		Lessor result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}

	private Lessor findByUserAccount(UserAccount userAccount) {
		Assert.notNull(userAccount);

		Lessor result;

		result = lessorRepository.findByUserAccountId(userAccount.getId());

		return result;
	}


	public Collection<Property> getAllProperties() {

		Collection<Property> res;
		Lessor u = findByPrincipal();
		Assert.notNull(u, "user not identified");
		res = lessorRepository.getAllProperties(u.getId());
		return res;

	}

	public void deleteProperty(Property p) {
		Assert.notNull(p, "the property doesn't exist");
		Lessor u = findByPrincipal();
		Assert.notNull(u, "user not identified");
		Assert.isTrue(u.getPropertys().contains(p), "this isn't a property of Lessor " + u);
		propertyService.delete(p);
	}

	public void registerProperty(Property p) {
		Assert.notNull(p, "the property doesn't exist");
		Lessor u = findByPrincipal();
		Assert.notNull(u, "user not identified");
		Assert.isTrue(!u.getPropertys().contains(p), "this lessor already register this property");
		propertyService.save(p);

	}

	public Property modifyProperty(Property p, String name, String description, String address, String province,
								   String country, String state, int capacity, String city) {

		Assert.notNull(p);
		Lessor u = findByPrincipal();
		Assert.notNull(u, "user not identified");
		Assert.isTrue(u.getPropertys().contains(p), "this isn't a property of Lessor " + u);

		p.setName(name);
		p.setDescription(description);
		p.setAddress(address);
		p.setProvince(province);
		p.setCountry(country);
		p.setState(state);
		p.setCapacity(capacity);
		p.setCity(city);

		return p;

	}

	public void approveRequest(BookRequest bookRequest) {

		//TODO aquí habría que comprobar que la bookRequest pertenece a alguna propiedad del lessor, pero no se como hacerlo sin poner un for
		bookRequest.setStatus(RequestStatus.ACEPTED);

	}

	public void denyRequest(BookRequest bookRequest) {
		//TODO aquí habría que comprobar que la bookRequest pertenece a alguna propiedad del lessor, pero no se como hacerlo sin poner un for
		bookRequest.setStatus(RequestStatus.DENIED);
	}


	//TODO esto hay que optimizarlo y ponerlo con queries
	public Collection<BookRequest> getAllRequest() {
		List<BookRequest> requests = new ArrayList<>();
		Lessor u = findByPrincipal();
		Assert.notNull(u, "user not identified");
		for (Property p : getAllProperties()) {
			if (!p.getBookRequests().isEmpty()) {
				requests.addAll(p.getBookRequests());
			}

		}
		Assert.isTrue(!requests.isEmpty(), "No book request found");
		return requests;
	}

	//TODO esto hay que optimizarlo y ponerlo con queries
	public Collection<BookRequest> getPendingRequest() {
		List<BookRequest> requests = new ArrayList<>();
		Lessor u = findByPrincipal();
		Assert.notNull(u, "user not identified");
		for (Property p : getAllProperties()) {
			if (!p.getBookRequests().isEmpty()) {
				for (BookRequest b : p.getBookRequests()) {
					if (b.getStatus().equals(RequestStatus.PENDING)) {
						requests.add(b);
					}
				}
			}

		}
		return requests;
	}

    public Double totalFee() {
        List<Fee> fees = new ArrayList<>(feeService.findAll());
        Fee original = feeService.findOne(fees.get(0).getId());
        Double res = 0.0;
        for (BookRequest b : getAllRequest()) {
            if (b.getStatus().equals(RequestStatus.ACEPTED)) {
                res = res + original.getValue();
            }
        }
        return res;

    }


    public void commentToTenant(Comment c) {


    }
}