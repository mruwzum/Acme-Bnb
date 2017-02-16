package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import import javax.validation.constraints.CreditCardNumber;

@Entity
@Access(AccessType.PROPERTY)
public class Lessor extends Actor {
	
	// Attributes ------------------------------------------------------------
	private String creditCard;
	
	// Relationships ---------------------------------------------------------
	private Property property;
	
	// Constructors -----------------------------------------------------------
	public Lessor() {
		super();		
	}
	
	
	@CreditCardNumber
	public getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}
	
	
	@OneToMany(mappedBy = "lessor")
	@Valid
	public Collection<Property>getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
	
	
}