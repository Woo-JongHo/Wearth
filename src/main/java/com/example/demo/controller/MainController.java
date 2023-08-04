package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String test() {
		return "main/main";
	}

	@GetMapping("/order")
	public String test5() {
		return "shop/order";
	}

	@GetMapping("/admin")
	public String admin1(){
		return "admin/Main";
	}

	@GetMapping("/adminD")
	public String admin2(){
		return "admin/DashBoard";
	}

	@GetMapping("/adminU")
	public String admin3(){
		return "admin/UserList";
	}

	@GetMapping("/adminContainerU")
	public String admin4(){
		return "admin/Container/ContainerUserList";
	}
}
