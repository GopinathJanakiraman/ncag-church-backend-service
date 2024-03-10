package in.ncag.church.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import in.ncag.church.dto.MessageDto;
import in.ncag.church.dto.RegionDTO;
import in.ncag.church.dto.RegionPageDTO;
import in.ncag.church.model.Pastor;
import in.ncag.church.model.Region;
import in.ncag.church.repository.PastorRepository;
import in.ncag.church.repository.RegionRepository;
import in.ncag.church.service.RegionService;
import in.ncag.church.util.NCAGConstants;

@Service
public class RegionImpl implements RegionService{

	@Autowired
	RegionRepository regionRepository;
	@Autowired
	PastorRepository pastorRepository;
	
	public RegionPageDTO findAll(int pageNo, int pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<Region> reglist = regionRepository.findAll(pageRequest);
		RegionPageDTO output = new RegionPageDTO();
		List<RegionDTO> regDTO = new ArrayList<RegionDTO>();
		reglist.getContent().forEach(r -> {
			RegionDTO item = new RegionDTO();
			item.setPastorId(r.getPastorDetails().getId());
			item.setPastorName(r.getPastorDetails().getFirstName());
			item.setRegionId(r.getId());
			item.setRegionName(r.getName());
			item.setAreaList(r.getAreaList());
			regDTO.add(item);
		});
		output.setContent(regDTO);
		output.setTotalElements(reglist.getTotalElements());
		output.setTotalPages(reglist.getTotalPages());
		return output;
	}
	@Override
	public RegionDTO findById(int id) {
		// TODO Auto-generated method stub
		Region r = regionRepository.findById(id).orElse(null);
		RegionDTO item = new RegionDTO();
		item.setPastorId(r.getPastorDetails().getId());
		item.setPastorName(r.getPastorDetails().getFirstName());
		item.setRegionId(r.getId());
		item.setRegionName(r.getName());
		return item;
	}
	
	private Pastor findByPastorId(int id) {
		// TODO Auto-generated method stub
		return pastorRepository.findById(id).orElse(null);
	}
	@Override
	public MessageDto save(RegionDTO region) {
		MessageDto msg = new MessageDto();
		Region reg = new Region();
		if(region.getRegionId() > 0)
		reg.setId(region.getRegionId());
		reg.setName(region.getRegionName());
		Pastor p = findByPastorId(region.getPastorId());
		Pastor pas = new Pastor();
		//p.setId(region.getPastorId());
		pas.setCreateAt(p.getCreateAt());
		pas.setId(region.getPastorId());
		reg.setPastorDetails(p);
		
		msg.setHttpStatus(HttpStatus.OK);
		msg.setMessage("Region saved successfully");
		msg.setStatus(NCAGConstants.SUCCESS);
		regionRepository.save(reg);
		return msg;
	}

}
