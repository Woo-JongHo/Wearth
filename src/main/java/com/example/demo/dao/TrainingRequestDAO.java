package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.TrainingRequestVO;

@Repository
public class TrainingRequestDAO {

	public static int pageSize =10;
	public static int totalRecord;
	public static int totalPage;
	
	public List<TrainingRequestVO> findAllTrainingRequest(HashMap<String, Object> map){
		totalRecord = DBManager.getTotalRecordTrainingRequest();
		totalPage = (int)Math.ceil(totalRecord / (double)pageSize);
		return DBManager.findAllTrainingRequest(map);
	}
	
	public TrainingRequestVO findByNoTrainingRequest(int reqNo) {
		return DBManager.findByNoTrainingRequest(reqNo);
	}

}
