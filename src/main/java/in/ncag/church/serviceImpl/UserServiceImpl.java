package in.ncag.church.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import in.ncag.church.dto.AssignCarecellDTO;
import in.ncag.church.dto.MemberDTO;
import in.ncag.church.dto.MemberPageDTO;
import in.ncag.church.dto.MessageDto;
import in.ncag.church.dto.StaticDTO;
import in.ncag.church.model.Area;
import in.ncag.church.model.Carecell;
import in.ncag.church.model.City;
import in.ncag.church.model.Country;
import in.ncag.church.model.Member;
import in.ncag.church.model.MemberType;
import in.ncag.church.model.Occupation;
import in.ncag.church.model.Religion;
import in.ncag.church.model.State;
import in.ncag.church.repository.AreaRepository;
import in.ncag.church.repository.CityRepository;
import in.ncag.church.repository.CountryRepository;
import in.ncag.church.repository.MemberRepository;
import in.ncag.church.repository.MemberSpecification;
import in.ncag.church.repository.MemberTypeRepository;
import in.ncag.church.repository.OccupationRepository;
import in.ncag.church.repository.PastorRepository;
import in.ncag.church.repository.PastorRoleRepository;
import in.ncag.church.repository.RegionRepository;
import in.ncag.church.repository.ReligionRepository;
import in.ncag.church.repository.StateRepository;
import in.ncag.church.service.MemberService;
import in.ncag.church.util.NCAGConstants;

@Service
public class UserServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private MemberTypeRepository memTypeRepository;

	@Autowired
	private AreaRepository areaRepository;

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
	private RegionRepository regionRepository;
	
	@Autowired
	PastorRepository pastorRepository;
	
	@Autowired
	PastorRoleRepository pastorRoleRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	

	@Override
	public Member delete(int id) {
		Optional<Member> optional = memberRepository.findById(id);

		if (optional.isPresent()) {
			Member pastor = optional.get();
			if (pastor != null) {
				memberRepository.delete(pastor);
			}
			return pastor;
		}
		return null;
	}

	@Override
	public MemberPageDTO findAll(int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        MemberPageDTO memoutput = new MemberPageDTO();
       
		Page<Member> member = memberRepository.findAll(pageRequest);
		
		memoutput.setContent(memberMapper(member));
		memoutput.setTotalElements(member.getTotalElements());
		memoutput.setTotalPages(member.getTotalPages());
		return memoutput;
	}

	@Override
	public MemberDTO findById(int id) {
		Member mem = new Member();
		//modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		mem = memberRepository.findById(id).orElse(null);
		
		MemberDTO m = modelMapper.map(mem, MemberDTO.class);
		m = singleMemMapper(mem);
		return m;
	}
 private List<MemberDTO> memberMapper(Page<Member> member) {
	 List<MemberDTO> memList = new ArrayList<MemberDTO>();
//	 modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		member.getContent().forEach(mem->{
			
			
			memList.add(singleMemMapper(mem));
			
		});
		
		return memList;
 }
 private MemberDTO singleMemMapper(Member mem) {
	 MemberDTO memdto = new MemberDTO();
	 modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		memdto = modelMapper.map(mem, MemberDTO.class);
		if(mem.getCarecellDetails() != null) {
			memdto.setCarecellId(mem.getCarecellDetails().getId());
			memdto.setCarecellAddress(mem.getCarecellDetails().getCarecellMemberList().get(0).getAddress());
		}
		memdto.setReligionName(mem.getReligionDetails().getReligionName());
		memdto.setReligionId(mem.getReligionDetails().getId());
		memdto.setPastorId(mem.getAreaDetails().getRegionDetails().getPastorDetails().getId());
		memdto.setOccupationId(mem.getOccupationDetails().getId());
		memdto.setCityId(mem.getCityDetails().getId());
		memdto.setStateId(mem.getStateDetails().getId());
		memdto.setCountryId(mem.getCountryDetails().getId());
		memdto.setAreaId(mem.getAreaDetails().getId());
		memdto.setAreaPastorName(mem.getAreaDetails().getRegionDetails().getPastorDetails().getFirstName());
		memdto.setAreaName(mem.getAreaDetails().getName());
		memdto.setRegionName(mem.getAreaDetails().getRegionDetails().getName());
		memdto.setRegionId(mem.getReligionDetails().getId());
		memdto.setMemTypeId(mem.getMemberTypeDetails().getId());
		
		return memdto;
 }
	@Override
	public Member save(MemberDTO member) {
		Member m = modelMapper.map(member, Member.class);
		City city = new City();
		State s = new State();
		Country c = new Country();
		MemberType memT = new MemberType();
		Occupation o = new Occupation();
		Religion r = new Religion();
		Area a = new Area();
		
		memT.setId(member.getMemTypeId());
		city.setId(member.getCityId());
		s.setId(member.getStateId());
		c.setId(member.getCountryId());
		a.setId(member.getAreaId());
		r.setId(member.getReligionId());
		o.setId(member.getOccupationId());
		if(member.getCarecellId() > 0) {
			Carecell care = new Carecell();
			care.setId(member.getCarecellId());
			m.setCarecellDetails(care);
		}
		m.setCityDetails(city);
		m.setStateDetails(s);
		m.setCountryDetails(c);
		m.setMemberTypeDetails(memT);
		m.setOccupationDetails(o);
		m.setReligionDetails(r);
		m.setAreaDetails(a);
		
		return memberRepository.save(m);
	}

	@Override
	public StaticDTO getAllStaticData() {
		StaticDTO staticdata = new StaticDTO();
		staticdata.setMemberType(memTypeRepository.findAll());
		staticdata.setAreaList(areaRepository.findAll());
		staticdata.setCityList(cityRepository.findAll());
		staticdata.setStateList(stateRepository.findAll());
		staticdata.setCountryList(countryRepository.findAll());
		staticdata.setOccupationList(occupationRepository.findAll());
		staticdata.setReligionList(religionRepository.findAll());
		staticdata.setRoleList(pastorRoleRepository.findAll());
		staticdata.setPastorList(pastorRepository.findAll());
		//staticdata.setRegionList(regionRepository.findAll());
		return staticdata;

	}

	

	@Override
	public MemberPageDTO searchMembers(MemberDTO memberdto) {

		Page<Member> pages = null;
		MemberPageDTO memoutput = new MemberPageDTO();
		MemberSpecification spec = new MemberSpecification();
		PageRequest pageRequest = PageRequest.of(memberdto.getPage(), memberdto.getSize());
		pages = (memberRepository.findAll(spec.getMembers(memberdto), pageRequest));
		memoutput.setContent(memberMapper(pages));
		memoutput.setTotalElements(pages.getTotalElements());
		memoutput.setTotalPages(pages.getTotalPages());
		return memoutput;
	}

	@Override
	public MessageDto assigncarecell(AssignCarecellDTO carecellDTO) {
		List<Member> memList = new ArrayList<Member>();
		memList = memberRepository.findAllById(carecellDTO.getIds());
		memList.forEach(m -> {
			Carecell care = new Carecell();
			Area area = new Area();
			care.setId(carecellDTO.getCareId());
			area.setId(carecellDTO.getAreaId());
			care.setAreaDetails(area);
			m.setCarecellDetails(care);
		});
		memberRepository.saveAll(memList);
		MessageDto msg = new MessageDto();
		msg.setHttpStatus(HttpStatus.OK);
		msg.setMessage("Carecell assigned successfully");
		msg.setStatus(NCAGConstants.SUCCESS);
		return msg;
	}

}
