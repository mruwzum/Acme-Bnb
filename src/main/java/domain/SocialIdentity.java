package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import import javax.validation.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class SocialIdentity extends DomainEntity {
	
	// Attributes ------------------------------------------------------------
	private String nick;
	private String socialNetwork;
	private String URL;
	
	// Relationships ---------------------------------------------------------
	
	// Constructors -----------------------------------------------------------
	public SocialIdentity() {
		super();		
	}
	
	
	@Notblank
	@Url
	public getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	
	@Notblank
	@Url
	public getSocialnetwork() {
		return socialnetwork;
	}

	public void setSocialnetwork(String socialnetwork) {
		this.socialnetwork = socialnetwork;
	}
	
	
	@Notblank
	@Url
	public getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}