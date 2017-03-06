package domain;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Access(AccessType.PROPERTY)
public class Value extends DomainEntity {



	// Attributes ------------------------------------------------------------
	private String valueName;


	// Relationships ---------------------------------------------------------

	// Constructors -----------------------------------------------------------
	public Value() {
		super();		
	}


	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

}