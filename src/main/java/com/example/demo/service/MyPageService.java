package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.OrdersVO;
import com.example.demo.vo.UsersVO;

public interface MyPageService {

	// 회원정보 수정
	public void update(UsersVO u);
	
	// 회원 탈퇴
	public void withdraw(UsersVO u);
	
	// 쇼핑내역 조회
	public List<OrdersVO> findOrdersByUserno(int pagenum);
	
}
