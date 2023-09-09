package in.ncag.church.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

import com.fasterxml.jackson.annotation.JsonIgnore;

import in.ncag.church.util.NCAGConstants;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "pastor")
@Data
@Getter
@Setter
public class Pastor {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private String address;
	
	@OneToOne(cascade = {})
	@JoinColumn(name ="city_id_fk")
	private City cityDetails;

	@OneToOne(cascade = {})
	@JoinColumn(name ="state_id_fk")
	private State stateDetails;
	
	@OneToOne(cascade = {})
	@JoinColumn(name ="country_id_fk")
	private Country countryDetails;
	
	@Column(nullable = false)
	private Integer pincode;
	
	@Column(nullable = false)
	private Date createAt;
	
	@Column(nullable = false)
	private String mobileNo;
	
	@Column(nullable = false)
	private String email;
	
	@OneToOne(cascade = {})
	@JoinColumn(name ="role_id_fk")
	private PastorRole pastorRole;
	
	@Column(name="failure_attempts")
	private int failureAttempts;
	
	@Column(name="password")
	@JsonIgnore
    @ColumnTransformer(
            read=NCAGConstants.COLUMN_TRANSFORMER_READ_AES_PASSCODE,
            write=NCAGConstants.COLUMN_TRANSFORMER_WRITE_AES)
	private String credential;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "pastorDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Area> areaList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public PastorRole getPastorRole() {
		return pastorRole;
	}

	public void setPastorRole(PastorRole pastorRole) {
		this.pastorRole = pastorRole;
	}

	public int getFailureAttempts() {
		return failureAttempts;
	}

	public void setFailureAttempts(int failureAttempts) {
		this.failureAttempts = failureAttempts;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public List<Area> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}
	
	
	
}
