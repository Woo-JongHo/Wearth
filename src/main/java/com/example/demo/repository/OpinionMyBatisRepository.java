package com.example.demo.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.db.SchoolDBManager;
import com.example.demo.vo.OpinionVO;

@Repository
public class OpinionMyBatisRepository {

	public static int pageSize =10;
	public static int totalRecord;
	public static int totalPage;
	
	public List<OpinionVO> findAllOpinion(HashMap<String, Object> map){
		totalRecord = SchoolDBManager.getTotalRecordOpinion();
		totalPage = (int)Math.ceil(totalRecord / (double)pageSize);
		return SchoolDBManager.findAllOpinion(map);
	}
	
	public OpinionVO findByNoOpinion(int opinionNo) {
		return SchoolDBManager.findByNoOpinion(opinionNo);
	}

}
