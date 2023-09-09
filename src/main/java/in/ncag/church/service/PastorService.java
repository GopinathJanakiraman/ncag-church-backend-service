package in.ncag.church.service;

import java.util.Map;



import in.ncag.church.dto.AuthRequestBean;
import in.ncag.church.dto.PastorDTO;
import in.ncag.church.exception.CustomValidationException;
import in.ncag.church.model.Pastor;




public interface PastorService {

	Pastor create(PastorDTO user);

	Pastor findById(int id);

	Map<String, Object> portalAuthentication(AuthRequestBean requestBean) throws CustomValidationException;
	

}
