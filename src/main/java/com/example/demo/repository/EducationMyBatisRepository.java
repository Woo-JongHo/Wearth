package com.example.demo.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.db.SchoolDBManager;
import com.example.demo.vo.EducationVO;

@Repository
public class EducationMyBatisRepository {

	public static int pageSize =12;
	public static int totalRecord;
	public static int totalPage;
	
	public List<EducationVO> findAllEducation(HashMap<String, Object> map){
		totalRecord = SchoolDBManager.getTotalRecordEducation();
		totalPage = (int)Math.ceil(totalRecord / (double)pageSize);
		return SchoolDBManager.findAllEducation(map);
	}
	
	public EducationVO findByNoEducation(int eduNO) {
		return SchoolDBManager.findByNoEducation(eduNO);
	}
	
	public int getTotalRecordEducation() {
		return SchoolDBManager.getTotalRecordEducation();
	}
	
}
