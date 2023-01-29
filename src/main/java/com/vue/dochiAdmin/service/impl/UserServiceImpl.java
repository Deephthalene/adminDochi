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
		log.info(">>> login check2");
		AES256 aes256 = new AES256();
		UserDto user = userMapper.getUser(email);
		log.info(">>>user" + user);
		log.info(aes256.decrypt(user.getPw()));
		
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
}
