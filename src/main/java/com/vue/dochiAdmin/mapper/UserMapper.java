package com.vue.dochiAdmin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.vue.dochiAdmin.dto.UserDto;

@Mapper
public interface UserMapper {

	UserDto getUser(String email);

}
