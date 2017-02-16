package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.PROPERTY)
public class String extends DomainEntity {
	
	// Attributes ------------------------------------------------------------
	
	// Relationships ---------------------------------------------------------
	
	// Constructors -----------------------------------------------------------
	public String() {
		super();		
	}
	
	
}