package com.vue.dochiAdmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vue.dochiAdmin.dto.BoardDto;
import com.vue.dochiAdmin.dto.PageDto;
import com.vue.dochiAdmin.paging.Pagination;
import com.vue.dochiAdmin.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/board/*")
@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@GetMapping("/list")
	public ModelAndView listGet(ModelAndView mv, PageDto pageDto) {
		List<BoardDto> board = boardService.listGet(pageDto);
		mv.addObject("board", board);
		int totalCount = boardService.getTotalCount(pageDto);
		Pagination pagination = new Pagination(pageDto, totalCount);
		mv.addObject("page", pagination);
		mv.setViewName("/board");
		return mv;
	}
	
	@GetMapping("/detail")
	public ModelAndView detailGet(ModelAndView mv, @RequestParam("uid") long uid) {
		BoardDto board = boardService.detailGet(uid);
		mv.addObject("board", board);
		mv.setViewName("/board/detail");
		return mv;
	}
	
	@GetMapping("/remove")
	public String removeGet(ModelAndView mv, @RequestParam("uid") long uid, RedirectAttributes reAttr) {
		boardService.removeGet(uid);
		return "redirect:/board/list";

	}
}
