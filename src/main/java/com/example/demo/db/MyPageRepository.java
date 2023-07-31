package com.example.demo.db;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.vo.GoodsVO;
import com.example.demo.vo.OrdersDetailVO;
import com.example.demo.vo.OrdersVO;
import com.example.demo.vo.UsersVO;

public interface MyPageRepository {
	
	// 회원정보 수정
	public void update(UsersVO u);
	
	// 회원탈퇴
	public void delete(UsersVO u);
	
	// 쇼핑 내역 조회
	public List<OrdersVO> findOrdersByUserno();
	
	// 신청 내역 조회 (수정 예정)
	public List<?> findAppByUserno();
	
	// 상세 쇼핑 내역 조회
	public List<OrdersDetailVO> findOrdersDetailVOByOrderno();
	
	// 좋아요한 상품 조회
	public List<GoodsVO> findGoodsByUserno();
	
	// 좋아요한 교육 조회
	public List<?> findEducationByUserno();
	
	// 좋아요한 강연 조회
	public List<?> findLectureByUserno();
	
	// 좋아요한 글 조회
	public List<?> findBoardByUserno();
	
}
