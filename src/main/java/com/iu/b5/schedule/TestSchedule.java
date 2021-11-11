package com.iu.b5.schedule;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iu.b5.board.BoardVO;
import com.iu.b5.board.notice.NoticeMapper;

@Component
public class TestSchedule {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	
	//@Scheduled(cron = "*/30 * * * * *")
	public void cronScheduleTest() throws Exception {
		
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("test");
		boardVO.setContents("test");
		boardVO.setWriter("test");
		noticeMapper.setInsert(boardVO);
		Calendar ca = Calendar.getInstance();
		System.out.println("Cron:" + ca.getTime());
		
	}
	
	
	
	
	//@Scheduled(fixedRate = 2000, initialDelay = 2000 )
	public void fixRateScheduleTest() throws Exception{
		Calendar calendar = Calendar.getInstance();
		Thread.sleep(3000);
		System.out.println(calendar.getTime());
	}
	
	//@Scheduled(fixedDelay = 3000, initialDelay = 3000)
	public void fixDelayScheduleTest() throws Exception{
		Calendar calendar = Calendar.getInstance();
		System.out.println("FixDelay : "+calendar.getTime());
	}
	

}
