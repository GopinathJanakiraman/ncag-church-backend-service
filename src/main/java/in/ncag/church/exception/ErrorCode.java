package in.ncag.church.exception;

public enum ErrorCode implements ErrorHandle {
	FSP_TS_3001(3001, "Oops!!! Something went wrong, Please contact administrator"),
	
	
	FSP_TS_3002(3002, "No Data Found"),
	FSP_TS_3003(3003, "mandatory parameter is missing"),
	FSP_TS_3004(3004, "Internal Error"),
	FSP_TS_3005(3005, "Delete failed"),
	FSP_TS_3006(3006, "Language not supported"),
	FSP_TS_3007(2003, "Invalid AppID"),
	FSP_TS_3009(3009, "password retry limit exceed"),
	FSP_FARMER_5023(5023,"FarmerId validation failure"),
	FSP_FDS_5005(3011, "UserID validation failure");
	
	


	private final int errorCodeNumber;
	private final String message;

	ErrorCode(int errorCodeNumber, String message) {
		this.errorCodeNumber = errorCodeNumber;
		this.message = message;
	}

	@Override
	public int getErrorCode() {
		return this.errorCodeNumber;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
