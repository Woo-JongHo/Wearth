package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	
	@GetMapping("/")
	public String first() {return "/shopping/index";}
	
	@GetMapping("/shop")
	public String shop_main() {return "/shopping/shop_main";}
	
}
