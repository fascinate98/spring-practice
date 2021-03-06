package com.poscoict.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	//접근지정자 생략 그다음 리턴타입

	@Before("execution(public com.poscoict.aoptest.vo.ProductVo com.poscoict.aoptest.service.ProductService.find(String) )")
	public void beforeAdvice() {
		System.out.println("Before Advice");
	}
	
	@After("execution(* *..*.ProductService.find(..))")
	public void afteAdvice() {
		System.out.println("After Advice");
	}
	
	@AfterReturning("execution(* *..*.ProductService.find(..))")
	public void afterRetruningAdvice() {
		System.out.println("After Returning Advice");
	}
	
	@AfterThrowing(value = "execution(* *..*.*.*(..))", throwing ="ex")
	public void afterThrowingAdvice(Throwable ex) {
		System.out.println("After Throwing Advice " + ex);
	}
	
	@Around("execution(* *..*.ProductService.find(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		
		//befor
		System.out.println("arround(befor) adv");
		//pointCut method 실행
		//파라미터 변경
		Object[] params = {"Camera"};
		Object result = pjp.proceed(params);
		//after
		System.out.println("arround(after) adv");		
		
		return result;
	}
}
