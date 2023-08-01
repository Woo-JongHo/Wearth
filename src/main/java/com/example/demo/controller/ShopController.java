package com.example.demo.controller;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.GoodsService;
import com.example.demo.vo.GoodsVO;

import lombok.Setter;


@Controller
@Setter
public class ShopController {

	@Autowired
	private GoodsService gs;	
	
	//전체상품 조회 및 카테고리별 상품 조회
	@GetMapping("/shop/shopMain")
	public void findGoods(@RequestParam(required = false) Integer categoryNo,Model model) {
		if(categoryNo != null) {
			System.out.println("categoryNO : "+categoryNo);
			 model.addAttribute("list",gs.findByCategoryNo(categoryNo));
		}else {
			model.addAttribute("list",gs.findGoods());
		}
		
	}
	
	 //상품 상세조회
	 @GetMapping("/shop/detail")
	 	public void detailGoods(@RequestParam Integer goodsNo, Model model) {
		 model.addAttribute("g",gs.detailGoods(goodsNo));
	 }
	 
	 //장바구니 조회
	 @GetMapping("/shop/cart")
	 	public String detailCart() {
		 return "shop/cart";
	 }
	 //장바구니 추가
	 @PostMapping("/shop/cart/{goodsNo}")
	 public ModelAndView insertCart(@PathVariable int goodsNo) {
		 ModelAndView mav = new ModelAndView("/shop/cart");
		 
		 return mav;
	 }
	 
	 //결제페이지 조회
	 @GetMapping("shop/order")
	 public String order() {
		 return "shop/order";
	 }
}
