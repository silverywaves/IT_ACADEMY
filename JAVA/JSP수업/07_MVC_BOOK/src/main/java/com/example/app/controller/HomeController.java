package com.example.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController implements SubController {

	@Override	// SubController 인터페이스의 추상 메서드 execute 오버라이드
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("HomeController's execute() invoke..");
		
		try {
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
			// .getRequestDispatcher("/WEB-INF/view/index.jsp") : 해당 경로의 JSP 페이지에 대한 RequestDispatcher 객체 가져옴
			// => WEB-INF 디렉토리는 직접적으로 웹 클라이언트에서 접근 불가 -> 보안성
			// .forward(request, response) : 현재 요청과 응답 객체를 /WEB-INF/view/index.jsp로 전달
			// -> index.jsp 페이지의 처리 결과가 현재 요청에 대한 응답으로 클라이언트에게 전송
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
