package in.ncag.church.dto;

import org.springframework.http.HttpStatus;

public class MessageDto {

	private String status;
	private String message;
	private HttpStatus httpStatus;
	
	public String getStatus() {
		return status;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}