package in.ncag.church.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "membercopy")
public class Member {

	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Integer familyHeadId;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private String address;
	
	@ManyToOne(cascade = {})
	@JoinColumn(name ="area_id_fk")
	private Area areaDetails;
	
	@ManyToOne(cascade = {})
	@JoinColumn(name ="city_id_fk")
	private City cityDetails;

	@ManyToOne(cascade = {})
	@JoinColumn(name ="state_id_fk")
	private State stateDetails;
	
	@ManyToOne(cascade = {})
	@JoinColumn(name ="country_id_fk")
	private Country countryDetails;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name ="carecell_id_fk")
    @JsonBackReference
	private Carecell carecellDetails;
	
	@ManyToOne(cascade = {})
	@JoinColumn(name ="member_type_id_fk")
	private MemberType memberTypeDetails;
	
	@ManyToMany
	private Set<Ministry> ministriesInterested = new HashSet<>();
	
	
	
	
	
	
	
	@Column(nullable = false)
	private Integer oldChurchId;
	
	@Column(nullable = false)
	private Boolean martialStatus;
	
	@Column(nullable = false)
	@CreationTimestamp
	private Date createAt;
	
	@Column(nullable = false)
	private Date dob;
	
	@ManyToOne(cascade = {})
	@JoinColumn(name ="occupation_id_fk")
	private Occupation occupationDetails;
	
	@Column(nullable = false)
	private String mobileNo;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column
	private Boolean isCarecell;
	
	@Column
	private Boolean canVisitHouse;
	
	@Column
	private Boolean isAttendingCHurch;
	
	@Column
	private Boolean isLetterAccepted;
	
	@ManyToOne(cascade = {})
	@JoinColumn(name ="religion_id_fk")
	private Religion religionDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFamilyHeadId() {
		return familyHeadId;
	}

	public void setFamilyHeadId(Integer familyHeadId) {
		this.familyHeadId = familyHeadId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Area getAreaDetails() {
		return areaDetails;
	}

	public void setAreaDetails(Area areaDetails) {
		this.areaDetails = areaDetails;
	}

	public City getCityDetails() {
		return cityDetails;
	}

	public void setCityDetails(City cityDetails) {
		this.cityDetails = cityDetails;
	}

	public State getStateDetails() {
		return stateDetails;
	}

	public void setStateDetails(State stateDetails) {
		this.stateDetails = stateDetails;
	}

	public Country getCountryDetails() {
		return countryDetails;
	}

	public void setCountryDetails(Country countryDetails) {
		this.countryDetails = countryDetails;
	}

	public Carecell getCarecellDetails() {
		return carecellDetails;
	}

	public void setCarecellDetails(Carecell carecellDetails) {
		this.carecellDetails = carecellDetails;
	}

	

	

	public Integer getOldChurchId() {
		return oldChurchId;
	}

	public void setOldChurchId(Integer oldChurchId) {
		this.oldChurchId = oldChurchId;
	}

	public Boolean getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(Boolean martialStatus) {
		this.martialStatus = martialStatus;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Occupation getOccupationDetails() {
		return occupationDetails;
	}

	public void setOccupationDetails(Occupation occupationDetails) {
		this.occupationDetails = occupationDetails;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public MemberType getMemberTypeDetails() {
		return memberTypeDetails;
	}

	public void setMemberTypeDetails(MemberType memberTypeDetails) {
		this.memberTypeDetails = memberTypeDetails;
	}

	public Set<Ministry> getMinistriesInterested() {
		return ministriesInterested;
	}

	public void setMinistriesInterested(Set<Ministry> ministriesInterested) {
		this.ministriesInterested = ministriesInterested;
	}

	public Religion getReligionDetails() {
		return religionDetails;
	}

	public void setReligionDetails(Religion religionDetails) {
		this.religionDetails = religionDetails;
	}

	

}
