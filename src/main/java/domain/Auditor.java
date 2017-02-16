package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.PROPERTY)
public class Auditor extends Actor {
	
	// Attributes ------------------------------------------------------------
	private String nameOfCompany;
	
	// Relationships ---------------------------------------------------------
	private Audit audit;
	
	// Constructors -----------------------------------------------------------
	public Auditor() {
		super();		
	}
	
	
	@Notblank
	public getNameofcompany() {
		return nameofcompany;
	}

	public void setNameofcompany(String nameofcompany) {
		this.nameofcompany = nameofcompany;
	}
	
	
	@OneToMany(mappedBy = "auditor")
	@Valid
	public Collection<Audit>getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	
	
}