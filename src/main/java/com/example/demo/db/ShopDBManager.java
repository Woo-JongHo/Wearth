package com.example.demo.db;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.example.demo.vo.GoodsCategoryVO;
import com.example.demo.vo.GoodsVO;

public class ShopDBManager extends DBManager{

	//goods
		public static List<GoodsVO> findGoods(HashMap<Object, Object> map){
			SqlSession session = sqlSessionFactory.openSession();
			List<GoodsVO> list = session.selectList("goods.findGoods",map);
			session.close();
			return list;
		}
		
		public static List<GoodsVO> findByCategoryNo(HashMap<Object, Object> map){
			SqlSession session = sqlSessionFactory.openSession();
			List<GoodsVO> list = session.selectList("goods.findByCategoryNo", map);
			session.close();
			return list;
		}
		
		public static GoodsVO detailGoods(int goodsNo) {
			SqlSession session = sqlSessionFactory.openSession();
			GoodsVO g = session.selectOne("goods.detailGoods", goodsNo);
			session.close();
			return g;
		}
		//category
		public static List<GoodsCategoryVO> findCategory(){
			SqlSession session = sqlSessionFactory.openSession();
			List<GoodsCategoryVO> list = session.selectList("category.findCategory");
			session.close();
			return list;
		}
}
