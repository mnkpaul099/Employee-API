package com.employee.config;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;

/*import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration*/
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("employee").password("{noop}employee").roles("EMPLOYEE");
	} 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/employee/**").hasRole("EMPLOYEE")
		.anyRequest().fullyAuthenticated().and()
		.httpBasic();
	}
	
}**/
