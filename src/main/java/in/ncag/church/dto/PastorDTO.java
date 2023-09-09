package in.ncag.church.dto;


public class PastorDTO {
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String pastorRole;
	private Integer pastorRoleId;
	private String credential;
	private String responseToken;
	private Integer failureAttempts;
	
	public String getResponseToken() {
		return responseToken;
	}
	public void setResponseToken(String responseToken) {
		this.responseToken = responseToken;
	}
	public Integer getPastorRoleId() {
		return pastorRoleId;
	}
	public void setPastorRoleId(Integer pastorRoleId) {
		this.pastorRoleId = pastorRoleId;
	}	
	
	/**
	 * @return the credential
	 */
	public String getCredential() {
		return credential;
	}
	
	/**
	 * @param credential the credential to set
	 */
	public void setCredential(String credential) {
		this.credential = credential;
	}
	
	public String getPastorRole() {
		return pastorRole;
	}
	public void setPastorRole(String pastorRole) {
		this.pastorRole = pastorRole;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getFailureAttempts() {
		return failureAttempts;
	}
	public void setFailureAttempts(Integer failureAttempts) {
		this.failureAttempts = failureAttempts;
	}
}
