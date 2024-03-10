package in.ncag.church.service;



import in.ncag.church.dto.CarecellPageDTO;
import in.ncag.church.dto.MemberDTO;


public interface CarecellService {

	CarecellPageDTO findAll(int page, int size);

	CarecellPageDTO searchCarecell(MemberDTO memberdto);

}
