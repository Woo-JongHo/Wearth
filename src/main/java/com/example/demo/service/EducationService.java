package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EducationJpaRepository;
import com.example.demo.repository.EducationMyBatisRepository;
import com.example.demo.vo.EducationVO;

import lombok.Setter;

@Service
@Setter
public class EducationService {

	@Autowired
	private EducationJpaRepository dao_JPA;
	
	@Autowired
	private EducationMyBatisRepository dao_MB;

	//MB (조회)
	public List<EducationVO> findAllEducation(HashMap<String, Object> map){
		return dao_MB.findAllEducation(map);
	}
	
	public EducationVO findByNoEducation(int eduNO) {
		return dao_MB.findByNoEducation(eduNO);
	}
	
	public int getTotalRecordEducation() {
		return dao_MB.getTotalRecordEducation();
	}
	
	//JPA (추가, 수정, 삭제)
	public void findAll(){
		dao_JPA.findAll();
	}
	
	public int getNextNoEducation() {
		return (int)dao_JPA.getNextNoEducation();
	}
	
	public void insertEducation(EducationVO e) {
		dao_JPA.save(e);
	}
	
	public void updateEducation(EducationVO e) {
		dao_JPA.save(e);
	}
	
	public void deleteEducation(int eduNO) {
		dao_JPA.deleteById(eduNO);
	}
}
