package com.vue.dochiAdmin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vue.dochiAdmin.dto.UserDto;
import com.vue.dochiAdmin.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/user/*")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public ModelAndView loginGet(ModelAndView mv) {
		mv.setViewName("/user/login");
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView loginPost(ModelAndView mv, String email, String pw , HttpServletRequest request) throws Exception {
		log.info(" >>>> login check 1");
		UserDto isUser = userService.loginUser(email, pw);
		log.info(">>>isUser?" + isUser.toString());
		if(isUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("session", isUser);
			mv.addObject("user", isUser);
			mv.addObject("msg", "1");
			mv.setViewName("/index");
		}else {
			mv.setViewName("/user/login");
			mv.addObject("msg", "0");
		}
		return mv;
	}
}
