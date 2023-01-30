package com.vue.dochiAdmin.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDto {
	private long uid;
	private String type;
	private String good_cnt;
	private String bad_cnt;
	private String title;
	private String content;
	private String created_user;
	private Date created_at;
	private Date updated_at;
	private int is_del;
	private int view_cnt;
	private String fileUrl;
}
