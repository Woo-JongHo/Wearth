package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.OpinionVO;

@Repository
public class OpinionDAO {

	public static int pageSize =10;
	public static int totalRecord;
	public static int totalPage;
	
	public List<OpinionVO> findAllOpinion(HashMap<String, Object> map){
		totalRecord = DBManager.getTotalRecordOpinion();
		totalPage = (int)Math.ceil(totalRecord / (double)pageSize);
		return DBManager.findAllOpinion(map);
	}
	
	public OpinionVO findByNoOpinion(int opinionNo) {
		return DBManager.findByNoOpinion(opinionNo);
	}

}
