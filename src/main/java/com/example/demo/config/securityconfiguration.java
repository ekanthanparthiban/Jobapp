package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity

public class securityconfiguration {
	@Autowired
	private UserDetailsService userdetails;
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userdetails);
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		return provider;
	}
  @Bean
  public SecurityFilterChain config(HttpSecurity http) throws Exception {
	http.csrf(customizer->customizer.disable());
	http.authorizeHttpRequests(request->request.requestMatchers(HttpMethod.POST,"/jobPost").hasRole("RECRUIT")
		.requestMatchers(HttpMethod.DELETE,"/jobPost/{jobId}").hasRole("RECRUIT")
		.requestMatchers(HttpMethod.PUT, "/jobPost/{jobId}").hasRole("RECRUIT")
	    .requestMatchers("/user").permitAll().anyRequest().authenticated());
	http.httpBasic(Customizer.withDefaults());
	http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
   return http.build();
  }


}
