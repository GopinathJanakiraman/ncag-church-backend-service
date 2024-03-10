package in.ncag.church.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import in.ncag.church.model.Area;
import in.ncag.church.model.City;
import in.ncag.church.model.Country;
import in.ncag.church.model.MemberType;
import in.ncag.church.model.Occupation;
import in.ncag.church.model.Pastor;
import in.ncag.church.model.PastorRole;
import in.ncag.church.model.Region;
import in.ncag.church.model.Religion;
import in.ncag.church.model.State;

public class StaticDTO {

	private List<MemberType> memberType;
	
	private List<Area> areaList;
	
	private List<City> cityList;
	
	private List<State> stateList;
	
	private List<Country> countryList;
	
	private List<Occupation> occupationList;
	
	private List<Religion> religionList;
	
	private List<Region> regionList;
	
	private List<Pastor> pastorList;
	
	private List<PastorRole> roleList;

	public List<MemberType> getMemberType() {
		return memberType;
	}

	public void setMemberType(List<MemberType> memberType) {
		this.memberType = memberType;
	}

	public List<Area> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public List<State> getStateList() {
		return stateList;
	}

	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}

	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}

	public List<Occupation> getOccupationList() {
		return occupationList;
	}

	public void setOccupationList(List<Occupation> occupationList) {
		this.occupationList = occupationList;
	}

	public List<Religion> getReligionList() {
		return religionList;
	}

	public void setReligionList(List<Religion> religionList) {
		this.religionList = religionList;
	}

	
	public List<Region> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<Region> regionList) {
		this.regionList = regionList;
	}

	public List<Pastor> getPastorList() {
		return pastorList;
	}

	public void setPastorList(List<Pastor> pastorList) {
		this.pastorList = pastorList;
	}

	public List<PastorRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<PastorRole> roleList) {
		this.roleList = roleList;
	}
	
	
}
