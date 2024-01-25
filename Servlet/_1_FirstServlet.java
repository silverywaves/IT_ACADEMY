package com.edu.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;	//서블릿을 작성하기 위해 상속받아야 하는 HttpServlet 클래스가 있는 패키지를 포함하는 소스
								//사용하려는 클래스가 java.lang 패키지에 포함되어있으면 import문 생략 가능
@WebServlet("/hello2")
public class _1_FirstServlet extends HttpServlet {	
	//HttpServlet : 서블릿이 웹상에서 HTTP 프로토콜을 이용해 서비스를 처리하기 위해 반드시 상속받아야 하는 클래스

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 실행됨!");		//init() 메소드 : 서블릿이 최초로 호출되었을 때 한번만 실행 -> 초기화 담당
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws
		ServletException, IOException  {
		System.out.println("service() 실행됨!");	//service() 메소드 : 클라이언트 요청이 있을때마다 매번 실행
	}											//				-> 서블릿 실행 요청이 있을때마다 실행되어야 하는 내용 구현
	
}
