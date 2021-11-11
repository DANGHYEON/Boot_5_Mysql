package com.iu.b5.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class MemberRepositoryTest {
	
	@Autowired
	private MemberRepository memberRepositoryTest;
	
	
	
	@Test
	void getSelectOneTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("user");
		memberVO.setPw("user");
		//memberVO = memberRepositoryTest.getSelectOne(memberVO);
		
		assertNotNull(memberVO);
	}
	
	
	//@Test
	void setFileInsertTest() throws Exception{
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setMember_id("user");
		memberFilesVO.setFileName("usetFile");
		memberFilesVO.setOriName("userOriginal");
		
		int result = memberRepositoryTest.setFileInsert(memberFilesVO);
		
		assertEquals(1, result);
		
		
	}
	
	

	//@Test
	void setInsertTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("user");
		memberVO.setPw("user");
		memberVO.setName("user");
		memberVO.setEmail("user@email.com");
		
		int result = memberRepositoryTest.setInsert(memberVO);
		
		assertEquals(1, result);
		
	}

}
