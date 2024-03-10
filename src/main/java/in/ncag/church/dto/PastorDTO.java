package in.ncag.church.dto;

import java.util.Date;

public class PastorDTO {
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String mobileNo;
	private String pastorRole;
	private Integer pastorRoleId;
	private String credential;
	private String responseToken;
	private Integer failureAttempts;
	private String regionName;
	private int regionId;
	private int areaId;
	private String areaName;
	private int cityId;
	private String cityName;
	private int stateId;
	private String stateName;
	private int countryId;
	private String countryName;
	private String address;
	private Integer pincode;
	private Date createAt;
	private int roleId;
	private String roleName;
	private String password;
	private String oldPassword;
	
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
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	
}
