package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import import javax.validation.constraints.NotNull;

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
	private Comment comment;
	
	// Constructors -----------------------------------------------------------
	public Audit() {
		super();		
	}
	
	
	@NotNull
	@Notblank
	public getWrittenmoment() {
		return writtenmoment;
	}

	public void setWrittenmoment(Date writtenmoment) {
		this.writtenmoment = writtenmoment;
	}
	
	
	@NotNull
	@Notblank
	public getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	public getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}
	
	
	@ManyToOne(optional = false)
	@Valid
	public PropertygetProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
	
	
	@ManyToOne(mappedBy = "audit")
	@Valid
	public AuditorgetAuditor() {
		return auditor;
	}

	public void setAuditor(Auditor auditor) {
		this.auditor = auditor;
	}
	
	
	@OneToMany(mappedBy = "audit")
	@Valid
	public Collection<Comment>getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	
}