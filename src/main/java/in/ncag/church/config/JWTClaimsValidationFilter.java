package in.ncag.church.config;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import in.ncag.church.util.NCAGConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts; 

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class JWTClaimsValidationFilter extends OncePerRequestFilter {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	private static final String JWTPREFIX = "Bearer ";
	private static final String AUTHORIZATION_HEADER = "Authorization";

	private static final String FARMER_ID_KEY = "farmer_id";

	private static final String EMPTY_STRING = "";

	private static final String NEW_LINE_PLACE_HOLDER = "\n";

	private static final String FARMER_MAPPING_ID = "farmer_mapping_id";
	private static final int BEGIN_INDEX = 0;
	private static final String OAUTH_PUBLIC_KEY = "oauth-public.key";
	
	private static final String USER_ID_KEY = "user_id";
	
	private PublicKey publicKey;

	public JWTClaimsValidationFilter() {
		try {
			
			// Checkmarx fix - Use of Hard coded Cryptographic Key

			String temp = new String(
					FileCopyUtils.copyToByteArray((new ClassPathResource(OAUTH_PUBLIC_KEY)).getInputStream()));
			temp = temp.substring(temp.indexOf(NEW_LINE_PLACE_HOLDER) + 1);
			temp = temp.substring(BEGIN_INDEX, temp.lastIndexOf(NEW_LINE_PLACE_HOLDER));
			temp = temp.substring(BEGIN_INDEX, temp.lastIndexOf(NEW_LINE_PLACE_HOLDER));
			byte[] keyBytes = org.apache.commons.codec.binary.Base64.decodeBase64(temp);
			X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(keyBytes);
			KeyFactory kf = KeyFactory.getInstance("RSA");
			this.publicKey = kf.generatePublic(publicKeySpec);
		} catch (Exception e) {
			log.error("exception occured while generating public key", e);
		}

	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		Long farmerId = null;
		
		int userId;
		
		Boolean isUserCapability = false;
		
		if (null != request.getHeader(AUTHORIZATION_HEADER)) {
			
			String token = request.getHeader(AUTHORIZATION_HEADER);

			Claims claims = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token.replace(JWTPREFIX,EMPTY_STRING))
					.getBody();
			if(claims.containsKey(FARMER_ID_KEY)) {
			farmerId = Long.valueOf(String.valueOf(claims.get(FARMER_ID_KEY)));
			request.setAttribute(FARMER_ID_KEY, farmerId);
			request.setAttribute(FARMER_MAPPING_ID,String.valueOf(claims.get(FARMER_MAPPING_ID)) );
			}
			
			if (claims.containsKey("user_name")) {
				userId = Integer.valueOf(String.valueOf(claims.get("user_name")));

				request.setAttribute(USER_ID_KEY, userId);
			}
			if (claims.containsKey(NCAGConstants.IS_USER_CAPABILITY_KEY)) {
				isUserCapability = Boolean.valueOf(String.valueOf(claims.get(NCAGConstants.IS_USER_CAPABILITY_KEY)));
				request.setAttribute(NCAGConstants.IS_USER_CAPABILITY_KEY, isUserCapability);
			}
		}
		filterChain.doFilter(request, response);
	}
}