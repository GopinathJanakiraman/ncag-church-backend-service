package in.ncag.church.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.FileCopyUtils;

@Configuration
@ImportResource({"classpath*:AOPLogsConfig.xml"})
public class JwtConfiguration {
	@Autowired
	JwtAccessTokenConverter jwtAccessTokenConverter;

	@Bean
	@Qualifier("tokenStore")
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter);
	}

	@Bean
	protected JwtAccessTokenConverter jwtTokenEnhancer() throws IOException {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		Resource resource = new ClassPathResource("/oauth-public.key");
		String publicKey = null;
		try {
			publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
		} catch (IOException e) {
			throw e;
		}
		converter.setVerifierKey(publicKey);
		return converter;
	}
}
