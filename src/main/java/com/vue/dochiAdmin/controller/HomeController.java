package com.vue.dochiAdmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(value="/")
	public String main() {
		return "main";
	}
	
	@RequestMapping(value="/index")
	public String index() {
		return "index";
	}
	
	
}
