package in.ncag.church.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class OauthUtills {

	private static final Logger LOG = LoggerFactory.getLogger(OauthUtills.class);

	@Value("${subject}")
	private String subject;

	@Value("${issuer}")
	private String issuer;

	@Value("${ttlMillis}")
	private long ttlMillis;

	private IvParameterSpec ivspec;
	private SecretKey aesKey;

	@Value("${password-IvKey}")
	private String passwordIvKey;

	@Value(NCAGConstants.AGRI_PASS_SECRT_KEY)
	private String passwordSecretKey;

	private RSAPrivateKey pk;

	public OauthUtills() {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
	}

	@PostConstruct
	public void init() {
		try {
			Resource resource = new ClassPathResource(NCAGConstants.AGRI_OAUTH_PVT_KEY);
			byte[] bdata = FileCopyUtils.copyToByteArray(resource.getInputStream());
			String privateKey = new String(bdata, StandardCharsets.UTF_8);
			byte[] keyBytes = org.apache.commons.codec.binary.Base64.decodeBase64(privateKey);
			PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(keyBytes);
			KeyFactory kf = KeyFactory.getInstance(NCAGConstants.RSA, BouncyCastleProvider.PROVIDER_NAME);
			this.pk = (RSAPrivateKey) kf.generatePrivate(privateKeySpec);
			this.ivspec = new IvParameterSpec(Arrays.copyOf(Base64.getDecoder().decode(passwordIvKey), 16));
			this.aesKey = new SecretKeySpec(Base64.getDecoder().decode(passwordSecretKey), NCAGConstants.AES);
		} catch (Exception e) {
			LOG.error("Exception occured while loading oauth utills", e);
		}
	}

	public String generateRefreshToken() 
	{
		String token = "";
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[40];
		random.nextBytes(bytes);
		Encoder encoder = Base64.getUrlEncoder().withoutPadding();
		token = encoder.encodeToString(bytes);
		return token;
	}

	public String generateIDToken() throws NoSuchAlgorithmException, NoSuchProviderException {
		// Use of Insufficiently Random Values / Use of Cryptographically Weak PRNG -
		// Checkmarx Fix
		String token = "";
		SecureRandom secureRandomGenerator = SecureRandom.getInstance(NCAGConstants.AGRI_SHA1PRNG,
				NCAGConstants.AGRI_SUN);

		// Get 128 random bytess
		byte[] randomBytes = new byte[128];
		secureRandomGenerator.nextBytes(randomBytes);
		Encoder encoder = Base64.getUrlEncoder().withoutPadding();
		token = encoder.encodeToString(randomBytes);
		return token;
	}

	public String jwtTokenGenerator(String clientId, String username, Boolean is_user_capability, String scope, int user_role_id) throws IOException,
			InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException, JSONException {

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		Map<String, Object> claims = new HashMap<>();
		claims.put("client_id", clientId);
		claims.put("user_name", username);
		claims.put("user_role", user_role_id);
		claims.put(NCAGConstants.IS_USER_CAPABILITY_KEY, is_user_capability);
		claims.put("scope", new JSONArray(scope));
		// Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setClaims(claims).setId(generateIDToken()).setIssuedAt(now)
				.setSubject(subject).setIssuer(issuer).signWith(SignatureAlgorithm.RS256, pk);

		// if it has been specified, let's add the expiration
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
			builder.setNotBefore(now);

		}
		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	public String encryptPassword(String password) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			Cipher encryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			encryptCipher.init(Cipher.ENCRYPT_MODE, aesKey, ivspec);
			// Encrypt
			CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, encryptCipher);
			cipherOutputStream.write(password.getBytes());
			cipherOutputStream.flush();
			cipherOutputStream.close();
		} catch (Exception e) {
			LOG.error("exception occured while encrypting the password", e);
		}

		return Base64.getEncoder().encodeToString(outputStream.toByteArray());
	}
}