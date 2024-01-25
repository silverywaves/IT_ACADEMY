package com.edu.test;


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/third")
public class _3_ThirdServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
	
		resp.setContentType("text/html;charset=UTF-8");		//문서타입과 문자셋을 응답정보 헤더에 설정. 
															//resp.getWriter()를 호출하기 전에 호출해야 적용됨!!
															//세미콜론(;) 기준 앞에는 문서타입, 뒤에는 charset=문자셋
		PrintWriter out = resp.getWriter();
		out.print("<h1>좋은 하루!</h1>");
		out.close();
	}
	
}
