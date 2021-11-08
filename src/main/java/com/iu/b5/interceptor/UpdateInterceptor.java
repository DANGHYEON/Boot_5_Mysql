package com.iu.b5.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iu.b5.board.BoardVO;
import com.iu.b5.member.MemberVO;

@Component
public class UpdateInterceptor implements HandlerInterceptor {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		
	   BoardVO boardVO	= (BoardVO)modelAndView.getModelMap().get("boardVO");
		
	   if(!memberVO.getId().equals(boardVO.getWriter())) {
		   
		   modelAndView.addObject("msg", "작성자가 아닙니다");
		   modelAndView.addObject("path", "./selectOne?num="+boardVO.getNum());
		  modelAndView.setViewName("./common/result");
		   
	   }
		
	
	   
		
	}
	
	
	

}
