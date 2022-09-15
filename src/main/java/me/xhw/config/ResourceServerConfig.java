package me.xhw.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.servlet.http.HttpServletResponse;

//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/doc.html","/swagger-resources/**",
						"/webjars/**","/v2/**","/user/getToken","/oauth/token","/user/login","/test/**"
				).permitAll()
//			.antMatchers("/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.csrf().disable()
			.exceptionHandling()
			.authenticationEntryPoint(
					(request, response, authException) ->
						response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
			.and().cors()
		;
	}

	@Autowired
	private TokenStore tokenStore;

	@Value("${location.resource.id}")
	private String resourceId;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
		resources.resourceId(resourceId);
	}


}
