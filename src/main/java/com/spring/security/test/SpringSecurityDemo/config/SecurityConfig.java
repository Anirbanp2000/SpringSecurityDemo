package com.spring.security.test.SpringSecurityDemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;




//import com.spring.security.test.SpringSecurityDemo.service.CustomUserDetailsService;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
     
	@Bean
	public UserDetailsService userDetailsService() {
		
		
		UserDetails normalUser=User.withUsername("ani").password(passwordEncoder().encode("ani")).roles("NORMAL").build();
		UserDetails adminUser=User.withUsername("anirban").password(passwordEncoder().encode("anirban")).roles("ADMIN").build();
//		
//		InMemoryUserDetailsManager inMemoryUserDetailsManager= new InMemoryUserDetailsManager(normalUser, adminUser);
		return new InMemoryUserDetailsManager(normalUser, adminUser);
		
		
	}
	
	@Bean
	 public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		 httpSecurity.csrf().disable()
		   .authorizeHttpRequests()
//		   .requestMatchers("/home/admin")
//		   .hasRole("ADMIN")
//		   .requestMatchers("/home/normal")
//		   .hasRole("NORMAL")
//		   .requestMatchers("/home/public")
//		   .permitAll()
		   .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
		   .anyRequest()
		   .authenticated()
		   .and().formLogin();
		 
		 return httpSecurity.build();
		
		
	}
}
