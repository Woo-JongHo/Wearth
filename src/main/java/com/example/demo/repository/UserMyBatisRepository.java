package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.vo.UsersVO;
@Repository
public class UserMyBatisRepository {

	public void insert(UsersVO u) {
	}

	public List<UsersVO> findAll() {
		return null;
	}

	public Optional<UsersVO> findById(String id) {
		return Optional.empty();
	}

	public Optional<UsersVO> findByNickname(String nickname) {
		return Optional.empty();
	}

	public Optional<UsersVO> findByEmail(String email) {
		return Optional.empty();
	}

	public Optional<UsersVO> findByPhone(String phone) {
		return Optional.empty();
	}

}
