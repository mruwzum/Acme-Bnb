package domain;

import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Tenant extends Actor {
	
	// Attributes ------------------------------------------------------------
	private String creditCard;

	// Relationships ---------------------------------------------------------
	private Collection<BookRequest> bookRequests;
	private Collection<Invoice> invoices;
	private Collection<Finder> finders;
	
	// Constructors -----------------------------------------------------------
	public Tenant() {
		super();		
	}

	@OneToMany(mappedBy = "tenant")
	@Valid
	public Collection<BookRequest> getBookRequests() {
		return bookRequests;
	}

	public void setBookRequests(Collection<BookRequest> bookRequests) {
		this.bookRequests = bookRequests;
	}

	@OneToMany(mappedBy = "tenant")
	@Valid
	public Collection<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Collection<Invoice> invoices) {
		this.invoices = invoices;
	}

	@OneToMany
	@Valid
	public Collection<Finder> getFinders() {
		return finders;
	}

	public void setFinders(Collection<Finder> finders) {
		this.finders = finders;
	}


	@CreditCardNumber
	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}



}