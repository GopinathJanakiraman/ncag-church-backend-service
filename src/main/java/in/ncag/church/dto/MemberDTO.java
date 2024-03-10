package in.ncag.church.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberDTO {
	private int id;
	@JsonProperty(value="firstName")
	private String firstName;
	private String lastName;
	private int occupationId;
	private Integer pastorId;
	private String areaPastorName;
	private int cityId;
	private int stateId;
	private int countryId;
	private int pincode;
	private int regionId;
	private String regionName;
	private int memTypeId;
	private int carecellId;
	private Boolean isCarecell;
	private Boolean canVisitHouse;
	private Boolean isAttendingCHurch;
	private Boolean isLetterAccepted;
	private Date dob;
	private String mobileNo;
	private int areaId;
	private String areaName;
	private String email;
	private int religionId;
	private String religionName;
	private int size;
	private int page;
	private String carecellAddress; 
	private String address;
	private Date createAt;
	private Boolean martialStatus;
	private Integer oldChurchId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getCarecellAddress() {
		return carecellAddress;
	}
	public void setCarecellAddress(String carecellAddress) {
		this.carecellAddress = carecellAddress;
	}
	public int getOccupationId() {
		return occupationId;
	}
	public void setOccupationId(int occupationId) {
		this.occupationId = occupationId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Boolean getIsCarecell() {
		return isCarecell;
	}
	public void setIsCarecell(Boolean isCarecell) {
		this.isCarecell = isCarecell;
	}
	public Boolean getCanVisitHouse() {
		return canVisitHouse;
	}
	public void setCanVisitHouse(Boolean canVisitHouse) {
		this.canVisitHouse = canVisitHouse;
	}
	public Boolean getIsAttendingCHurch() {
		return isAttendingCHurch;
	}
	public void setIsAttendingCHurch(Boolean isAttendingCHurch) {
		this.isAttendingCHurch = isAttendingCHurch;
	}
	public Boolean getIsLetterAccepted() {
		return isLetterAccepted;
	}
	public void setIsLetterAccepted(Boolean isLetterAccepted) {
		this.isLetterAccepted = isLetterAccepted;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public int getMemTypeId() {
		return memTypeId;
	}
	public void setMemTypeId(int memTypeId) {
		this.memTypeId = memTypeId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getReligionId() {
		return religionId;
	}
	public void setReligionId(int religionId) {
		this.religionId = religionId;
	}
	
	public String getReligionName() {
		return religionName;
	}
	public void setReligionName(String religionName) {
		this.religionName = religionName;
	}
	public Integer getPastorId() {
		return pastorId;
	}
	public void setPastorId(Integer pastorId) {
		this.pastorId = pastorId;
	}
	
	
	public String getAreaPastorName() {
		return areaPastorName;
	}
	public void setAreaPastorName(String areaPastorName) {
		this.areaPastorName = areaPastorName;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Boolean getMartialStatus() {
		return martialStatus;
	}
	public void setMartialStatus(Boolean martialStatus) {
		this.martialStatus = martialStatus;
	}
	public Integer getOldChurchId() {
		return oldChurchId;
	}
	public void setOldChurchId(Integer oldChurchId) {
		this.oldChurchId = oldChurchId;
	}
	public int getCarecellId() {
		return carecellId;
	}
	public void setCarecellId(int carecellId) {
		this.carecellId = carecellId;
	}
	
	
}
