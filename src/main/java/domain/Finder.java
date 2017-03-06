package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import java.util.Collection;

@Entity
@Access(AccessType.PROPERTY)
public class Finder extends DomainEntity {
	
	// Attributes ------------------------------------------------------------
	private String destinationCity;
	private double minimumPay;
	private double maximumPay;
	private String keyword;

	private Integer numberOfFinderResults;


	// Relationships ---------------------------------------------------------
	
	// Constructors -----------------------------------------------------------
	public Finder() {
		super();		
	}
	
	
	@NotBlank
	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	
	
	@Digits(integer=9, fraction=2)
	public double getMinimumPay() {
		return minimumPay;
	}

	public void setMinimumPay(double minimumPay) {
		this.minimumPay = minimumPay;
	}
	
	
	@Digits(integer=9, fraction=2)
	public double getMaximumPay() {
		return maximumPay;
	}

	public void setMaximumPay(double maximumPay) {
		this.maximumPay = maximumPay;
	}
	
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public Integer getNumberOfFinderResults() {
		return numberOfFinderResults;
	}

	public void setNumberOfFinderResults(Integer numberOfFinderResults) {
		this.numberOfFinderResults = numberOfFinderResults;
	}
}