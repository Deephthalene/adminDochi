package com.vue.dochiAdmin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vue.dochiAdmin.dto.PageDto;
import com.vue.dochiAdmin.dto.UserDto;
import com.vue.dochiAdmin.mapper.UserMapper;
import com.vue.dochiAdmin.service.UserService;
import com.vue.dochiAdmin.util.AES256;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDto loginUser(String email, String pw) throws Exception {
		AES256 aes256 = new AES256();
		UserDto user = userMapper.getUser(email);
		return user;
	}

	@Override
	public List<UserDto> getUserList(PageDto pageDto) {
		return userMapper.getUserList(pageDto);
	}

	@Override
	public int getTotalCount(PageDto pageDto) {
		return userMapper.getTotalCount(pageDto);
	}

	@Override
	public UserDto detailGet(long uid) {
		return userMapper.userDetailGet(uid);
	}

	@Override
	public void userStatusChangeGet(long uid) {
		userMapper.userStatusChangeGet(uid);
		
	}

	@Override
	public void userGradeChangeGet(long uid) {
		userMapper.userGradeChangeGet(uid);
		
	}	
}
