package com.vue.dochiAdmin.service;

import java.util.List;

import com.vue.dochiAdmin.dto.BoardDto;
import com.vue.dochiAdmin.dto.PageDto;

public interface BoardService {

	List<BoardDto> listGet(PageDto pageDto);

	int getTotalCount(PageDto pageDto);

}
