package in.ncag.church.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import in.ncag.church.dto.CarecellDTO;
import in.ncag.church.dto.CarecellPageDTO;
import in.ncag.church.dto.MemberDTO;
import in.ncag.church.model.Carecell;
import in.ncag.church.repository.CarecellRepository;
import in.ncag.church.repository.CarecellSpecification;
import in.ncag.church.service.CarecellService;

@Service
public class CarecellImpl implements CarecellService{

	@Autowired
	CarecellRepository carecellRepository;
	@Override
	public CarecellPageDTO findAll(int pageNo, int pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<Carecell> list = carecellRepository.findAll(pageRequest);
		CarecellPageDTO output = new CarecellPageDTO();
		
		output.setContent(carecellMapper(list));
		output.setTotalElements(list.getTotalElements());
		output.setTotalPages(list.getTotalPages());
		return output;
	}
	@Override
	public CarecellPageDTO searchCarecell(MemberDTO memberdto) {

		Page<Carecell> pages = null;
		CarecellSpecification spec = new CarecellSpecification();
		PageRequest pageRequest = PageRequest.of(memberdto.getPage(), memberdto.getSize());
		pages = (carecellRepository.findAll(spec.getCarecellMembers(memberdto), pageRequest));
		CarecellPageDTO output = new CarecellPageDTO();
		
		output.setContent(carecellMapper(pages));
		output.setTotalElements(pages.getTotalElements());
		output.setTotalPages(pages.getTotalPages());
		return output;
	}
	private List<CarecellDTO> carecellMapper(Page<Carecell> list) {
		List<CarecellDTO> careDTOList = new ArrayList<CarecellDTO>();
		list.getContent().forEach(carecell -> {
			
			
			careDTOList.add(singleMapper(carecell));
		});
		return careDTOList;
	}
	private CarecellDTO singleMapper(Carecell carecell) {
		CarecellDTO item = new CarecellDTO();
		item.setAreaId(carecell.getAreaDetails().getId());
		item.setAreaName(carecell.getAreaDetails().getName());
		item.setCarecellId(carecell.getId());
		item.setCarecellMembers(carecell.getCarecellMemberList());
		item.setRegionId(carecell.getAreaDetails().getRegionDetails().getId());
		item.setRegionName(carecell.getAreaDetails().getRegionDetails().getName());
		
		item.setPastorId(carecell.getAreaDetails().getRegionDetails().getPastorDetails().getId());
		item.setPastorName(carecell.getAreaDetails().getRegionDetails().getPastorDetails().getFirstName());
		return item;
	}
	

}
