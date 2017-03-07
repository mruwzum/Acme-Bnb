package domain;

import java.util.Collection;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.URL;
import security.UserAccount;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Access(AccessType.PROPERTY)
public class Actor extends DomainEntity {
	
	// Attributes ------------------------------------------------------------
	private String name;
	private String surname;
	private String email;
	private String phone;
	private String picture;
	private UserAccount userAccount;

	// Relationships ---------------------------------------------------------
	private Collection<SocialIdentity> socialIdentitys;
	
	// Constructors -----------------------------------------------------------
	public Actor() {
		super();		
	}
	


	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@NotBlank
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	@Email
	@NotBlank
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Pattern(regexp = "(\\+\\d{1,3}[ -.])?(\\(?\\d+\\)?[ -.]?)+")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	@URL
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}


    @OneToMany(cascade = CascadeType.ALL)
    @Valid
	public Collection<SocialIdentity> getSocialIdentitys() {
		return socialIdentitys;
	}

	public void setSocialIdentitys(Collection<SocialIdentity> socialIdentitys) {
		this.socialIdentitys = socialIdentitys;
	}

	@NotNull
	@Valid
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}


	@Override
	public String toString() {
		return  name +" " +
				surname;
	}
}