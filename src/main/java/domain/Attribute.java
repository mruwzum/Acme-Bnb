package domain;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;

@Entity
@Access(AccessType.PROPERTY)
public class Attribute extends DomainEntity {



	// Attributes ------------------------------------------------------------
	private String attributeName;
	private Collection<Value> value;

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

	@OneToMany(cascade = CascadeType.ALL)
	public Collection<Value> getValue() {
		return value;
	}

	public void setValue(Collection<Value> value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Attribute{" +
				"attributeName='" + attributeName + '\'' +
				'}';
	}
}