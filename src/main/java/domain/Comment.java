package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import import javax.validation.constraints.NotNull;
import import javax.validation.constraints.Range;

@Entity
@Access(AccessType.PROPERTY)
public class Comment extends DomainEntity {
	
	// Attributes ------------------------------------------------------------
	private String title;
	private Date postedMoment;
	private String text;
	private int numberOfStars;
	
	// Relationships ---------------------------------------------------------
	
	// Constructors -----------------------------------------------------------
	public Comment() {
		super();		
	}
	
	
	@Notblank
	@NotNull
	@Range(min=0, max=5)
	public getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	@Notblank
	@NotNull
	@Range(min=0, max=5)
	public getPostedmoment() {
		return postedmoment;
	}

	public void setPostedmoment(Date postedmoment) {
		this.postedmoment = postedmoment;
	}
	
	
	@Notblank
	@NotNull
	@Range(min=0, max=5)
	public getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	@Notblank
	@NotNull
	@Range(min=0, max=5)
	public getNumberofstars() {
		return numberofstars;
	}

	public void setNumberofstars(Int numberofstars) {
		this.numberofstars = numberofstars;
	}
	
	
}