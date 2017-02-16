package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import import javax.validation.constraints.NotBlank;;
import import javax.validation.constraints.Email;
import import javax.validation.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Actor extends DomainEntity {
	
	// Attributes ------------------------------------------------------------
	private String name;
	private String surname;
	private String email;
	private String phone;
	private String picture;
	
	// Relationships ---------------------------------------------------------
	private SocialIdentity socialIdentity;
	
	// Constructors -----------------------------------------------------------
	public Actor() {
		super();		
	}
	
	
	@NotBlank
	@Notblank
	@Email
	@Pattern{&quot;(\
	@URL
	public getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@NotBlank
	@Notblank
	@Email
	@Pattern{&quot;(\
	@URL
	public getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	@NotBlank
	@Notblank
	@Email
	@Pattern{&quot;(\
	@URL
	public getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@NotBlank
	@Notblank
	@Email
	@Pattern{&quot;(\
	@URL
	public getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	@NotBlank
	@Notblank
	@Email
	@Pattern{&quot;(\
	@URL
	public getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	@OneToMany(mappedBy = "actor")
	@Valid
	public Collection<Socialidentity>getSocialidentity() {
		return socialidentity;
	}

	public void setSocialidentity(Socialidentity socialidentity) {
		this.socialidentity = socialidentity;
	}
	
	
}