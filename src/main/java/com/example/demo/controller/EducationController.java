package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.EducationDAO_JPA;
import com.example.demo.dao.EducationDAO_MB;
import com.example.demo.service.EducationService;
import com.example.demo.vo.EducationVO;

import lombok.Setter;

@Controller
@Setter
public class EducationController {
	
	@Autowired
	private EducationService es;
	/*
	@GetMapping("/school/education/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("redirect:/school/education/list");
		mav.addObject("list",es.findAll());
		return mav;
	}
	*/
	/*
	@GetMapping("/school/education/list/{pageNUM}")
	public void list(Model model, @RequestParam(value = "pageNUM", defaultValue = "1")int pageNUM) {
		int start = (pageNUM-1)*EducationDAO_MB.pageSize+1;
		int end = start + EducationDAO_MB.pageSize-1;
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		model.addAttribute("list",es.findAllEducation(map));
		model.addAttribute("totalPage", EducationDAO_MB.totalPage);
	}
	
	
	@GetMapping("/school/education/insert")
	public void insert() {}
	
	@PostMapping("/school/education/insert")
	public String insert(EducationVO e) {
		
		return "redirect:/school/education/list";
	}
	
	@GetMapping("/school/education/update/{eduNO}")
	public void update(Model model, int eduNO) {
		
	}
	*/
	
	@GetMapping("/school/education/detail")
	public void detail() {}
}
