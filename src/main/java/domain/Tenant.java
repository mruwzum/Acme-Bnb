package domain;

import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Tenant extends Actor implements Commentable {

	// Attributes ------------------------------------------------------------
	private CreditCard creditCard;

	// Relationships ---------------------------------------------------------
	private Collection<BookRequest> bookRequests;
	private Collection<Invoice> invoices;
	private Collection<Finder> finders;
	private Collection<Comment> comments;


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



	@OneToOne(targetEntity = CreditCard.class, cascade = CascadeType.ALL)
	public CreditCard getCreditCard() {
		return creditCard;
	}


	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}


	@OneToMany(cascade = CascadeType.PERSIST)
	public Collection<Comment> getComments() {
		return comments;
	}

    public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}
}