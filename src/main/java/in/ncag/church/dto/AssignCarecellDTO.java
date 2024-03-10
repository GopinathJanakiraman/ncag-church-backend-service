package in.ncag.church.dto;

import java.util.List;

public class AssignCarecellDTO {

	private List<Integer> ids;
	private int careId;
	private int areaId;
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	public int getCareId() {
		return careId;
	}
	public void setCareId(int careId) {
		this.careId = careId;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	
}
