package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String test() {
		return "main/main";
	}
	@GetMapping("/shop")
	public String test2() {
		return "shop/shopMain";
	}
	@GetMapping("/detail")
	public String test3() {
		return "shop/detail";
	}
	@GetMapping("/cart")
	public String test4() {
		return "shop/cart";
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
