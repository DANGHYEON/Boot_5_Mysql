package com.iu.b5.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {
	
	//login
	public MemberVO getSelectOne(MemberVO memberVO) throws Exception;
	
	// 회원가입
	public int setInsert(MemberVO memberVO)throws Exception;
	
	// 회원파일
	public int setFileInsert(MemberFilesVO memberFilesVO) throws Exception;
	

}
