package com.iu.b5.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.b5.board.BoardVO;
import com.iu.b5.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "Qna";
	}
	
	
	@GetMapping("insert")
	public String setInsert() throws Exception{
		
		return "board/insert";
		
	}
	
	@PostMapping("insert")
	public String setInsert(BoardVO boardVO,  MultipartFile [] files) throws Exception {
		int result = qnaService.setInsert(boardVO, files);
		
		return "redirect:./selectList";
	}
	
	
	@GetMapping("update")
	public ModelAndView setUpdate(BoardVO boardVO, ModelAndView modelAndView) throws Exception{
			boardVO	= qnaService.getSelectOne(boardVO);
			modelAndView.addObject("boardVO", boardVO);
			modelAndView.setViewName("board/update");
			return modelAndView;
			
	}
	
	@PostMapping("update")
	public String setUpdate(BoardVO boardVO) throws Exception{
		int result = qnaService.setUpdate(boardVO);
		
		return "redirect:./selectOne?num="+boardVO.getNum();
		
	}
	
	@GetMapping("delete")
	public String setDelete(BoardVO boardVO) throws Exception{
		int result	= qnaService.setDelete(boardVO);
		
		return "redirect:./selectList";
	}
	
	
	
	
	@GetMapping("selectOne")
	public ModelAndView getSelectOne(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = qnaService.getSelectOne(boardVO);
		
		mv.setViewName("board/select");
		mv.addObject("boardVO", boardVO);
		return mv;
	
	}
	
	@GetMapping("selectList")
	public ModelAndView getSelectList(Pager pager,ModelAndView mv) throws Exception{
		List<BoardVO> ar = qnaService.getSelectList(pager);
		mv.setViewName("board/list");
		mv.addObject("boardList", ar);
		return mv;
		

	}
	
	

}
