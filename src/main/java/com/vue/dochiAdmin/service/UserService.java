package com.vue.dochiAdmin.service;

import com.vue.dochiAdmin.dto.UserDto;

public interface UserService {

	UserDto loginUser(String email, String pw) throws Exception;

}
