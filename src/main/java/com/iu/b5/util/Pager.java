package com.iu.b5.util;

import lombok.Data;

@Data
public class Pager {
	
	private String kind;
	private String search;
	//-------
	
	private Integer pn; //페이지번호
	private Integer perPage; //한 페이지에 출력할 갯수
	private Integer startRow; // limit의 시작 번호
	
	private Long startNum;
	private Long lastNum;
	
	private boolean lastCheck; //true면 마지막블럭, false면 마지막블럭이 아니다.
	
	public void makeRow() {
	 this.startRow	= (this.getPn()-1)*this.getPerPage();
		
	}
	
	public void makeNum(Long totalCount) {
		
		Long totalPage = totalCount/this.getPerPage();
		
		if(totalCount%this.getPerPage() != 0) {
			totalPage++;
		}
		
		// 3. 총 블럭의 갯수 구하기.
		Long perBlock=5L;
		Long totalBlock= totalPage/perBlock ;
		
		if(totalPage%perBlock !=0) {
			totalBlock++;
		}
		
		// 4. pn로 현재 블럭 번호 구하기
		Long curBlock = this.getPn()/perBlock;
		if(this.getPn()%perBlock != 0) {
			curBlock++;
		}
		
		startNum = (curBlock-1)*perBlock+1;
		lastNum = curBlock*perBlock;
		
		if(curBlock == totalBlock) {
		    lastCheck=true;
			lastNum = totalPage;
			
		}
		
	}
	
	
	
	
	//-- setter , getter--
	
	public Integer getPn() {
		if(this.pn==null || this.pn<1) {
			this.pn=1;
		}
		return pn;
	}
	
	public Integer getPerPage() {
		if(this.perPage==null || this.perPage<1) {
			this.perPage=10;
		}
		return perPage;
	}
	
	
	
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		
		return this.search;
	}
	

}
