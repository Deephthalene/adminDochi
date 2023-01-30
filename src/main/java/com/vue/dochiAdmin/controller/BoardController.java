package com.vue.dochiAdmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
