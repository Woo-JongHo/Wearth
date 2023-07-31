package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ActBoardcontroller {

	@GetMapping("/act/actBoardMain")
	public String actList() {
		return "/act/actBoardMain";
	}
	
	@GetMapping("/act/actBoardDetail")
	public String actDetail() {
		return "/act/actBoardDetail";
	}
	
	@GetMapping("/act/actBoardInsert")
	public String actBoardInsert() {
		return "/act/actBoardInsert";
	}
	
	@PostMapping("/act/actBoardInsert")
	public String actBoardInsertOK() {
		return "/act/actBoardInsert";
	}
	
}
