package in.ncag.church.dto;

import java.util.Date;
import java.util.List;

import in.ncag.church.model.Area;

public class RegionDTO {

	private int regionId;
	
	private String regionName;
	
	private Integer pastorId;
	
	private String pastorName;
	
	private List<Area> areaList;
	
	private Date createAt;

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Integer getPastorId() {
		return pastorId;
	}

	public void setPastorId(Integer pastorId) {
		this.pastorId = pastorId;
	}

	public String getPastorName() {
		return pastorName;
	}

	public void setPastorName(String pastorName) {
		this.pastorName = pastorName;
	}

	public List<Area> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	
}
