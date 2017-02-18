package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import org.hibernate.validator.constraints.CreditCardNumber;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import java.util.Date;

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
		return VATNumber;
	}

	public void setVATNumber(int VATNumber) {
		this.VATNumber = VATNumber;
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
	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	@CreditCardNumber
	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	
	
	@ManyToOne
	@Valid
	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	
	
	
}