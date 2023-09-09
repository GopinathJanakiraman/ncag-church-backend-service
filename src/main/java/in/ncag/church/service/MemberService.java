package in.ncag.church.service;

import java.util.List;

import in.ncag.church.dto.StaticDTO;
import in.ncag.church.model.Member;


public interface MemberService {

	Member create(Member user);
	Member delete(int id);
	List<Member> findAll();
	Member findById(int id);
	Member update(Member user);
	StaticDTO getAllStaticData();
}
