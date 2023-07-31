package com.example.demo.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.dao.UserJpaRepository;
import com.example.demo.service.UserInfoService;
import com.example.demo.vo.UsersVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Configuration
@EnableWebSecurity
@Setter
public class SecurityConfig {

	@Autowired
	private UserInfoService us;

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web.ignoring().requestMatchers("/css/**", "/js/**", "/php/**", "/images/**");
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.httpBasic().disable();
		http.authorizeRequests().requestMatchers("/**", "/userinfo/signup/**", "/userinfo/kakaoLogin").permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated();

		http.formLogin().loginPage("/userinfo/login").loginProcessingUrl("/userinfo/login").permitAll()
				.successHandler(successHandler).failureHandler(failureHandler);

		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/userinfo/logout")).invalidateHttpSession(true)
				.logoutSuccessUrl("/");

		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

		return http.getOrBuild();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		return new KakaoAuthenticationProvider();
	}

	private AuthenticationSuccessHandler successHandler = new AuthenticationSuccessHandler() {

		@Override
		public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
				Authentication authentication) throws IOException, ServletException {
			String id = authentication.getName();
			UsersVO u = us.findById(id).get();
			u.setPwd(null);
			HttpSession session = request.getSession();
			session.setAttribute("u", u);
			response.sendRedirect("/");
		}
	};

	private AuthenticationFailureHandler failureHandler = new AuthenticationFailureHandler() {

		@Override
		public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException exception) throws IOException, ServletException {
			String id = request.getParameter("username");
			String msg = getError(exception, id);
			request.setAttribute("msg", msg);
			System.out.println("msg : " + msg);
			response.sendRedirect("/userinfo/login");

		}
	};

	private String getError(AuthenticationException exception, String id) {
		String msg;

		if (exception instanceof BadCredentialsException) {
			msg = "잘못된 비밀번호입니다.";

		} else if (exception instanceof DisabledException) {
			msg = "계정이 비활성화되었습니다.";
		} else if (exception instanceof LockedException) {
			msg = "계정이 잠겼습니다. 잠시 후 다시 시도해주세요.";
		} else if (exception instanceof UsernameNotFoundException) {
			msg = "존재하지 않는 아이디입니다.";
		} else {
			msg = "로그인에 실패했습니다. 다시 시도해주세요.";
		}

		return msg;

	}
}
