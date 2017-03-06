package domain;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

@Entity
@Access(AccessType.PROPERTY)
public class Comment extends DomainEntity {
	
	// Attributes ------------------------------------------------------------
	private String title;
	private Date postedMoment;
	private String text;
	private int numberOfStars;
	private DomainEntity target;
	
	// Relationships ---------------------------------------------------------
	
	// Constructors -----------------------------------------------------------
	public Comment() {
		super();		
	}
	
	
	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	@NotNull
	public Date getPostedMoment() {
		return postedMoment;
	}

	public void setPostedMoment(Date postedMoment) {
		this.postedMoment = postedMoment;
	}
	
	
	@NotBlank
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	@Range(min=0, max=5)
	@NotNull
	public int getNumberOfStars() {
		return numberOfStars;
	}

	public void setNumberOfStars(int numberOfStars) {
		this.numberOfStars = numberOfStars;
	}


	@OneToOne
	public DomainEntity getTarget() {
		return target;
	}

	public void setTarget(DomainEntity domainEntity) {
		this.target = domainEntity;
	}


}