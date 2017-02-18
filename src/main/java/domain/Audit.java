package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Audit extends DomainEntity {
	
	// Attributes ------------------------------------------------------------
	private Date writtenMoment;
	private String text;
	private String attachments;
	
	// Relationships ---------------------------------------------------------
	private Property property;
	private Auditor auditor;
	private Collection<Comment> comments;
	
	// Constructors -----------------------------------------------------------
	public Audit() {
		super();		
	}
	
	
	@NotNull
	@Temporal(TemporalType.DATE)
	public Date getWrittenMoment() {
		return writtenMoment;
	}

	public void setWrittenMoment(Date writtenMoment) {
		this.writtenMoment = writtenMoment;
	}
	
	
	@NotBlank
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}
	
	
	@ManyToOne(optional = false)
	@Valid
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
	
	
	@ManyToOne
	@Valid
	public Auditor getAuditor() {
		return auditor;
	}

	public void setAuditor(Auditor auditor) {
		this.auditor = auditor;
	}

	@OneToMany
	@Valid
	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}
}