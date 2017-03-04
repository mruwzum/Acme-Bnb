package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import java.util.Date;

@Entity
@Access(AccessType.PROPERTY)
public class BookRequest extends DomainEntity {
	
	// Attributes ------------------------------------------------------------
	private Date checkInDate;
	private Date checkOutDate;
	private boolean smoker;
	private CreditCard creditCard;
	private RequestStatus status;
	
	// Relationships ---------------------------------------------------------
	private Tenant tenant;
	private Property property;
	
	// Constructors -----------------------------------------------------------
	public BookRequest() {
		super();		
	}
	
	
	@NotNull
	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	
	
	@NotNull
	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public boolean isSmoker() {
		return smoker;
	}

	public void setSmoker(boolean smoker) {
		this.smoker = smoker;
	}
	


	@ManyToOne(optional = false)
	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
	
	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}
	
	
	@ManyToOne	@Valid
	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	
	
	@ManyToOne(optional = false)
	@Valid
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}



}