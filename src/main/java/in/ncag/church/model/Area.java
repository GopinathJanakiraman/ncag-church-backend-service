package in.ncag.church.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "area")
public class Area {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String name;
	
	@OneToOne(cascade = {})
	@JoinColumn(name ="pastorIdFk")
	private Pastor pastorDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pastor getPastorDetails() {
		return pastorDetails;
	}

	public void setPastorDetails(Pastor pastorDetails) {
		this.pastorDetails = pastorDetails;
	}
	
	
	
}
