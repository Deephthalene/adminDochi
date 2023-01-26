package com.vue.dochiAdmin.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDto {
	private long uid;
	private String email;
	private String nickname;
	private String pw;
	private String name;
	private String phone;
	private Date created_at;
	private Date updated_at;
	private int status;
	private int email_check;
	private int grade;
}
