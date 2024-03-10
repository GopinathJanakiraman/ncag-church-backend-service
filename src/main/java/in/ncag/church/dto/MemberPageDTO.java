package in.ncag.church.dto;

import java.util.List;

public class MemberPageDTO {
private List<MemberDTO> content;
	
	private Long totalElements;
	
	private int totalPages;

	public List<MemberDTO> getContent() {
		return content;
	}

	public void setContent(List<MemberDTO> content) {
		this.content = content;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
}
