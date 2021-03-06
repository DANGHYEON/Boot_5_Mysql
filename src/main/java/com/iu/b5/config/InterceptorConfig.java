package com.iu.b5.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.b5.interceptor.NoticeInterceptor;
import com.iu.b5.interceptor.TestInterceptor;
import com.iu.b5.interceptor.UpdateInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
	private TestInterceptor testInterceptor;
	
	@Autowired
	private NoticeInterceptor noticeInterceptor;
	
	@Autowired
	private UpdateInterceptor updateInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// 1. 적용할 Interceptor 등록
		registry.addInterceptor(testInterceptor)
		// 2. Interceptor를 사용할 URL
				.addPathPatterns("/notice/*")
				.addPathPatterns("/member/*")
		// 3. Interceptor를 제외할 URL
				.excludePathPatterns("/qna/*")
				.excludePathPatterns("/notice/selectOne");
		
		
		/*
		 * registry.addInterceptor(noticeInterceptor) .addPathPatterns("/notice/*")
		 * .excludePathPatterns("/notice/selectList")
		 * .excludePathPatterns("/notice/selectOne");
		 */
		
		
		registry.addInterceptor(updateInterceptor)
				.addPathPatterns("/notice/update");
		
		
		
	}
	

}
