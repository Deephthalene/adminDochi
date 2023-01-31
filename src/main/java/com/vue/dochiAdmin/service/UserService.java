package com.vue.dochiAdmin.service;

import java.util.List;

import com.vue.dochiAdmin.dto.PageDto;
import com.vue.dochiAdmin.dto.UserDto;

public interface UserService {

	UserDto loginUser(String email, String pw) throws Exception;

	List<UserDto> getUserList(PageDto pageDto);

	int getTotalCount(PageDto pageDto);

	UserDto detailGet(long uid);

	void userStatusChangeGet(long uid);

	void userGradeChangeGet(long uid);

}
