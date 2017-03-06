package domain;

import java.util.Collection;

import javax.persistence.*;


import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Lessor extends Actor implements Commentable {

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


	@OneToMany(cascade = CascadeType.ALL)
	public Collection<Comment> getComments() {
        return null;
    }

    @Override
    public void setComments(Collection<Comment> comments) {

    }
}