package com.iu.b5.aop.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card {
	
	//@Before("execution(* com.iu.b5.aop.transfer.Transfer.*(..))")
	//@AfterThrowing("execution(* com.iu.b5.aop.transfer.Transfer.*(..))")
	@Around("execution(* com.iu.b5.aop.transfer.Transfer.*(..))")
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("타기전 카드체크");
		Object obj = joinPoint.proceed(); // 핵심로직실행
		System.out.println("내릴때 카드체크");
		
		return obj;
	}
	

}
