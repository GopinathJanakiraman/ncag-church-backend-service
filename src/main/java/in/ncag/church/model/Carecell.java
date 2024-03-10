package in.ncag.church.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "carecell")
public class Carecell {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name ="areaId")
	private Area areaDetails;
	
	private String carecellAddress;
	
	@OneToMany(mappedBy = "carecellDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Member> carecellMemberList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Area getAreaDetails() {
		return areaDetails;
	}

	public void setAreaDetails(Area areaDetails) {
		this.areaDetails = areaDetails;
	}

	public List<Member> getCarecellMemberList() {
		return carecellMemberList;
	}

	public void setCarecellMemberList(List<Member> carecellMemberList) {
		this.carecellMemberList = carecellMemberList;
	}

	public String getCarecellAddress() {
		return carecellAddress;
	}

	public void setCarecellAddress(String carecellAddress) {
		this.carecellAddress = carecellAddress;
	}
	
	
}
