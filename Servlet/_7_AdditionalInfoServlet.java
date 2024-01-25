package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/addInfo")		// 어노테이션으로 서블릿 요청했지만 web.xml로 설정해도 ok
public class _7_AdditionalInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = res.getWriter();

			// 질의(Query) 문자열이나 추가 정보 추출 메소드 확인
		
		out.print("<html>");
		out.print("<head><title>Request 정보 출력</title></head>");
		out.print("<body>");
		
		out.print("<h3>추가적인 요청 정보</h3>");
		out.print("Request Method : " + req.getMethod() + "<br/>");
			// 클라이언트의 요청 방식 확인 -> 명시적으로 요청방식을 지정하지 않으면 GET 으로 요청됨
		out.print("Path Info : " + req.getPathInfo() + "<br/>");
		out.print("Path Translated : " + req.getPathTranslated() + "<br/>");
		out.print("Query String : " + req.getQueryString() + "<br/>");
			// 요청 URL 에서 ? 기 다음에 있는 문자열 전체를 추출하여 반환
		out.print("Content Length : " + req.getContentLength() + "<br/>");
		out.print("Content Type : " + req.getContentType() + "<br/>");
			// GET 방식은 서비스 요청시 전달하는 데이터를 요청정보의 몸체가 아닌 헤더에 포함해서 넘김
			// => 몸체에는 데이터가 없음 => 몸체 길이 = -1 / 몸체 문서타입 = null
		out.print("</body></html>");
		out.close();
	}
}
