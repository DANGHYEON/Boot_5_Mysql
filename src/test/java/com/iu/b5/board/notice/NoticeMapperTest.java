package com.iu.b5.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.b5.board.BoardVO;

@SpringBootTest
class NoticeMapperTest {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	
	
	
		
	  //@Test 
	  void getSelectListTest() throws Exception{
	  
	  //List<BoardVO> ar = noticeMapper.getSelectList();
	  
	  
	
	  
	  
	  }
	 
	
	
	
	
	
	//@Test
	void getSelectOneTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(1);
		
		boardVO = noticeMapper.getSelectOne(boardVO);
		
		assertNotNull(boardVO);
		
		
	}
	
	
	
	
	
	
	//@Test
	void setDeleteTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(5);
		
		int result = noticeMapper.setDelete(boardVO);
		
		assertNotEquals(0, result);
	}
	
	
	
	
	//@Test
	void setUpdateTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(4);
		boardVO.setTitle("update1");
		boardVO.setContents("update2");
		
		int result = noticeMapper.setUpdate(boardVO);
		
		assertNotEquals(0, result);
		
	}

	//@Test
	void setInsertTest() throws Exception {
		
		for(int i=0;i<100;i++) {
		BoardVO boardVO = new BoardVO();
		
		  boardVO.setTitle("title"+i); 
		  boardVO.setContents("contents"+i);
		  boardVO.setWriter("writer"+i);
		 
		  int result = noticeMapper.setInsert(boardVO);
		
		  if(i%10==0) {
			  Thread.sleep(500);
		  }
		
		}
		System.out.println("Finish");
		
		
		
	
	}

}
