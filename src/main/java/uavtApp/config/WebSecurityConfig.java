package uavtApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		@SuppressWarnings("deprecation")
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("omer").password("ok").roles("FULL","READONLY"))
		.withUser(users.username("meric").password("ay").roles("READONLY"))
		.withUser(users.username("metin").password("oz").roles("READONLY"));
		
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

			http.
				formLogin()
					.loginPage("/showCustomLoginPage") // login sayfasının mappingi
					.loginProcessingUrl("/authenticateUser")//mapping gerektirmez
					.permitAll()
			.and()
				.logout()
				.permitAll();
		http.authorizeRequests().antMatchers("/department/list").hasRole("READONLY");
		http.authorizeRequests().antMatchers("/department/**").hasRole("FULL");
		http.authorizeRequests().antMatchers("/erisim-engellendi").hasRole("READONLY");
		
		/*
		http.authorizeRequests().antMatchers("/managers/**").hasRole("FULL")
		.antMatchers("/hr/**").hasRole("HR");*/
		http.exceptionHandling().accessDeniedPage("/erisim-engellendi");
		
	}
	
}
