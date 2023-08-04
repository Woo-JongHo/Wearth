package com.example.demo.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.db.SchoolDBManager;
import com.example.demo.vo.TrainingRequestVO;

@Repository
public class TrainingRequestMyBatisRepository {

	public static int pageSize =10;
	public static int totalRecord;
	public static int totalPage;
	
	public List<TrainingRequestVO> findAllTrainingRequest(HashMap<String, Object> map){
		totalRecord = SchoolDBManager.getTotalRecordTrainingRequest();
		totalPage = (int)Math.ceil(totalRecord / (double)pageSize);
		return SchoolDBManager.findAllTrainingRequest(map);
	}
	
	public TrainingRequestVO findByNoTrainingRequest(int reqNo) {
		return SchoolDBManager.findByNoTrainingRequest(reqNo);
	}

}
