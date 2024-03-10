package in.ncag.church.service;


import in.ncag.church.dto.MessageDto;
import in.ncag.church.dto.RegionDTO;
import in.ncag.church.dto.RegionPageDTO;


public interface RegionService {

	RegionPageDTO findAll(int page, int size);

	RegionDTO findById(int id);

	MessageDto save(RegionDTO region);

}
