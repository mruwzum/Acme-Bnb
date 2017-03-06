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
public class Attribute extends DomainEntity {



	// Attributes ------------------------------------------------------------
	private String attributeName;
	private Value value;

	// Relationships ---------------------------------------------------------

	// Constructors -----------------------------------------------------------
	public Attribute() {
		super();		
	}
	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	@OneToOne
	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

}