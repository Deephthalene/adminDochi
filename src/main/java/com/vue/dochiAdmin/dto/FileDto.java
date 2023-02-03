package com.vue.dochiAdmin.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileDto {
	private long uid;
	private long mother_uid;
	private long file_size;
	private String file_name;
	private String file_url;
	private Date created_at;
	private Date updated_at;
}
