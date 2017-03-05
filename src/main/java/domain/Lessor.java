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



}