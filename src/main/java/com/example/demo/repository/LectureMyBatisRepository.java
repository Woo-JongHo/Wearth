package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.db.SchoolDBManager;
import com.example.demo.vo.LectureVO;

@Repository
public class LectureMyBatisRepository {

	public List<LectureVO> findBylecDateList(String lecDate){
		return SchoolDBManager.findBylecDateList(lecDate);
	}
	
	public List<LectureVO> listDate(String date) {
		return SchoolDBManager.listDate(date);
	}
}
