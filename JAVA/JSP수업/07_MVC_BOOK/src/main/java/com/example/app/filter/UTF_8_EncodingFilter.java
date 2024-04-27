package com.example.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UTF_8_EncodingFilter implements Filter {
	// UTF_8_EncodingFilter : 요청과 응답의 문자 인코딩을 UTF-8로 설정하는 역할
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("UTF_8_EncodingFilter start---");
		// 전
		req.setCharacterEncoding("UTF-8");	// 요청 문자 인코딩을 UTF-8로 설정
		resp.setCharacterEncoding("UTF-8");	// 응답 문자 인코딩을 UTF-8로 설정
		resp.setContentType("text/html; charset=UTF-8");	// 컨텐츠 타입을 HTML로 설정
		
		chain.doFilter(req, resp);	// FilterChain의 doFilter 메서드 호출 -> 요청을 다음 필터로 전달 or 최종적으로 서블릿으로 전달
		
		// 후
		System.out.println("UTF_8_EncodingFilter end-----");		
	}

}
