package in.ncag.church.dto;

import java.util.List;

import in.ncag.church.model.City;
import in.ncag.church.model.Country;
import in.ncag.church.model.MemberType;
import in.ncag.church.model.Occupation;
import in.ncag.church.model.Religion;
import in.ncag.church.model.State;

public class StaticDTO {

	private List<MemberType> memberType;
	
	private List<City> cityList;
	
	private List<State> stateList;
	
	private List<Country> countryList;
	
	private List<Occupation> occupationList;
	
	private List<Religion> religionList;

	public List<MemberType> getMemberType() {
		return memberType;
	}

	public void setMemberType(List<MemberType> memberType) {
		this.memberType = memberType;
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
	
	
}
