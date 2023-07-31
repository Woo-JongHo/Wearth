package com.example.demo.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserJpaRepository;
import com.example.demo.vo.UsersVO;

import lombok.Setter;

@Service
@Setter
public class UserDetailServiceImpl implements UserDetailsService  {
	
	@Autowired
	private UserJpaRepository dao;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
	    Optional<UsersVO> userOptional = dao.findById(id);
	    UsersVO u = userOptional.orElse(null);
	    if (u == null) {
	        throw new UsernameNotFoundException(id);
	    }
		return User.builder()
				.username(id)
				.password(u.getPwd())
				.roles(u.getRole()).build();
	}

}
