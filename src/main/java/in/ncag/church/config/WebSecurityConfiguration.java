package in.ncag.church.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	TokenStore tokenStore;

	
	  @Override protected void configure(HttpSecurity http) throws Exception {
	  
	  //XSRF - Checkmarx Fix 
		  http.authorizeRequests().antMatchers("/pastors/portal/authenticate",
	  "/pastors/token").fullyAuthenticated();//We don't need sessions to be created.
	  }
	 
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/v2/api-docs", "/pastors/portal/authenticate", "/pastors/token","/pastors/portal/register", "/configuration/ui", "/swagger-resources", "/configuration/security",
				"/swagger-resources/**","/webjars/springfox-swagger-ui/**", "/swagger-ui.html","/agricentral/createContactUs", "/webjars/**", "/admin/app/getStaticContent");
		
	}
}