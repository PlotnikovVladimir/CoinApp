package com.test.configuration;

import com.test.services.impl.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.http.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;

/**
 * Created by user on 16.09.2015.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	UserServiceImpl userService;

	@Autowired
	public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()
				.withUser("admin").password("admin").roles("ADMIN")
				.and()
				.withUser("user").password("user").roles("USER");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.authorizeRequests()
//				.antMatchers(HttpMethod.POST, "/login").permitAll()
				.antMatchers(HttpMethod.POST, "/j_spring_security_logout").authenticated()
				.antMatchers(HttpMethod.GET, "/**").hasAnyRole("USER", "ADMIN", "ANONYMOUS")
				.antMatchers(HttpMethod.POST, "/api/v1/user").hasAnyRole("USER", "ADMIN", "ANONYMOUS")
				.antMatchers("/**").access("hasRole('ROLE_ADMIN')")
//				.antMatchers("/**").hasAnyRole("USER", "ADMIN")
				.and().formLogin()
				.and().logout().logoutUrl("/j_spring_security_logout")
				.logoutSuccessUrl("/")
				.and().httpBasic();
	}
}

