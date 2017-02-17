package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.OneToMany;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Auditor extends Actor {
	
	// Attributes ------------------------------------------------------------
	private String nameOfCompany;
	
	// Relationships ---------------------------------------------------------
	private Collection<Audit> audits;
	
	// Constructors -----------------------------------------------------------
	public Auditor() {
		super();		
	}
	
	
	@NotBlank	public String getNameOfCompany() {
		return nameOfCompany;
	}

	public void setNameOfCompany(String nameOfCompany) {
		this.nameOfCompany = nameOfCompany;
	}
	
	
	@OneToMany
	@Valid
	public Collection<Audit> getAudits() {
		return audits;
	}

	public void setAudits(Audit audit) {
		this.audits = audits;
	}
	
	
	
}