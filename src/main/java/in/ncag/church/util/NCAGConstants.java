package in.ncag.church.util;

public final class NCAGConstants {
	
	private NCAGConstants() {
		throw new IllegalStateException("Utility class");
	}

	public static final String ERROR="Error";
	public static final String ERROR_DESC="Error_Description";
	public static final String RESPONSE = "response";
	public static final String STATUS = "status";
	public static final String ADMIN = "admin";
	public static final boolean ACTIVE = true;
	public static final String SUCCESS = "success";
	public static final String DELETE_KEY = "id";
	public static final String EMPTY_STRING = "";

	
	
	public static final String GRANT_REFRESH_TOKEN = "refreshToken";
	public static final String REFRESH_TOKEN = "refresh_token";
	public static final String ACCESS_TOKEN = "access_token";
	public static final String TOKEN_TYPE = "token_type";
	public static final String EXPIRES_IN = "expires_in";
	public static final String AGRI_SHA1PRNG = "SHA1PRNG";
	public static final String SCOPE = "[*]";
	public static final String RSA = "RSA";
	public static final String AES = "AES";
	public static final String LOCALE = "locale1";
	public static final String CAPABILITIES = "capabilities";
	public static final String FORWARD_SLASH = "/";
	public static final String AES_KEY = "OL@MZEU$0(8&";
	public static final String PASSCODE="password";
	public static final String COLUMN_TRANSFORMER_WRITE_AES = "AES_ENCRYPT(?, '"+AES_KEY+"')";
    public static final String COLUMN_TRANSFORMER_READ_AES_PASSCODE = "AES_DECRYPT("+PASSCODE+", '"+AES_KEY+"')";	
    public static final String USER_CAPABILITY = "users";
    public static final String IS_USER_CAPABILITY_KEY = "is_user_capability";
    public static final String USER_ID = "user_id";
    
}