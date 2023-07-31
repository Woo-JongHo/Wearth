package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.LectureVO;

@Repository
public class LectureDAO {

	public List<LectureVO> findBylecDateList(String lecDate){
		return DBManager.findBylecDateList(lecDate);
	}
	
	public List<LectureVO> listDate(String date) {
		return DBManager.listDate(date);
	}

}
