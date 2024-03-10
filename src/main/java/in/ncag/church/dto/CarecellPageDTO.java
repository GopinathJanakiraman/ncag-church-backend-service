package in.ncag.church.dto;

import java.util.List;

public class CarecellPageDTO {
private List<CarecellDTO> content;
	
	private Long totalElements;
	
	private int totalPages;

	public List<CarecellDTO> getContent() {
		return content;
	}

	public void setContent(List<CarecellDTO> content) {
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
