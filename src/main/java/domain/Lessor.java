package domain;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Lessor extends Actor {
	
	// Attributes ------------------------------------------------------------
	private CreditCard creditCard;
	
	// Relationships ---------------------------------------------------------
	private Collection<Property> propertys;

	private List<Comment> comments;


	// Constructors -----------------------------------------------------------
	public Lessor() {
		super();
	}






	@OneToOne(targetEntity = CreditCard.class, cascade = CascadeType.ALL)
	public CreditCard getCreditCard() {
		return creditCard;
	}


	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}




	@OneToMany(mappedBy = "lessor")
	@Valid
	public Collection<Property> getPropertys() {
		return propertys;
	}

	public void setPropertys(Collection<Property> propertys) {
		this.propertys = propertys;
	}


	@OneToMany(cascade = CascadeType.ALL)
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}