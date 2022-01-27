package com.poscoict.helloweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor01 implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//먼저 실행됨 리턴 펄스면 뒤로안감 트루를 해야 컨트롤로 감 펄스면 밑에 안감
		System.out.println("MyInterceptor01.preHandle called");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//컨트롤 다음에 비지니스로직 흐른ㄷ ㅏ음 에
		System.out.println("MyInterceptor01.postHandle called");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// view resolver에서 view 나간다음에 싫행 
		System.out.println("MyInterceptor01.afterCompletion called");
	}

}
