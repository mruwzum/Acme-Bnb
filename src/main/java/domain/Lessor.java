package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.CreditCardNumber;
import javax.persistence.OneToMany;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Lessor extends Actor {
	
	// Attributes ------------------------------------------------------------
	private String creditCard;
	
	// Relationships ---------------------------------------------------------
	private Collection<Property> propertys;
	
	// Constructors -----------------------------------------------------------
	public Lessor() {
		super();		
	}
	
	
	@CreditCardNumber	
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	
	
	@OneToMany(mappedBy = "lessor")
	@Valid
	public Collection<Property> getPropertys() {
		return propertys;
	}
	public void setPropertys(Property property) {
		this.propertys = propertys;
	}
	
}