package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class KakaoAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String id = authentication.getName();

        UserDetails userDetails = userDetailsService.loadUserByUsername(id);
        if (userDetails == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // 여기에 카카오 사용자 정보를 기반으로 추가적인 인증 로직을 구현합니다.

        // 인증 성공 시 Authentication 객체를 생성하여 반환합니다.
        Authentication authenticatedUser = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        return authenticatedUser;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // 이 AuthenticationProvider가 지원하는 인증 객체 타입을 설정합니다.
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}