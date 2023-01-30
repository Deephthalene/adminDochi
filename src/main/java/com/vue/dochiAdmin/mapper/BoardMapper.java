package com.vue.dochiAdmin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vue.dochiAdmin.dto.BoardDto;
import com.vue.dochiAdmin.dto.PageDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> listGet(PageDto pageDto);

	int getTotalCount(PageDto pageDto);

}
