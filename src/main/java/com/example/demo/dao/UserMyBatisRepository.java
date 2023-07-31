package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.db.UserInfoRepository;
import com.example.demo.vo.UsersVO;
@Repository
public class UserMyBatisRepository implements UserInfoRepository {

	@Override
	public void insert(UsersVO u) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<UsersVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UsersVO> findById(String id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<UsersVO> findByNickname(String nickname) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<UsersVO> findByEmail(String email) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<UsersVO> findByPhone(String phone) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
