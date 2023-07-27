package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsersDAO;
import com.example.demo.vo.UsersVO;

import lombok.Setter;

@Service
@Setter
public class UserService implements UserDetailsService {
	
	@Autowired
	private UsersDAO dao;
	

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		UsersVO u = dao.findById(id).get();
		System.out.println(u);
		if(u==null) {
			throw new UsernameNotFoundException(id);
		}
		return User.builder()
				.username(id)
				.password(u.getPwd())
				.roles(u.getRole()).build();
	}

}
