package in.ncag.church.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public Member create(@RequestBody Member member) {
		return memberService.create(member);
	}
	
	@GetMapping(path = {"/{id}"})
	public Member findOne(@PathVariable("id") int id) {
		return memberService.findById(id);
	}
	@PutMapping(path = {"/{id}"})
	public Member update(@PathVariable("id") int id, @RequestBody Member member) {
		member.setId(id);
		return memberService.update(member);
	}
	@DeleteMapping(path = {"/{id}"})
	public Member delete(@PathVariable("id") int id) {
		return memberService.delete(id);
	}
	@GetMapping
	public List<Member> findAll(){
		return memberService.findAll();
	}
	
	@GetMapping(path = {"/getAllStaticContent"})
	public StaticDTO getAllStaticData(){
		return memberService.getAllStaticData();
	}
}
