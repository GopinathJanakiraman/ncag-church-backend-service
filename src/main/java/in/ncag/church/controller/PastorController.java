package in.ncag.church.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ncag.church.dto.AreaDTO;
import in.ncag.church.dto.AreaPageDTO;
import in.ncag.church.dto.AuthRequestBean;
import in.ncag.church.dto.CarecellPageDTO;
import in.ncag.church.dto.MemberDTO;
import in.ncag.church.dto.MessageDto;
import in.ncag.church.dto.PastorDTO;
import in.ncag.church.dto.PastorPageDTO;
import in.ncag.church.dto.RegionDTO;
import in.ncag.church.dto.RegionPageDTO;
import in.ncag.church.exception.CustomValidationException;
import in.ncag.church.model.Pastor;
import in.ncag.church.service.AreaService;
import in.ncag.church.service.CarecellService;
import in.ncag.church.service.PastorService;
import in.ncag.church.service.RegionService;
import in.ncag.church.util.NCAGConstants;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/pastors"})
public class PastorController {

	@Autowired
	private PastorService pastorService;
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private RegionService regionService;
	
	@Autowired
	private CarecellService carecellService;
	@PostMapping
	public Pastor create(@RequestBody PastorDTO user) {
		return pastorService.save(user);
	}
	@PutMapping
	public Pastor update(@RequestBody PastorDTO user) {
		return pastorService.save(user);
	}
	@PostMapping(path = {"/updatePassword"})
	public MessageDto updatePassword(@RequestBody PastorDTO user) {
		return pastorService.updatePassword(user);
	}
	@GetMapping(path = {"/{id}"})
	public PastorDTO findOne(@PathVariable("id") int id) {
		PastorDTO pas = pastorService.findById(id);
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
	@GetMapping(path = {"/all"})
	public PastorPageDTO findAllPastor(@RequestParam(defaultValue = "0", name = "page") int page, @RequestParam(defaultValue = "10") int size) {
		return pastorService.findAll(page, size);
	}
	@GetMapping(path = {"/carecell"})
	public CarecellPageDTO findAllCarecell(@RequestParam(defaultValue = "0", name = "page") int page, @RequestParam(defaultValue = "10") int size) {
		return carecellService.findAll(page, size);
	}
	@GetMapping(path = {"/region"})
	public RegionPageDTO findAllRegion(@RequestParam(defaultValue = "0", name = "page") int page, @RequestParam(defaultValue = "10") int size) {
		return regionService.findAll(page, size);
	}
	@GetMapping(path = {"/region/{id}"})
	public RegionDTO getRegionById(@PathVariable("id") int id) {
		return regionService.findById(id);
	}
	
	@PostMapping(path = {"/region"})
	public MessageDto saveRegion(@RequestBody RegionDTO region) {
		return regionService.save(region);
	}
	@PutMapping(path = {"/region"})
	public MessageDto updateRegion(@RequestBody RegionDTO region) {
		return regionService.save(region);
	}
	@GetMapping(path = {"/area"})
	public AreaPageDTO findAllArea(@RequestParam(defaultValue = "0", name = "page") int page, @RequestParam(defaultValue = "10") int size) {
		return areaService.findAll(page, size);
		
	}
	@GetMapping(path = {"/area/{id}"})
	public AreaDTO getAreaById(@PathVariable("id") int id) {
		return areaService.findById(id);
	}
	@PutMapping(path = {"/area"})
	public MessageDto update(@RequestBody AreaDTO area) {
		return areaService.create(area);
	}
	
	@PostMapping(path = {"/area"})
	public MessageDto save(@RequestBody AreaDTO area) {
		return areaService.create(area);
	}
	
	@PostMapping(path = {"/carecell/search"})
	public CarecellPageDTO findAll(@RequestBody MemberDTO memberdto){
		return carecellService.searchCarecell(memberdto);
	}
	
}
