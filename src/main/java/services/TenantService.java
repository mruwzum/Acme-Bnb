package services;

import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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

	@Autowired
	private InvoiceService invoiceService;

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


	public Invoice getInvoiceAmmount(BookRequest b) {
		Integer numberofDays = b.getCheckInDate().getDay() - b.getCheckOutDate().getDay();

		Invoice res;
		res = invoiceService.create();
		res.setIssuedMoment(new Date(System.currentTimeMillis()-100));
		res.setTenant(b.getTenant());
		res.setTotalAmount(b.getProperty().getRate() * numberofDays);
		res.setCreditCard(b.getTenant().getCreditCard());
		res.setTenantInfo(b.getTenant().getName() +"-" +b.getTenant().getSurname() +"-"+ b.getTenant().getEmail());
		res.setDetails(b.getProperty().toString() +"-"+ b.getCheckInDate().toString() +"-"+ b.getCheckOutDate().toString());
		res.setVATNumber("X1234567X");
		return invoiceService.save(res);

	}
	public CreditCard modifyCreditCard(String br, String cv, Integer exp, Integer expy, String num, String hol) {
		Tenant u = findByPrincipal();
		CreditCard aux = u.getCreditCard();
		Assert.notNull(aux);
		aux.setBrandName(br);
		aux.setCVV(cv);
		aux.setExpirationMonth(exp);
		aux.setExpirationYear(expy);
		aux.setNumber(num);
		aux.setHolderName(hol);
		u.setCreditCard(aux);
		return aux;
	}

	public CreditCard getMyCreditCard() {
		Tenant u = findByPrincipal();
		Assert.notNull(u);
		CreditCard aux = u.getCreditCard();
		Assert.notNull(aux);
		return aux;
	}

}