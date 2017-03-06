package services;

import java.util.*;

import javax.transaction.Transactional;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.AdministratorRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class AdministratorService {

	// Managed Repository ------------------------
	@Autowired
	private AdministratorRepository administratorRepository;
	@Autowired
	private FeeService feeService;
	@Autowired
	private LessorService lessorService;
	@Autowired
	private TenantService tenantService;
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
	public void changeFee(Double newFee){

		List<Fee> fees = new ArrayList<>(feeService.findAll());
		Fee original = feeService.findOne(fees.get(0).getId());
		original.setValue(newFee);

	}

	//DASHBOARDS METHODS ---------------------------------------

	public Double averageAcceptedRequestPerLessor(){
		return administratorRepository.averageAcceptedRequestPerLessor();

	}

	public Double averageDeniedRequestPerLessor(){
		return administratorRepository.averageDeniedRequestPerLessor();

	}
	public Double averageAcceptedRequestPerTenat(){
		return administratorRepository.averageAcceptedRequestPerTenat();

	}
	public Double averageDeniedRequestPerTenat(){
		return administratorRepository.averageDeniedRequestPerTenat();

	}
	public Collection<Lessor> lessorsWhoHasAcceptedBookRequests(){
		return administratorRepository.lessorsWhoHasAcceptedBookRequests();
	}

	public Collection<Lessor> lessorsWhoHasDeniedBookRequests(){
		return administratorRepository.lessorsWhoHasDeniedBookRequests();
	}
	public Collection<Lessor> lessorsWhoHasPendingBookRequests(){
		return administratorRepository.lessorsWhoHasPendingBookRequests();
	}
	public Collection<Tenant> getTenantWithMoreApprovedBookRequest(){
		return administratorRepository.getTenantWithMoreApprovedBookRequest();
	}
	public Collection<Tenant> getTenantWithMoreDeniedBookRequest(){
		return administratorRepository.getTenantWithMoreDeniedBookRequest();
	}
	public Collection<Tenant> getTenantWithMorePendingBookRequest(){
		return administratorRepository.getTenantWithMorePendingBookRequest();
	}






	public Map<Tenant,Double> ratioOfRequestedVSApprovedRequestedPerTenant(){
		Collection<Tenant> tenants = tenantService.findAll();
		Map<Tenant,Double> res = new HashMap<>();
		for(Tenant t : tenants){
			Integer req = administratorRepository.numberOfBookRequestsPerTenant(t.getId());
			List<Integer> approvedReq = administratorRepository.numberOfAprovedBookRequestsPerTenant(t.getId());
			Integer correcto = approvedReq.get(0);
			Double ratio = (double)req/correcto;
			res.put(t,ratio);
		}
		return res;
	}


	public Map<Lessor,Double> ratioOfRequestedVSApprovedRequestedPerLessor(){
		Collection<Lessor> tenants = lessorService.findAll();
		Map<Lessor,Double> res = new HashMap<>();
		for(Lessor t : tenants){
			Integer req = administratorRepository.numberOfBookRequestsPerLessor(t.getId());
			List<Integer> approvedReq = administratorRepository.numberOfAprovedBookRequestsPerLessor(t.getId());
			Integer correcto = approvedReq.get(0);
			Double ratio = (double)req/correcto;
			res.put(t,ratio);
		}
		return res;
	}




	public Double averageResultPerFinder(){
		return administratorRepository.averageResultPerFinder();
	}
	public Integer MaximumResultPerFinder(){
		return administratorRepository.MaximumResultPerFinder();
	}
	public Integer MinimumResultPerFinder(){
		return administratorRepository.MinimumResultPerFinder();
	}

}