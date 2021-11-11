package com.iu.b5.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.iu.b5.board.BoardMapper;
import com.iu.b5.board.BoardVO;

@Mapper
public interface QnaMapper extends BoardMapper {
	
	public int setReplyInsert(QnaVO qnaVO) throws Exception;
	
	public int setRefUpdate(BoardVO boardVO) throws Exception;

}
