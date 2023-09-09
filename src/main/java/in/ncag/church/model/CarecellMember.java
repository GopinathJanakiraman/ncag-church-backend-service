package in.ncag.church.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "carecellmember")
public class CarecellMember {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "memberIdFk", referencedColumnName = "id")
    private Member memberDetails;
		
	@OneToOne(cascade = {})
	@JoinColumn(name ="carecell_id_fk")
	@JsonIgnore
	private Carecell carecellDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	

	public Member getMemberDetails() {
		return memberDetails;
	}

	public void setMemberDetails(Member memberDetails) {
		this.memberDetails = memberDetails;
	}

	public Carecell getCarecellDetails() {
		return carecellDetails;
	}

	public void setCarecellDetails(Carecell carecellDetails) {
		this.carecellDetails = carecellDetails;
	}
	
	
	
	
}
