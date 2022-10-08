package org.amel.plare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SpringSequrity extends WebSecurityConfigurerAdapter{
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable();
	        http.headers().frameOptions().disable();
	        http.authorizeRequests()
	                .antMatchers("/**").permitAll()
	                .anyRequest().authenticated()
	                .and()
	                .formLogin()
	                .defaultSuccessUrl("/").permitAll()
	                .and()
	                .logout()
	                .permitAll();
	    }


	    //passwordEncoder
	    @Bean
	    public BCryptPasswordEncoder encodePassword() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
	
}
