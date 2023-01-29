package com.vue.dochiAdmin.paging;

import com.vue.dochiAdmin.dto.PageDto;

import lombok.Getter;

@Getter
public class Pagination {

	private int startPage; // 현재 화면에서 보여줄 시작 페이지네이션 번호
	private int endPage; // 현재 화면에서 보여줄 마지막 페이지네이션 번호
	private boolean prev, next; // 이전, 다음 페이지 여부
	// 총 10개씩 보이게
	// 1 2 3 4 5 6 7 8 9 10 next
	// prev 11 12 13 14... 20 next
	// prev 21 22
	
	private int totalCount; //전체 게시글 수
	private PageDto pageDto; 
	
	public Pagination(PageDto pageDto, int totalCount ) {
		this.pageDto = pageDto;
		this.totalCount = totalCount;
		this.endPage =  // 1~10 까지는 10의 값이 되도록 설정
				(int)(Math.ceil(pageDto.getPageNo() / (pageDto.getQty()*1.0)))*pageDto.getQty();
		this.startPage = endPage - 9; //1~10 => 1
		
		int realEndPage = (int)Math.ceil((totalCount*1.0) / pageDto.getQty());
		
		if(realEndPage < this.endPage) {
			this.endPage = realEndPage;
		}
		this.prev = this.startPage > 1; 
		this.next = this.endPage < realEndPage; 
	}
}
