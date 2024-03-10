package in.ncag.church.service;

import java.util.Map;

import in.ncag.church.dto.AuthRequestBean;
import in.ncag.church.dto.MessageDto;
import in.ncag.church.dto.PastorDTO;
import in.ncag.church.dto.PastorPageDTO;
import in.ncag.church.exception.CustomValidationException;
import in.ncag.church.model.Pastor;




public interface PastorService {

	Pastor save(PastorDTO user);

	PastorDTO findById(int id);

	Map<String, Object> portalAuthentication(AuthRequestBean requestBean) throws CustomValidationException;
	
	PastorPageDTO findAll(int page, int size);

	MessageDto updatePassword(PastorDTO user);

}
