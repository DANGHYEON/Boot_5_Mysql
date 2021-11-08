package com.iu.b5.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b5.board.BoardFileVO;
import com.iu.b5.board.BoardService;
import com.iu.b5.board.BoardVO;
import com.iu.b5.util.FileManager;
import com.iu.b5.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	
	//DI IOC
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Autowired
	private FileManager fileManager;

	@Override
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {
		// TODO Auto-generated method stub
		//fileManager.getUseServletContext("/upload/notice/",files[0]);
		//fileManager.getUseResourceLoader("upload/notice/", files[0]);
		//fileManager.getUseClassPathResource("upload/notice/", files[0]);
		int result = noticeMapper.setInsert(boardVO);
		
		for(MultipartFile multipartFile:files) {
			
			if(multipartFile.getSize()==0L) {
				continue;
			}
			
			BoardFileVO boardFileVO = new BoardFileVO();
			boardFileVO.setNum(boardVO.getNum());
			
			String fileName = fileManager.getUseServletContext("/upload/notice/",multipartFile);
			boardFileVO.setFileName(fileName);
			boardFileVO.setOriName(multipartFile.getOriginalFilename());
			noticeMapper.setFileInsert(boardFileVO);
		}
		
		return result;
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.setUpdate(boardVO);
	}

	@Override
	public int setHtUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.setHtUpdate(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.setDelete(boardVO);
	}

	@Override
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.getSelectOne(boardVO);
	}

	@Override
	public List<BoardVO> getSelectList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeRow();
		//1. 총 글의 갯수
		Long totalCount = noticeMapper.getTotalCount(pager);
		pager.makeNum(totalCount);
		
		return noticeMapper.getSelectList(pager);
	}
	
	
	
	

}
