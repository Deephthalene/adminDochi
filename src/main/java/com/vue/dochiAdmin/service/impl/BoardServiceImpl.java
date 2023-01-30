package com.vue.dochiAdmin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vue.dochiAdmin.dto.BoardDto;
import com.vue.dochiAdmin.dto.PageDto;
import com.vue.dochiAdmin.mapper.BoardMapper;
import com.vue.dochiAdmin.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardMapper boardMapper;
	
	
	@Override
	public List<BoardDto> listGet(PageDto pageDto) {
		return boardMapper.listGet(pageDto);
	}


	@Override
	public int getTotalCount(PageDto pageDto) {
		return boardMapper.getTotalCount(pageDto);
	}

}
