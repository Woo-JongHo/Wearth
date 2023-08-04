package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repository.EducationMyBatisRepository;
import com.example.demo.service.EducationService;
import com.example.demo.vo.EducationVO;
import lombok.Setter;

@Controller
@Setter
public class EducationController {
	
	@Autowired
	private EducationService es;
	//EducationMyBatisRepository, EducationJpaRepository
	
	@GetMapping("/school/education/list/{pageNUM}")
	public String list(Model model, @PathVariable("pageNUM")int pageNUM) {
		int start = (pageNUM-1)*EducationMyBatisRepository.pageSize+1;
		int end = start + EducationMyBatisRepository.pageSize-1;
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		model.addAttribute("list",es.findAllEducation(map));
		model.addAttribute("totalPage", EducationMyBatisRepository.totalPage);
		return "school/education/list";
	}
	
	// insert에 파일올리기 추가해야 함
	@GetMapping("/school/education/insert")
	public void insert() {}
	@PostMapping("/school/education/insert")
	public String insert(EducationVO e) {
		return "redirect:/school/education/list";
	}
	
	@GetMapping("/school/education/update/{eduNO}")
	public String update(Model model, @PathVariable("eduNO")  int eduNO) {
		model.addAttribute("b",es.findByNoEducation(eduNO));
		return "/school/education/update";
	}
	@PostMapping("/school/education/update")
	public String update(EducationVO e) {
		es.updateEducation(e);
		return "redirect:/school/education/list";
	}
	
	@GetMapping("/school/education/detail/{eduNO}")
	public ModelAndView detail(@PathVariable("eduNO") int eduNO) {
		System.out.println("교육컨트롤러(detail) 글번호 : "+ eduNO);
		ModelAndView mav = new ModelAndView("/school/education/detail");
			mav.addObject("b",es.findByNoEducation(eduNO));
		return mav;
	}
}
