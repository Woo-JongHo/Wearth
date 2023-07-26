package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests().requestMatchers("/**").permitAll()
		.requestMatchers("/admin/**").hasRole("admin")
		.anyRequest().authenticated();
		
		http.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/");
		
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.invalidateHttpSession(true).logoutSuccessUrl("/");
		
		http.httpBasic();
		
		return http.build();
	}
	
}