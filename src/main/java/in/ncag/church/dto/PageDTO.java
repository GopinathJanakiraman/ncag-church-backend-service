package in.ncag.church.dto;

import java.util.List;


public class PageDTO<T> {
	public PageDTO(List<T> data, int pageNumber,int totalPages,long totalElements){
		this.data = data;
		this.pageNumber = pageNumber;
		this.totalPages = totalPages;
		this.totalElements = totalElements;
	}

	private List<T> data;
	
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}



	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	private int pageNumber;
	
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	private int totalPages;
	
	private long totalElements;
}
