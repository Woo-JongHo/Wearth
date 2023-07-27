package com.example.demo.controller;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UsersDAO;
import com.example.demo.vo.UsersVO;

import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@Setter
public class UserinfoController {
	
	@Autowired
	private UsersDAO dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("userinfo/test")
	public String test(Model model) {
		model.addAttribute("list", dao.findAll());
		return "userinfo/test";
	}
	
	@GetMapping("userinfo/login")
	public void login() {}

	
	@PostMapping("/userinfo/kakaoLogin")
    public String kakaoLogin(String id, HttpSession session) {
        String checkId = "kakao@" + id;
        System.out.println(checkId);
        Optional<UsersVO> u = dao.findById(checkId);
        if (u.isPresent()) {
            session.setAttribute("u", u.get());
            System.out.println(u.get());
            return "redirect:/";
        } else {
            return "redirect:/userinfo/signup";
        }
    }

	@GetMapping("/userinfo/signup")
	public void signup() {}

}
