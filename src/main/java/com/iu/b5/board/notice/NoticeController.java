package com.iu.b5.board.notice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.b5.board.BoardVO;
import com.iu.b5.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	
	@GetMapping("insert")
	public String setInsert(@ModelAttribute BoardVO boardVO) throws Exception{
		
		return "board/insert";
		
	}
	
	@PostMapping("insert")
	public String setInsert(@Valid BoardVO boardVO, BindingResult bindingResult, MultipartFile [] files) throws Exception {
		
		
		if(bindingResult.hasErrors()) {
			return "board/insert";
		}
		
	 int result = noticeService.setInsert(boardVO, files); 
		
		
	//	int result = noticeService.setInsert(boardVO);
		
		return "redirect:./selectList";
	}
	
	
	@GetMapping("update")
	public ModelAndView setUpdate(BoardVO boardVO, ModelAndView modelAndView) throws Exception{
			boardVO	= noticeService.getSelectOne(boardVO);
			modelAndView.addObject("boardVO", boardVO);
			modelAndView.setViewName("board/update");
			return modelAndView;
			
	}
	
	@PostMapping("update")
	public String setUpdate(BoardVO boardVO) throws Exception{
		int result = noticeService.setUpdate(boardVO);
		
		return "redirect:./selectOne?num="+boardVO.getNum();
		
	}
	
	@GetMapping("delete")
	public String setDelete(BoardVO boardVO) throws Exception{
		int result	= noticeService.setDelete(boardVO);
		
		return "redirect:./selectList";
	}
	
	
	
	
	@GetMapping("selectOne")
	public ModelAndView getSelectOne(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = noticeService.getSelectOne(boardVO);
		
		mv.setViewName("board/select");
		mv.addObject("boardVO", boardVO);
		return mv;
	
	}
	
	@GetMapping("selectList")
	public ModelAndView getSelectList(Pager pager,ModelAndView mv) throws Exception{
		List<BoardVO> ar = noticeService.getSelectList(pager);
		mv.setViewName("board/list");
		mv.addObject("boardList", ar);
		mv.addObject("pager",pager);
		return mv;
		

	}
	
	
	
	
	
	
}
