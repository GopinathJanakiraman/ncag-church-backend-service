package in.ncag.church.serviceImpl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ncag.church.dto.MemberDTO;
import in.ncag.church.dto.StaticDTO;
import in.ncag.church.model.Member;
import in.ncag.church.repository.CityRepository;
import in.ncag.church.repository.CountryRepository;
import in.ncag.church.repository.MemberRepository;
import in.ncag.church.repository.MemberTypeRepository;
import in.ncag.church.repository.OccupationRepository;
import in.ncag.church.repository.ReligionRepository;
import in.ncag.church.repository.StateRepository;
import in.ncag.church.service.MemberService;
@Service
public class UserServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberTypeRepository memTypeRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private OccupationRepository occupationRepository;
	
	@Autowired
	private ReligionRepository religionRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	private Type listDTOType=new TypeToken<List<MemberDTO>>(){}.getType();
	@Override
	public Member create(Member pastor) {
		memberRepository.flush();
		return memberRepository.save(pastor);
	}

	@Override
	public Member delete(int id) {
		Optional<Member> optional = memberRepository.findById(id);
		
		if(optional.isPresent()) {
			Member pastor = optional.get();
			if(pastor != null) {
				memberRepository.delete(pastor);
			}
			return pastor;
		}
		return null;
	}

	@Override
	public List<Member> findAll() {
		
		List<Member> memberDTO = memberRepository.findAll();
		return memberDTO;
	}

	@Override
	public Member findById(int id) {
		return memberRepository.findById(id).orElse(null);
	}

	@Override
	public Member update(Member pastor) {
		return memberRepository.save(pastor);
	}

	@Override
	public StaticDTO getAllStaticData() {
		StaticDTO staticdata = new StaticDTO();
		staticdata.setMemberType(memTypeRepository.findAll());
		staticdata.setCityList(cityRepository.findAll());
		staticdata.setStateList(stateRepository.findAll());
		staticdata.setCountryList(countryRepository.findAll());
		staticdata.setOccupationList(occupationRepository.findAll());
		staticdata.setReligionList(religionRepository.findAll());
		return staticdata;
		
	}

}
