package in.ncag.church.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "roles")
public class PastorRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(mappedBy = "pastorRole", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Pastor> pastorList;

	

	@Column
	private String name;

	@Column
	private String created_by;

	

	@Column
	private Date created_at;

	@Column
	private Integer deleted_flag;

	@Column
	private String updated_by;

	@Column
	private Date updated_at;

	@Column
	private Integer app_id;

	public Integer getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<Pastor> getPastorList() {
		return pastorList;
	}


	public void setPastorList(List<Pastor> pastorList) {
		this.pastorList = pastorList;
	}


	public String getCreated_by() {
		return created_by;
	}


	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}


	public Date getCreated_at() {
		return created_at;
	}


	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}


	public Integer getDeleted_flag() {
		return deleted_flag;
	}


	public void setDeleted_flag(Integer deleted_flag) {
		this.deleted_flag = deleted_flag;
	}


	public String getUpdated_by() {
		return updated_by;
	}


	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}


	public Date getUpdated_at() {
		return updated_at;
	}


	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}


	public Integer getApp_id() {
		return app_id;
	}


	public void setApp_id(Integer app_id) {
		this.app_id = app_id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	
}
