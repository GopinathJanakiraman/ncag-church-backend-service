package in.ncag.church.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ncag.church.dto.AuthRequestBean;
import in.ncag.church.dto.PastorDTO;
import in.ncag.church.exception.CustomValidationException;
import in.ncag.church.model.Carecell;
import in.ncag.church.model.Pastor;
import in.ncag.church.service.CarecellService;
import in.ncag.church.service.PastorService;
import in.ncag.church.util.NCAGConstants;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/pastors"})
public class PastorController {

	@Autowired
	private PastorService pastorService;
	
	@Autowired
	private CarecellService carecellService;
	@PostMapping
	public Pastor create(@RequestBody PastorDTO user) {
		return pastorService.create(user);
	}
	
	@GetMapping(path = {"/{id}"})
	public Pastor findOne(@PathVariable("id") int id) {
		Pastor pas = pastorService.findById(id);
		System.out.println(pas);
		return pas;
	}
	@PostMapping(value = "/portal/authenticate")
	public ResponseEntity<String> validateWebPortalRequest(@RequestBody AuthRequestBean requestBean) {
		try {
			Map<String, Object> responseMap = pastorService.portalAuthentication(requestBean);
			return new ResponseEntity<>(responseMap.get(NCAGConstants.RESPONSE).toString(),
					(HttpStatus) responseMap.get(NCAGConstants.STATUS));
		} catch (CustomValidationException e) {
			return new ResponseEntity<>(e.getResponse().toString(), e.getStatus());
		}
	}
	
	@GetMapping(path = {"/carecell"})
	public List<Carecell> findAllCarecell() {
		List<Carecell> carecell = carecellService.findAll();
		//System.out.println(carecell);
		return carecell;
	}
}
