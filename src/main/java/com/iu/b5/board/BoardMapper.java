package com.iu.b5.board;

import java.util.List;

import com.iu.b5.util.Pager;

public interface BoardMapper {
	
	//파일 저장
	public int setFileInsert(BoardFileVO boardFileVO) throws Exception;

	//insert 글쓰기
	public int setInsert(BoardVO boardVO) throws Exception;
	
	//update 글수정
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	//update 조회수
	public int setHtUpdate(BoardVO boardVO) throws Exception;
	
	//Delete 글삭제
	public int setDelete(BoardVO boardVO)throws Exception;
	
	//select 글하나 조회
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception;
	
	//select 글리스트 조회
	public List<BoardVO> getSelectList(Pager pager) throws Exception;
	
	//totalCount
	public Long getTotalCount(Pager pager) throws Exception;
	 
	
	
}
