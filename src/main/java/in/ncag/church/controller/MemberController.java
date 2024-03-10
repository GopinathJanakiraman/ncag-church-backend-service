package in.ncag.church.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ncag.church.dto.AssignCarecellDTO;
import in.ncag.church.dto.MemberDTO;
import in.ncag.church.dto.MemberPageDTO;
import in.ncag.church.dto.MessageDto;
import in.ncag.church.dto.StaticDTO;
import in.ncag.church.model.Member;
import in.ncag.church.service.MemberService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/members"})
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping
	public Member create(@RequestBody MemberDTO member) {
		return memberService.save(member);
	}
	
	@GetMapping(path = {"/{id}"})
	public MemberDTO findOne(@PathVariable("id") int id) {
		return memberService.findById(id);
	}
	@PutMapping(path = {"/{id}"})
	public Member update(@PathVariable("id") int id, @RequestBody MemberDTO member) {
		member.setId(id);
		return memberService.save(member);
	}
	@DeleteMapping(path = {"/{id}"})
	public Member delete(@PathVariable("id") int id) {
		return memberService.delete(id);
	}
	@GetMapping
	public MemberPageDTO findAll(@RequestParam(defaultValue = "0", name = "page") int page, @RequestParam(defaultValue = "10") int size){
		return memberService.findAll(page, size);
	}
	
	@PostMapping(path = {"/search"})
	public MemberPageDTO findAll(@RequestBody MemberDTO memberdto){
		return memberService.searchMembers(memberdto);
	}
	@GetMapping(path = {"/getAllStaticContent"})
	public StaticDTO getAllStaticData(){
		return memberService.getAllStaticData();
	}
	@PostMapping(path = {"/assigncarecell"})
	public MessageDto assigncarecell(@RequestBody AssignCarecellDTO carecellDTO){
		return memberService.assigncarecell(carecellDTO);
	}
}
