package domain;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Access(AccessType.PROPERTY)
public class Value extends DomainEntity {



	// Attributes ------------------------------------------------------------
	private String valueName;

	private Attribute attribute;



	private Property property;


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


	@OneToOne(cascade = CascadeType.PERSIST)
	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}



	@ManyToOne(cascade = CascadeType.PERSIST)
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}



	@Override
	public String toString() {
		return "Value{" +
				"valueName='" + valueName + '\'' +
				'}';
	}
}