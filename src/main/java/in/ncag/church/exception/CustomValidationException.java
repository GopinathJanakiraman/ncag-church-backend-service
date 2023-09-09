package in.ncag.church.exception;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

import in.ncag.church.util.NCAGConstants;





public class CustomValidationException extends Exception {

	private static final long serialVersionUID = 2816438424415940868L;

	private final ErrorCode errorCode;
	private HttpStatus status;
	private JSONObject response = new JSONObject();

	public CustomValidationException(ErrorCode codes,HttpStatus status) {
		super(getMessage(codes));
		this.errorCode = codes;
		this.status = status;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	private static String getMessage(ErrorCode errorCode) {
		if (errorCode.getMessage() != null) {
			return errorCode.getMessage();
		}
		else {
			return null;
		}
	}
	
	public JSONObject getResponse() {
		try {
			response.put(NCAGConstants.ERROR,errorCode.getErrorCode());
			response.put(NCAGConstants.ERROR_DESC, errorCode.getMessage());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return response;
	}
	public void setResponse(JSONObject response) {
		this.response = response;
	}
}
