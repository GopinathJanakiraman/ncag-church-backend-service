package in.ncag.church.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "oauth_refresh_tokens")
@Table(schema = "ncag", name = "oauth_refresh_tokens", catalog = "ncag")
public class RefreshTokenModel {

	@Id
	@Column(length = 100)
	String id;
	@Column(name = "access_token_id")
	String accessId;
	int revoked;
	@Column(name = "expires_at")
	Date expiresAt;

	public RefreshTokenModel(String refreshToken, String accessId, boolean active, Date expiry) {

		this.id = refreshToken;
		this.accessId = accessId;
		this.revoked = active ? 1 : 0;
		this.expiresAt = expiry;

	}

	public RefreshTokenModel() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccessId() {
		return accessId;
	}

	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	public int getRevoked() {
		return revoked;
	}

	public void setRevoked(int revoked) {
		this.revoked = revoked;
	}

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}
}