package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

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
	
	
	@NotBlank	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	
	@NotBlank	
	public String getSocialNetwork() {
		return socialNetwork;
	}
	public void setSocialNetwork(String socialNetwork) {
		this.socialNetwork = socialNetwork;
	}
	
	
	@URL	
	@NotBlank	
	public String getURL() {
		return URL;
	}
	public void setURL(String URL) {
		this.URL = URL;
	}
	
}