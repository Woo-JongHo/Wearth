package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.UsersVO;

import jakarta.transaction.Transactional;

@Repository
@Primary
public interface UserJpaRepository extends JpaRepository<UsersVO, Integer> {

	// 회원가입
	@Transactional
	@Modifying
	@Query(value = "insert into Users b(userno, id, pwd, u_name, date_birth, gender, "
			+ "email, nickname, date_reg, residence, phone, point, score, u_status, role) "
			+ "values (seq_usersno.nextval,:#{#u.id},:#{#u.pwd}, :#{#u.u_name}, :#{#u.date_birth}, :#{#u.gender}, "
			+ ":#{#u.email}, :#{#u.nickname}, sysdate , :#{#u.residence}, :#{#u.phone}"
			+ ", 0, 0,'Y', :#{#u.role})", nativeQuery = true)
	public void insert(UsersVO u);
	
	// 아이디로 회원 찾기
	public Optional<UsersVO> findById(String id);

	// 닉네임으로 회원 찾기
	public Optional<UsersVO> findByNickname(String nickname);

	// 이메일로 회원 찾기
	public Optional<UsersVO> findByEmail(String email);

	// 전화번호로 회원 찾기
	public Optional<UsersVO> findByPhone(String phone);

}
