package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("index")
	public void index() {
	}
	
	@GetMapping("school/education/list")
	public void list() {
	}
	@GetMapping("school/education/insert")
	public void eduInsert() {}
	@GetMapping("school/education/test")
	public void test() {}
	
	
	@GetMapping("school/lecture/list")
	public void list2() {
	}
	@GetMapping("school/lecture/detail")
	public void detail() {}
	
	@GetMapping("opinion")
	public void list3() {
	}

	
	@GetMapping("school/trainingRequest/insert")
	public void insert() {
	}
	@GetMapping("school/trainingRequest/detail")
	public void detail2() {}
	@GetMapping("school/trainingRequest/detailAdmin")
	public void detail3() {}
	@GetMapping("school/trainingRequest/list")
	public void list4() {}
	@GetMapping("school/trainingRequest/update")
	public void update() {}
}
