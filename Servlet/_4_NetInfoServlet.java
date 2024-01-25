package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/netInfo")

public class _4_NetInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = res.getWriter();
		
		out.print("<html>");
		out.print("<haed><title>Request 정보 출력 Servlet</title></head>");
		out.print("<body>");
		out.print("<h3>네트워크 관련 요청 정보</h3>");
		out.print("Request Scheme : " + req.getScheme() + "<br/>");
					//클라이언트가 웹서버에 서비스를 요청할 때 사용한 프로토콜 이름을 반환
		out.print("Server Name : " + req.getServerName() + "<br/>");
					//서버의 호스트 이름 반환. 서버에 별도의 호스트 이름이 없을 때는 IP주소 반환
		out.print("Server Address : " + req.getLocalAddr() + "<br/>");
					//클라이언트로부터 서비스를 요청받은 서버의 IP주소 반환
		out.print("Server Port : " + req.getServerPort() + "<br/>");
					//클라이언트의 서비스를 요청받아 처리하는 서버의 포트 번호 반환
		out.print("Client Address : " + req.getRemoteAddr() + "<br/>");
					//서비스를 요청한 클라이언트의 IP주소 반환
		out.print("Client Host : "+ req.getRemoteHost() + "<br/>");
					//서비스를 요청한 클라이언트의 호스트 이름 반환. 호스트 이름이 없을 때는 IP주소 반환
		out.print("Client Port : " + req.getRemotePort() + "<br/>");
					//서비스를 요청한 클라이언트의 소스 포트 번호 반환
		out.print("</body></html>");
		out.close();
		
	}
	

}
