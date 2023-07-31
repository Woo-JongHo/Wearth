package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.vo.UsersVO;

public interface UserInfoService {	
	
	// 회원가입
	public void join(UsersVO u);
	
	// 회원 목록 불러오기 ( test 코드 -> 추후 삭제 )
	public List<UsersVO> findAll();
	
	// 아이디로 회원 찾기
	public Optional<UsersVO> findById(String id);
	
	// 닉네임으로 회원 찾기
	public Optional<UsersVO> findByNickname(String nickname);
	
	// 이메일으로 회원 찾기
	public Optional<UsersVO> findByEmail(String email);
	
	// 전화번호로 회원 찾기
	public Optional<UsersVO> findByPhone(String phone);
	
	
	
}
