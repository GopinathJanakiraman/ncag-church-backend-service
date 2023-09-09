package in.ncag.church.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carecellstages")
public class CareCellStages {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false, unique= true)
	private String carecellStageName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCarecellStageName() {
		return carecellStageName;
	}

	public void setCarecellStageName(String carecellStageName) {
		this.carecellStageName = carecellStageName;
	}
	
	
}
