package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.GoodsJpaRepository;
import com.example.demo.repository.GoodsMybatisRepository;
import com.example.demo.vo.GoodsVO;

import lombok.Setter;

@Service
@Setter
public class GoodsService {

	@Autowired
	private GoodsJpaRepository gj;
	private GoodsMybatisRepository gm;
	
	//전체 상품 목록 조회
	public List<GoodsVO> findGoods(HashMap<Object, Object> map){
		return gm.findGoods(map);
	}
	
	//카테고리별 상품목록 조회
	public List<GoodsVO> findByCategoryNo(HashMap<Object, Object> map){
		return gm.findByCategoryNo(map);
	}
	
	//상품상세목록 조회
	public GoodsVO detailGoods(int goodsNo) {
		return gm.detailGoods(goodsNo);

	}
	
}
