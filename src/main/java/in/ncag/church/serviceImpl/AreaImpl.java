package in.ncag.church.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import in.ncag.church.dto.AreaDTO;
import in.ncag.church.dto.AreaPageDTO;
import in.ncag.church.dto.MessageDto;
import in.ncag.church.model.Area;
import in.ncag.church.model.Region;
import in.ncag.church.repository.AreaRepository;
import in.ncag.church.service.AreaService;
import in.ncag.church.util.NCAGConstants;

@Service
public class AreaImpl implements AreaService{

	@Autowired
	AreaRepository areaRepository;
	@Override
	public AreaPageDTO findAll(int pageNo, int pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<Area> arealist = areaRepository.findAll(pageRequest);
		AreaPageDTO areaoutput = new AreaPageDTO();
		List<AreaDTO> areaDTO = new ArrayList<AreaDTO>();
		arealist.getContent().forEach(area -> {
			AreaDTO item = new AreaDTO();
			item.setId(area.getId());
			item.setName(area.getName());
			item.setRegionName(area.getRegionDetails().getName());
			item.setPincode(area.getPincode());
			areaDTO.add(item);
		});
		areaoutput.setContent(areaDTO);
		areaoutput.setTotalElements(arealist.getTotalElements());
		areaoutput.setTotalPages(arealist.getTotalPages());
		return areaoutput;
	}
	@Override
	public MessageDto create(AreaDTO area) {
		Area aentity = new Area();
		if(area.getId() > 0)
		aentity.setId(area.getId());
		aentity.setName(area.getName());
		Region rentity = new Region();
		rentity.setId(area.getRegionId());
		aentity.setRegionDetails(rentity);
		areaRepository.save(aentity);
		MessageDto msg = new MessageDto();
		msg.setHttpStatus(HttpStatus.OK);
		msg.setMessage("Area saved successfully");
		msg.setStatus(NCAGConstants.SUCCESS);
		return msg;
	}
	@Override
	public AreaDTO findById(int id) {
		Area aentity = areaRepository.findById(id).orElse(null);
		AreaDTO areaDto = new AreaDTO();
		areaDto.setId(aentity.getId());
		areaDto.setName(aentity.getName());
		areaDto.setRegionId(aentity.getRegionDetails().getId());
		areaDto.setRegionName(aentity.getRegionDetails().getName());
		return areaDto;
	}

}
