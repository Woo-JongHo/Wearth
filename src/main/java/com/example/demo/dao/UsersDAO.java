package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.UsersVO;

@Repository
public interface UsersDAO extends JpaRepository<UsersVO, Integer> {
	
		// 아이디로 user찾기
		public Optional<UsersVO> findById(String id);

}
