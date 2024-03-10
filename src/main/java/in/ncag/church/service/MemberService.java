package in.ncag.church.service;

import in.ncag.church.dto.AssignCarecellDTO;
import in.ncag.church.dto.MemberDTO;
import in.ncag.church.dto.MemberPageDTO;
import in.ncag.church.dto.MessageDto;
import in.ncag.church.dto.StaticDTO;
import in.ncag.church.model.Member;


public interface MemberService {

	Member delete(int id);
	MemberPageDTO findAll(int page, int size);
	MemberPageDTO searchMembers(MemberDTO memberdto);
	MemberDTO findById(int id);
	Member save(MemberDTO user);
	StaticDTO getAllStaticData();
	MessageDto assigncarecell(AssignCarecellDTO carecellDTO);
}
