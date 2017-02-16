package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import import javax.validation.constraints.CreditCardNumber;

@Entity
@Access(AccessType.PROPERTY)
public class Invoice extends DomainEntity {
	
	// Attributes ------------------------------------------------------------
	private Date issuedMoment;
	private int VATNumber;
	private String tenantInfo;
	private String details;
	private double totalAmount;
	private String creditCard;
	
	// Relationships ---------------------------------------------------------
	private Tenant tenant;
	
	// Constructors -----------------------------------------------------------
	public Invoice() {
		super();		
	}
	
	
	public Date getIssuedMoment() {
		return issuedMoment;
	}

	public void setIssuedMoment(Date issuedMoment) {
		this.issuedMoment = issuedMoment;
	}
	
	
	public int getVATNumber() {
		return vATNumber;
	}

	public void setVATNumber(Int vATNumber) {
		this.vATNumber = vATNumber;
	}
	
	
	public String getTenantInfo() {
		return tenantInfo;
	}

	public void setTenantInfo(String tenantInfo) {
		this.tenantInfo = tenantInfo;
	}
	
	
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
	@Digits(integer=9, fraction=2)
	@CreditCardNumber
	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	@Digits(integer=9, fraction=2)
	@CreditCardNumber
	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	
	
	@ManyToOne(mappedBy = "Invoice")
	@Valid
	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	
	
}