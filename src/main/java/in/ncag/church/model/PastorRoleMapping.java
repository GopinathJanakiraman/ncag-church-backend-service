package in.ncag.church.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "role_mapping")
public class PastorRoleMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int roleMappingId;

	@Column(name = "role_id_fk")
	private int roleId;

	@Column(name = "capability_id_fk")
	private int capabilityId;
	
	@Column(name = "status")
	private int status;

	

}
