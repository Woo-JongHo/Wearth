package com.example.demo.db;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.vo.UsersVO;

public interface UserInfoRepository {
	
	// 회원가입
	public void insert(UsersVO u);
	
	// test
	public List<UsersVO> findAll();

	// 아이디로 회원 찾기
	public Optional<UsersVO> findById(String id);

	// 닉네임으로 회원 찾기
	public Optional<UsersVO> findByNickname(String nickname);

	// 이메일로 회원 찾기
	public Optional<UsersVO> findByEmail(String email);

	// 전화번호로 회원 찾기
	public Optional<UsersVO> findByPhone(String phone);
}
