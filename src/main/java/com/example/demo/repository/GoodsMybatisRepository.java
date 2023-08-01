package com.example.demo.repository;

import java.util.List;

import com.example.demo.db.ShopDBManager;
import com.example.demo.vo.GoodsVO;

public class GoodsMybatisRepository {
	
	//전체 상품목록 조회
	public static List<GoodsVO> findGoods() {
		return ShopDBManager.findGoods();
	}
	
	//카테고리별 상품목록 조회
	public static List<GoodsVO> findByCategoryNo(int categoryNo){
		return ShopDBManager.findByCategoryNo(categoryNo);
	}
	
	//상품 상세목록 조회
	public static GoodsVO detailGoods(int goodsNo) {
		return ShopDBManager.detailGoods(goodsNo);
	}
}
