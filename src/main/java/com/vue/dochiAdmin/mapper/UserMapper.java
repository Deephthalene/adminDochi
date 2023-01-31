package com.vue.dochiAdmin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vue.dochiAdmin.dto.PageDto;
import com.vue.dochiAdmin.dto.UserDto;

@Mapper
public interface UserMapper {

	UserDto getUser(String email);

	List<UserDto> getUserList(PageDto pageDto);

	int getTotalCount(PageDto pageDto);
	
	int searchTotalCount(PageDto pageDto);

	UserDto userDetailGet(long uid);

	void userStatusChangeGet(long uid);

	void userGradeChangeGet(long uid);

}
