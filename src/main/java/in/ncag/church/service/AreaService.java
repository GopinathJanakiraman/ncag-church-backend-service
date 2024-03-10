package in.ncag.church.service;



import in.ncag.church.dto.AreaDTO;
import in.ncag.church.dto.AreaPageDTO;
import in.ncag.church.dto.MessageDto;


public interface AreaService {

	AreaPageDTO findAll(int page, int size);
	
	MessageDto create(AreaDTO area);

	AreaDTO findById(int id);

}
