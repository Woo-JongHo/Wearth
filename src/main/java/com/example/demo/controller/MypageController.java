package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.UsersDAO;

import lombok.Setter;

@Controller
@Setter
public class MypageController {
	
	@GetMapping("/mypage/shopping/list")
	public void shopping() {}
	
	@GetMapping("/mypage/shopping/detail")
	public void detail_shopping() {}
	
	@GetMapping("/mypage/act/list")
	public void act() {}
	
	@GetMapping("/mypage/edu/list")
	public void edu() {}
	
	@GetMapping("/mypage/edu/detail")
	public void detail_edu() {}
	
}
