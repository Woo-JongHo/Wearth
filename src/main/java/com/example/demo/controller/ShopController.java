package com.example.demo.controller;

import java.util.HashMap;

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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@Setter
public class ShopController {

	@Autowired
	private GoodsService gs;

	// 전체상품 조회 및 카테고리별 상품 조회
	@GetMapping(value = { "/shop/shopMain/{categoryNo}", "/shop/shopMain/{categoryNo}/{value}", "/shop/shopMain",
			"/shop/shopMain/{value}" })
	public ModelAndView findGoods(@PathVariable(required = false) Integer categoryNo,
			@PathVariable(required = false) String value, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/shop/shopMain");
		HttpSession session = (HttpSession) request.getSession();
		session.setAttribute("categoryNo", categoryNo);
		session.setAttribute("value", value);
		if (categoryNo == 1 && value == null) {
			session.setAttribute("categoryNo", categoryNo);
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put("categoryNo", categoryNo);
			mav.addObject("list", gs.findGoods(map));
		} else if (categoryNo == 1 && value != null) {
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put("categoryNo", categoryNo);
			map.put("value", value);
			mav.addObject("list", gs.findGoods(map));
			
		} else if (categoryNo != null && value == null) {
			session.setAttribute("categoryNo", categoryNo);
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put("categoryNo", categoryNo);
			mav.addObject("list", gs.findByCategoryNo(map));
		} else if (categoryNo != null && value != null) {
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put("categoryNo", categoryNo);
			map.put("value", value);
			mav.addObject("list", gs.findByCategoryNo(map));
		}
		return mav;
	}

	// 상품 상세조회
	@GetMapping("/shop/detail")
	public void detailGoods(@RequestParam Integer goodsNo, Model model) {
		model.addAttribute("g", gs.detailGoods(goodsNo));
	}

	// 장바구니 조회
	@GetMapping("/shop/cart")
	public String detailCart() {
		return "shop/cart";
	}

	// 장바구니 추가
	@PostMapping("/shop/cart/{goodsNo}")
	public ModelAndView insertCart(@PathVariable int goodsNo) {
		ModelAndView mav = new ModelAndView("/shop/cart");

		return mav;
	}

	// 결제페이지 조회
	@GetMapping("shop/order")
	public String order() {
		return "shop/order";
	}
}
