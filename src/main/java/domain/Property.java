package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.persistence.OneToMany;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Property extends DomainEntity {
	
	// Attributes ------------------------------------------------------------
	private String name;
	private double rate;
	private String description;
	private String address;
	private String province;
	private String country;
	private String state;
	private int capacity;
	private String city;
	
	// Relationships ---------------------------------------------------------
	private Lessor lessor;
	private Collection<Audit> audits;
	private Collection<BookRequest> bookRequests;
	
	// Constructors -----------------------------------------------------------
	public Property() {
		super();		
	}
	
	
	@NotBlank	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@NotNull	
	@Digits(integer = 8,fraction=2)
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@NotBlank	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@NotBlank	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	
	@NotBlank	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	@NotBlank	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	@NotNull	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	@NotBlank	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	@ManyToOne	
	@Valid
	public Lessor getLessor() {
		return lessor;
	}
	public void setLessor(Lessor lessor) {
		this.lessor = lessor;
	}
	
	
	@OneToMany(mappedBy = "property")
	@Valid
	public Collection<Audit> getAudits() {
		return audits;
	}
	public void setAudits(Collection<Audit> audits) {
		this.audits = audits;
	}
	
	
	@OneToMany(mappedBy = "property")
	@Valid
	public Collection<BookRequest> getBookRequests() {
		return bookRequests;
	}
	public void setBookRequests(Collection<BookRequest> bookRequest) {
		this.bookRequests = bookRequests;
	}
	
	
	
}