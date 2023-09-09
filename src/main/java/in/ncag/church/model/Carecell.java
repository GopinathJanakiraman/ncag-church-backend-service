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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carecell")
public class Carecell {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@OneToOne
	@JoinColumn(name ="areaId")
	private Area areaDetails;
	
	@OneToMany(mappedBy = "carecellDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CarecellMember> carecellMemberList;

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

	public List<CarecellMember> getCarecellMemberList() {
		return carecellMemberList;
	}

	public void setCarecellMemberList(List<CarecellMember> carecellMemberList) {
		this.carecellMemberList = carecellMemberList;
	}
	
	
}
