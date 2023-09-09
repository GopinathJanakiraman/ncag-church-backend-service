package in.ncag.church.config;

import javax.validation.ConstraintViolationException;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import in.ncag.church.exception.ErrorCode;
import in.ncag.church.util.NCAGConstants;



@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {
	private static final Logger LOGVAR = LoggerFactory.getLogger(CustomizedResponseEntityExceptionHandler.class);
	
	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) { 
		return setBadRequestResponse();
			 }
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		 if(NumberFormatException.class.isInstance(ex)) {
			 return setBadRequestResponse();
		 }else {
			 super.handleExceptionInternal(ex, body, headers, status, request);
		 }
		return new ResponseEntity<>(ex.getMessage(), status);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		 if(NumberFormatException.class.isInstance(ex)||ConstraintViolationException.class.isInstance(ex)) {
			 return setBadRequestResponse();
		 }
		 LOGVAR.error("Exception occured",ex);
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<Object> setBadRequestResponse() {
		JSONObject response =new JSONObject() ;
		 response.put(NCAGConstants.ERROR, ErrorCode.FSP_TS_3003.getErrorCode());
			response.put(NCAGConstants.ERROR_DESC, ErrorCode.FSP_TS_3003.getMessage());
		 return new ResponseEntity<>(response.toString(), HttpStatus.BAD_REQUEST);
	}

}
