package com.iu.b5.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b5.util.FileManager;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private FileManager fileManager;
	
	
	
	public MemberVO getSelectOne(MemberVO memberVO) throws Exception{
		return memberRepository.getSelectOne(memberVO);
	}
	
	

	public int setInsert(MemberVO memberVO, MultipartFile files) throws Exception{
		int result	= memberRepository.setInsert(memberVO);
		
		//or files.size()>0
		if(!files.isEmpty()) {
		
		
		String fileName = fileManager.getUseServletContext("/upload/member", files);
		MemberFilesVO filesVO = new MemberFilesVO();
		filesVO.setMember_id(memberVO.getId());
		filesVO.setFileName(fileName);
		filesVO.setOriName(files.getOriginalFilename());
		
		
		result = memberRepository.setFileInsert(filesVO);
		
		if(result==0) {
		  throw	new Exception();
		}
		
		
		}
		
		return result;
		
		
	}

}
