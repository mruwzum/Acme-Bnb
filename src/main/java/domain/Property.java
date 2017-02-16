package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import import javax.validation.constraints.NotNull;

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
	private Audit audit;
	private BookRequest bookRequest;
	
	// Constructors -----------------------------------------------------------
	public Property() {
		super();		
	}
	
	
	@Notblank
	@NotNull
	public  getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@Notblank
	@NotNull
	public  getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}
	
	
	public  getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Notblank
	@NotNull
	public  getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Notblank
	@NotNull
	public  getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	
	@Notblank
	@NotNull
	public  getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	@Notblank
	@NotNull
	public  getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	@Notblank
	@NotNull
	public  getCapacity() {
		return capacity;
	}

	public void setCapacity(Int capacity) {
		this.capacity = capacity;
	}
	
	
	@Notblank
	@NotNull
	public  getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	@ManyToOne(mappedBy = "property")
	@Valid
	public Lessor getLessor() {
		return lessor;
	}

	public void setLessor(Lessor lessor) {
		this.lessor = lessor;
	}
	
	
	@OneToMany(mappedBy = "property", optional = false)
	@Valid
	public Collection<Audit> getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	
	
	@OneToMany(mappedBy = "property", optional = false)
	@Valid
	public Collection<BookRequest> getBookRequest() {
		return bookRequest;
	}

	public void setBookRequest(BookRequest bookRequest) {
		this.bookRequest = bookRequest;
	}
	
	
}