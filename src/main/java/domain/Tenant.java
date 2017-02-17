package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.persistence.OneToMany;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Tenant extends Actor {
	
	// Attributes ------------------------------------------------------------
	
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

	public void setBookRequests(BookRequest bookRequest) {
		this.bookRequests = bookRequests;
	}
	
	
	@OneToMany(mappedBy = "tenant")
	@Valid
	public Collection<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Invoice invoice) {
		this.invoices = invoices;
	}
	
	
	@OneToMany
	@Valid
	public Collection<Finder> getFinders() {
		return finders;
	}

	public void setFinders(Finder finder) {
		this.finders = finders;
	}
	
	
	
}