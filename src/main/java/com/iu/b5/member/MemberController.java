package com.iu.b5.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberLogout")
	public String getLogout(HttpSession session)throws Exception{
		session.invalidate();
		
		return "redirect:../";
		
	}
	
	
	@GetMapping("memberLogin")
	public String getSelectOne()throws Exception{
		
		return "member/memberLogin";
	}
	
	@PostMapping("memberLogin")
	public String getSelectOne(MemberVO memberVO, HttpSession httpSession)throws Exception{
		
		memberVO = memberService.getSelectOne(memberVO);
		
		if(memberVO != null) {
			httpSession.setAttribute("member", memberVO);
		}
		
		
		return "redirect:../ ";
	}
	
	
	@GetMapping("memberJoin")
	public String setInsert() throws Exception{
		
		return "member/memberJoin";
	}
	
	@PostMapping("memberJoin")
	public String setInsert(MemberVO memberVO,MultipartFile files)throws Exception{
		int result = memberService.setInsert(memberVO, files);
		
		return "redirect:../";
		
	}
	

}
