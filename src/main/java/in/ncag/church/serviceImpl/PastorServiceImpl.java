package in.ncag.church.serviceImpl;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;

import in.ncag.church.dto.AuthRequestBean;
import in.ncag.church.dto.CapabilityOfUser;
import in.ncag.church.dto.PastorDTO;
import in.ncag.church.exception.CustomValidationException;
import in.ncag.church.exception.ErrorCode;
import in.ncag.church.model.Pastor;
import in.ncag.church.model.PastorCapability;
import in.ncag.church.model.RefreshAccessTokenModel;
import in.ncag.church.model.RefreshTokenModel;
import in.ncag.church.repository.OauthRefreshTokenTransactionRepository;
import in.ncag.church.repository.OauthTokenTransactionRepository;
import in.ncag.church.repository.PastorCapabilityRepository;
import in.ncag.church.repository.PastorRepository;
import in.ncag.church.repository.PastorRoleMappingRepository;
import in.ncag.church.repository.PastorRoleRepository;
import in.ncag.church.service.PastorService;
import in.ncag.church.util.NCAGConstants;
import in.ncag.church.util.OauthUtills;


@Service
public class PastorServiceImpl implements PastorService{

	public PastorServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	CapabilityOfUser capabilityOfUser;
	
	@Autowired
	PastorRepository pastorRepository;
	
	@Value("${failurePasswordAttemptCnt}")
	private int failureCredentialAttemptCnt;
	
	@Value("${refreshTokenExpiryDayCount}")
	int expirationDayCount;
	
	@Value("${ttlMillis}")
	private long ttlMillis;
	
	@Value("${portalClientID}")
	int portalClientID;
	
	@Autowired
	PastorCapabilityRepository pastorCapabilityRepository;
	
	@Autowired
	private PastorRoleMappingRepository pastorRoleMappingRepository;
	
	@Autowired
	private PastorRoleRepository pastorRolerepository;
	
	@Autowired
	private OauthUtills authUtills;
	
	@Autowired
	private OauthTokenTransactionRepository oauthTokenRepository;

	@Autowired
	private OauthRefreshTokenTransactionRepository refreshTokenRepository;

	@Override
	public Pastor create(PastorDTO pastor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pastor findById(int id) {
		return pastorRepository.findById(id).orElse(null);
	}

	@Override
	public Map<String, Object> portalAuthentication(AuthRequestBean requestBean)
			throws CustomValidationException {
		Map<String, Object> responseMap = new HashMap<>();

		JSONObject response = new JSONObject();
		JSONObject pastorDetailJson = new JSONObject();
		HttpStatus status = null;
		// isUserCapability = false;
		capabilityOfUser.setIsUserCapability(false);
		try {
			String accessToken = NCAGConstants.EMPTY_STRING;
			String refreshToken = NCAGConstants.EMPTY_STRING;
			if (validatePortalRequestParams(requestBean)) {
				Optional<Pastor> pastorDetail = pastorRepository.findByEmail(requestBean.getUsername());

				if (pastorDetail.isPresent()) {

					if (null != pastorDetail && pastorDetail.get().getId() > 0
							&& pastorDetail.get().getFailureAttempts() < failureCredentialAttemptCnt
							&& pastorDetail.get().getCredential().equals(requestBean.getPassword())) {

						if (pastorDetail.get().getFailureAttempts() > 0) {
							pastorDetail.get().setFailureAttempts(0);
							pastorRepository.saveAndFlush(pastorDetail.get());
						}

						pastorDetailJson.put(NCAGConstants.CAPABILITIES,
								getUserCapabilities(pastorDetail.get().getPastorRole().getId()));

					
						accessToken = authUtills.jwtTokenGenerator(String.valueOf(portalClientID),
								String.valueOf(pastorDetail.get().getId()), capabilityOfUser.getIsUserCapability(), NCAGConstants.SCOPE,
								pastorDetail.get().getPastorRole().getId());
						
						if (!StringUtils.isEmpty(accessToken)) {
							refreshToken = updateAuthTokenDetails(requestBean, pastorDetail.get());
							response.put(NCAGConstants.REFRESH_TOKEN, refreshToken);
							response.put(NCAGConstants.ACCESS_TOKEN, accessToken);
							response.put(NCAGConstants.TOKEN_TYPE, "Bearer");
							response.put(NCAGConstants.EXPIRES_IN, ttlMillis);

							pastorDetailJson.put("firstName", pastorDetail.get().getFirstName());
							pastorDetailJson.put("lastName", pastorDetail.get().getLastName());
							pastorDetailJson.put("email", pastorDetail.get().getEmail());
							pastorDetailJson.put("id", pastorDetail.get().getId());
							pastorDetailJson.put("roleId", pastorDetail.get().getPastorRole().getId());

							response.put("pastor", pastorDetailJson);

							status = HttpStatus.OK;

						} else {

							throw new CustomValidationException(ErrorCode.FSP_TS_3001, HttpStatus.FORBIDDEN);
						}
					} else {
						if (null != pastorDetail && pastorDetail.get().getFailureAttempts() < failureCredentialAttemptCnt) {
							pastorDetail.get().setFailureAttempts(pastorDetail.get().getFailureAttempts() + 1);
							pastorRepository.saveAndFlush(pastorDetail.get());
							throw new CustomValidationException(ErrorCode.FSP_TS_3002, HttpStatus.FORBIDDEN);
						} else {
							throw new CustomValidationException(ErrorCode.FSP_TS_3009, HttpStatus.FORBIDDEN);
						}

					}
				} else {
					throw new CustomValidationException(
							(null == pastorDetail) ? ErrorCode.FSP_TS_3002 : ErrorCode.FSP_TS_3002, HttpStatus.FORBIDDEN);
				}
			}
		} catch (IOException | InvalidKeySpecException | NoSuchProviderException | NoSuchAlgorithmException
				| JSONException e) {

			throw new CustomValidationException(ErrorCode.FSP_TS_3001, HttpStatus.FORBIDDEN);
		} finally {
			if (!response.has(NCAGConstants.ACCESS_TOKEN)) {
				status = HttpStatus.UNAUTHORIZED;

			} else {

			}
		}
		responseMap.put(NCAGConstants.RESPONSE, response);
		responseMap.put(NCAGConstants.STATUS, status);
		return responseMap;
	}
	private boolean validatePortalRequestParams(AuthRequestBean requestBean) {
		return !StringUtils.isEmpty(requestBean.getUsername()) && !StringUtils.isEmpty(requestBean.getPassword());
	}
	
	private JSONObject getUserCapabilities(Integer roleId) {
		HashMap<String, Integer> capaHash = new HashMap<String, Integer>();
		JSONObject pastorCapability = new JSONObject();
		List<String> pastorCapabilities = pastorCapabilityRepository.getCapabilityByRole(roleId);

		for(String pastorCap:pastorCapabilities ) {
			capaHash.put(pastorCap, 1);
			if (pastorCap.equals(NCAGConstants.USER_CAPABILITY)) {
				//isUserCapability = true;
				capabilityOfUser.setIsUserCapability(true);
			}
		}
		try {
			pastorCapability = new JSONObject(new Gson().toJson(capaHash));
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return pastorCapability;
	}
	
	private String updateAuthTokenDetails(AuthRequestBean requestBean, Pastor pastorDetail) {
		String refreshToken;
		String accessId = authUtills.generateRefreshToken();
		refreshToken = authUtills.generateRefreshToken();
		Calendar expiryCal = Calendar.getInstance();
		expiryCal.setTime(new Date());
		expiryCal.add(Calendar.DATE, expirationDayCount);
		RefreshAccessTokenModel refreshTokenMod;
		if (null == pastorDetail) {
			refreshTokenMod = new RefreshAccessTokenModel(String.valueOf(requestBean.getUsername()), accessId,
					requestBean.getUsername(), expiryCal.getTime(), "[*]");
		} else {
			refreshTokenMod = new RefreshAccessTokenModel(String.valueOf(pastorDetail.getId()), accessId,
					pastorDetail.getEmail(), expiryCal.getTime(), "[*]");
		}
		oauthTokenRepository.save(refreshTokenMod);
		RefreshTokenModel refreshTokenModel = new RefreshTokenModel(refreshToken, accessId, true, expiryCal.getTime());
		refreshTokenRepository.save(refreshTokenModel);
		return refreshToken;
	}

}
