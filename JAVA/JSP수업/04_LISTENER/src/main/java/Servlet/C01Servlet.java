package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Test1")	// C01Servlet 클래스는 웹 서블릿으로 동작하도록 지정 + /Test1 경로로 매핑
public class C01Servlet extends HttpServlet {	// 01Servlet 클래스는 HttpServlet 클래스를 상속받아 웹 서블릿을 구현

	@Override	// service() : 클라이언트의 요청을 처리하는 메서드
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();	// HttpServletResponse 객체에서 PrintWriter를 가져와 출력 준비
		String val = (String)req.getServletContext().getAttribute("CTX_ATTR1");	// ServletContext에서 이름이 CTX_ATTR1인 속성 값 추출
		
		out.println("<h1>ServletContextListener TEST</h1>");	// HTML 태그 사용 -> 제목 출력 
		out.println("CTX_ATTR1 : " + val);	// CTX_ATTR1 속성 값 출력
	}
	
}
