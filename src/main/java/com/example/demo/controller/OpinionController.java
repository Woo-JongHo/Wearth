package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.dao.OpinionDAO;

import lombok.Setter;

@Controller
@Setter
public class OpinionController {

	@Autowired
	private OpinionDAO opinionDAO_JPA;

    
}
