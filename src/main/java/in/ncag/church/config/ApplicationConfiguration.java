package in.ncag.church.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public RestTemplate generateRestTemplate() {

		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

		return new RestTemplate(requestFactory);
	}

}
