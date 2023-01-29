package com.vue.dochiAdmin.dto;

import com.vue.dochiAdmin.paging.Pagination;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageDto {
	private int pageNo; // 현재 화면에 출력된 페이지네이션 번호
	private int qty;  //한페이지당 보여줄 게시글 수
	
	private String type;
	private String keyword;
	
	public PageDto() {
		this(1,10);
	}
	public PageDto(int pageNo, int qty) {
		this.pageNo = pageNo;
		this.qty = qty;
	}
	public int getPageStart() { //시작 번호 값 구하는 메서드
		return (this.pageNo - 1) * qty;  //DB에서 값을 limit 첫 시작이 0
	}
	public String[] getTypeToArray() {
		return this.type == null ? new String[] {} : this.type.split("");
	}

}
