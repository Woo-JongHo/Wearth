package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.UsersDAO;

import lombok.Setter;

@Controller
@Setter
public class UserinfoController {
	
	@Autowired
	private UsersDAO dao;
	
	@GetMapping("/userinfo/test")
	public String test(Model model) {
		model.addAttribute("list", dao.findAll());
		return "userinfo/test";
	}

}
