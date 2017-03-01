package domain;

import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Administrator extends Actor {



	// Attributes ------------------------------------------------------------

	// Relationships ---------------------------------------------------------
	
	// Constructors -----------------------------------------------------------
	public Administrator() {
		super();		
	}

}