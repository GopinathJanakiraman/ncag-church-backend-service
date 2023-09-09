package in.ncag.church.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 
import javax.persistence.Table;

@Entity(name = "oauth_access_tokens")
@Table(schema="ncag",name = "oauth_access_tokens",catalog="ncag")
public class RefreshAccessTokenModel {

	public RefreshAccessTokenModel(String userId, String accesstoken, String userName, 
			Date expiresAt,String scopes) {
		this.tokenId= accesstoken;
		this.name=userName;
		this.userId=userId;
		this.revoked=0;
		this.created_at=new Date();
		this.expires_at=expiresAt;
		this.scopes=scopes;
	}

	public RefreshAccessTokenModel() {
	}
	
	@Id
	@Column(name = "id", length=100)
	private String tokenId;
	
	@Column(name = "user_id")
	private String userId;
	@Column(name = "client_id")
	private String clientId;
	String name;
	@Column(name = "refresh_token")
	String refresh_token;
	String scopes;
	int revoked;
	Date created_at;
	Date updated_at;
	Date expires_at;
	String language;
	
	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getScopes() {
		return scopes;
	}

	public void setScopes(String scopes) {
		this.scopes = scopes;
	}

	public int getRevoked() {
		return revoked;
	}

	public void setRevoked(int revoked) {
		this.revoked = revoked;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Date getExpires_at() {
		return expires_at;
	}

	public void setExpires_at(Date expires_at) {
		this.expires_at = expires_at;
	}

	
}