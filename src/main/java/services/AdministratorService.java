package services;

import java.util.*;

import javax.transaction.Transactional;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.AdministratorRepository;
import repositories.FeeRepository;
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
		Double res = administratorRepository.averageAcceptedRequestPerLessor();
		return res;
	}

	public Double averageAcceptedRequestPerTenat(){
		Double res = administratorRepository.averageAcceptedRequestPerTenat();
		return res;
	}
	public Lessor bookRequestsFromProperty(){
		//TODO sacar de todo este embrollo el lessor que haya aprobado mas requests :)
		Lessor res;
		Integer contador = 0;
		Collection<BookRequest> aux = administratorRepository.bookRequestsFromProperty();
		Collection<Lessor> lessors = lessorService.findAll();
		Map<Lessor,Integer> resultados = new HashMap<>();
		for(BookRequest b : aux){
			if (b.getStatus().equals(RequestStatus.ACEPTED)){
				for (Lessor l : lessors){
					if(b.getProperty().getLessor().equals(l)){
						contador++;
						resultados.put(l,contador);
					}
				}

			}
		}
		Collection<Integer> resultadosEnPunt = resultados.values();
		return null;
	}
}