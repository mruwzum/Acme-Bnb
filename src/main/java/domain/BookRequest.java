package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import import javax.validation.constraints.NotNull;
import import javax.validation.constraints.CreditCardNumber;

@Entity
@Access(AccessType.PROPERTY)
public class BookRequest extends DomainEntity {
	
	// Attributes ------------------------------------------------------------
	private Date checkInDate;
	private Date checkOutDate;
	private boolean smoker;
	private String creditCard;
	private requestStatus status;
	
	// Relationships ---------------------------------------------------------
	private Tenant tenant;
	private Property property;
	
	// Constructors -----------------------------------------------------------
	public BookRequest() {
		super();		
	}
	
	
	@NotNull
	@CreditCardNumber
	@Notblank
	public getCheckindate() {
		return checkindate;
	}

	public void setCheckindate(Date checkindate) {
		this.checkindate = checkindate;
	}
	
	
	@NotNull
	@CreditCardNumber
	@Notblank
	public getCheckoutdate() {
		return checkoutdate;
	}

	public void setCheckoutdate(Date checkoutdate) {
		this.checkoutdate = checkoutdate;
	}
	
	
	public getSmoker() {
		return smoker;
	}

	public void setSmoker(Boolean smoker) {
		this.smoker = smoker;
	}
	
	
	@NotNull
	@CreditCardNumber
	@Notblank
	public getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}
	
	
	public getStatus() {
		return status;
	}

	public void setStatus(Requeststatus status) {
		this.status = status;
	}
	
	
	@ManyToOne(mappedBy = "bookrequest")
	@Valid
	public TenantgetTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	
	
	@ManyToOne(optional = false)
	@Valid
	public PropertygetProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
	
	
}