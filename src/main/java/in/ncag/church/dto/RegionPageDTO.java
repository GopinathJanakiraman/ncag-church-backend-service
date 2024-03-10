package in.ncag.church.dto;

import java.util.List;

public class RegionPageDTO {
private List<RegionDTO> content;
	
	private Long totalElements;
	
	private int totalPages;

	public List<RegionDTO> getContent() {
		return content;
	}

	public void setContent(List<RegionDTO> content) {
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
