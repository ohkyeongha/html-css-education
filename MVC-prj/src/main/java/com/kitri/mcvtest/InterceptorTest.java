package com.kitri.mcvtest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class InterceptorTest implements HandlerInterceptor{
	//화면 재정의가 안되어 직접 타이핑
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) {
		System.out.println("prehandle 함수 호출");
		return true;
	}
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) {
		System.out.println("post 함수 호출");
//		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e){
		System.out.println("after 함수 호출");
//		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	
	
}
