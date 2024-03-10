package in.ncag.church.dto;

import java.util.List;

import in.ncag.church.model.Member;

public class CarecellDTO {

	private String carecellName;
	
	private int carecellId;
	
	private List<Member> carecellMembers;
	
	private String pastorName;
	
	private int pastorId;
	
	private String areaName;
	
	private int areaId;
	
	private String regionName;
	
	private int regionId;

	public String getCarecellName() {
		return carecellName;
	}

	public void setCarecellName(String carecellName) {
		this.carecellName = carecellName;
	}

	public int getCarecellId() {
		return carecellId;
	}

	public void setCarecellId(int carecellId) {
		this.carecellId = carecellId;
	}

	public List<Member> getCarecellMembers() {
		return carecellMembers;
	}

	public void setCarecellMembers(List<Member> carecellMembers) {
		this.carecellMembers = carecellMembers;
	}

	public String getPastorName() {
		return pastorName;
	}

	public void setPastorName(String pastorName) {
		this.pastorName = pastorName;
	}

	public int getPastorId() {
		return pastorId;
	}

	public void setPastorId(int pastorId) {
		this.pastorId = pastorId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	
	
}
