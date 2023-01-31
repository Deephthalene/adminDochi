package com.vue.dochiAdmin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vue.dochiAdmin.dto.BoardDto;
import com.vue.dochiAdmin.dto.PageDto;
import com.vue.dochiAdmin.dto.UserDto;
import com.vue.dochiAdmin.paging.Pagination;
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
		UserDto isUser = userService.loginUser(email, pw);
		if(isUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("session", isUser);
			mv.addObject("user", isUser);
			mv.addObject("msg", "1");
			mv.setViewName("/index");
		}else {
			mv.addObject("msg", "0");
			mv.setViewName("/main");
		}
		return mv;
	}
	
	@GetMapping("/logout")
	public ModelAndView logoutGet(ModelAndView mv, HttpServletRequest request) {
		request.getSession().removeAttribute("session");
		mv.setViewName("/main");
		return mv;
	}
	
	@GetMapping("/customers")
	public ModelAndView customersGet(ModelAndView mv,PageDto pageDto) {
		List<UserDto> user = userService.getUserList(pageDto);
		mv.addObject("user", user);
		int totalCount = userService.getTotalCount(pageDto);
		Pagination pagination = new Pagination(pageDto, totalCount);
		mv.addObject("page", pagination);
		mv.setViewName("/customers");
		return mv;
	}
	
	@GetMapping("/detail")
	public ModelAndView UserdetailGet(ModelAndView mv, @RequestParam("uid") long uid) {
		UserDto user = userService.detailGet(uid);
		mv.addObject("user", user);
		mv.setViewName("/user/detail");
		return mv;
	}
	
	@GetMapping("/remove")
	public String userStatusChangeGet(ModelAndView mv, @RequestParam("uid") long uid, RedirectAttributes reAttr) {
		userService.userStatusChangeGet(uid);
		return "redirect:/user/customers";
	}
	
	@GetMapping("/gradeUp")
	public String userGradeChangeGet(@RequestParam("uid") long uid, RedirectAttributes reAttr) {
		userService.userGradeChangeGet(uid);
		return "redirect:/user/customers";
	}
}
