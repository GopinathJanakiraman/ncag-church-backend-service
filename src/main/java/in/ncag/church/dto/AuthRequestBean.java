package in.ncag.church.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthRequestBean { 

	private String username;
	private String password;
	private boolean pastorDetailsRequired;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isPastorDetailsRequired() {
		return pastorDetailsRequired;
	}
	public void setPastorDetailsRequired(boolean pastorDetailsRequired) {
		this.pastorDetailsRequired = pastorDetailsRequired;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AuthRequestBean [pastorname=" + username + ", password=" + password  + ", pastorDetailsRequired="
				+ pastorDetailsRequired + "]";
	}	
}