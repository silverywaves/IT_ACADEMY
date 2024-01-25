package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/urlInfo")

public class _5_URLInfoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html;charset=EUC-KR");
		
		PrintWriter out = res.getWriter();
		
		//요청정보 헤더 첫번째 줄 : 요청방식, URI, HTTP 버전정보
		//서블릿이 소속된 웹 애플리케이션에 접근(URL에서 '포트번호/'다음 웹 애플리케이션이름 지정) -> 서브릿 페이지에 접근
		
		out.print("<html>");
		out.print("<head><title>Request 정보 출력 Servlet</title></head>");
		out.print("<body>");
		out.print("<h3>요청 방식과 프로토콜 정보</h3>");
		out.print("Request URI : " + req.getRequestURI() + "<br/>");
					//클라이언트가 요청한 문서정보 반환 : 요청정보 헤더 중 URI 추출
		out.print("Request URL : " + req.getRequestURL() + "<br/>");
					//클라이언트가 서비스를 요청한 문서의 전체 정보 반환 : 프로토콜부터 URI까지 완벽하게 URL 정보 반환
		out.print("Context Path : " + req.getContextPath() + "<br/>");
					//웹 애플리케이션의 경로 정보 반환 / Context Path : URL에서 웹 애플리케이션에 접근하는데 사용하는 정보
		out.print("Request Protocol : " + req.getProtocol() + "<br/>");
					//서비스를 처리하면서 사용되는 프로토콜의 구체적인 정보 반환
		out.print("Servlet Path : " + req.getServletPath() + "<br/>");
					//웹 애플리케이션을 루트 디렉터리(/)를 기준으로 서블릿 경로 반환
		out.print("</body></html>");
		out.close();
	}

}
