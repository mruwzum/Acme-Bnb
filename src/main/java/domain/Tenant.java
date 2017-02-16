package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.PROPERTY)
public class Tenant extends Actor {
	
	// Attributes ------------------------------------------------------------
	
	// Relationships ---------------------------------------------------------
	private BookRequest bookRequest;
	private Invoice invoice;
	private Finder finder;
	
	// Constructors -----------------------------------------------------------
	public Tenant() {
		super();		
	}
	
	
	@OneToMany(mappedBy = "tenant")
	@Valid
	public Collection<Bookrequest>getBookrequest() {
		return bookrequest;
	}

	public void setBookrequest(Bookrequest bookrequest) {
		this.bookrequest = bookrequest;
	}
	
	
	@OneToMany(mappedBy = "tenant")
	@Valid
	public Collection<Invoice>getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	
	@OneToMany(mappedBy = "tenant")
	@Valid
	public Collection<Finder>getFinder() {
		return finder;
	}

	public void setFinder(Finder finder) {
		this.finder = finder;
	}
	
	
}