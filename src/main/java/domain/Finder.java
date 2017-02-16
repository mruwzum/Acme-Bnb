package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.PROPERTY)
public class Finder extends DomainEntity {
	
	// Attributes ------------------------------------------------------------
	private String destinationCity;
	private double minimumPay;
	private double maximumPay;
	private String keyword;
	
	// Relationships ---------------------------------------------------------
	
	// Constructors -----------------------------------------------------------
	public Finder() {
		super();		
	}
	
	
	@NotEmpty
	@Digits(integer=9, fraction=2)
	public getDestinationcity() {
		return destinationcity;
	}

	public void setDestinationcity(String destinationcity) {
		this.destinationcity = destinationcity;
	}
	
	
	@NotEmpty
	@Digits(integer=9, fraction=2)
	public getMinimumpay() {
		return minimumpay;
	}

	public void setMinimumpay(Double minimumpay) {
		this.minimumpay = minimumpay;
	}
	
	
	@NotEmpty
	@Digits(integer=9, fraction=2)
	public getMaximumpay() {
		return maximumpay;
	}

	public void setMaximumpay(Double maximumpay) {
		this.maximumpay = maximumpay;
	}
	
	
	public getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}