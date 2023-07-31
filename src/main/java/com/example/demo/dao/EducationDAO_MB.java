package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.EducationVO;

@Repository
public class EducationDAO_MB {

	public static int pageSize =12;
	public static int totalRecord;
	public static int totalPage;
	
	public List<EducationVO> findAllEducation(HashMap<String, Object> map){
		totalRecord = DBManager.getTotalRecordEducation();
		totalPage = (int)Math.ceil(totalRecord / (double)pageSize);
		return DBManager.findAllEducation(map);
	}
	
	public EducationVO findByNoEducation(int eduNO) {
		return DBManager.findByNoEducation(eduNO);
	}
	
	public int getTotalRecordEducation() {
		return DBManager.getTotalRecordEducation();
	}
	
}
