package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.Engine;
import org.apache.catalina.Executor;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.Server;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserJpaRepository;
import com.example.demo.vo.UsersVO;

import lombok.Setter;

@Service
@Setter
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserJpaRepository ur;
	
	@Override
	public void join(UsersVO u) {
		ur.insert(u);
	}

	@Override
	public List<UsersVO> findAll() {
		return ur.findAll();
	}

	@Override
	public Optional<UsersVO> findById(String id) {
		return ur.findById(id);
	}

	@Override
	public Optional<UsersVO> findByNickname(String nickname) {
		return ur.findByNickname(nickname);
	}

	@Override
	public Optional<UsersVO> findByEmail(String email) {
		return ur.findByEmail(email);
	}

	@Override
	public Optional<UsersVO> findByPhone(String phone) {
		return ur.findByPhone(phone);
	}

}
