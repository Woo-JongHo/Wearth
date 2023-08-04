package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.EducationVO;

import lombok.Setter;
@Repository
public interface EducationJpaRepository extends JpaRepository<EducationVO, Integer>{
	
	@Query(value = "select nvl(max(eduno),0)+1 from education", nativeQuery = true)
	public int getNextNoEducation();
	
	
}
