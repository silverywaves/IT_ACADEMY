package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Test2")
public class C02Servlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		// ServletContext에 CTX_ATTR2라는 이름으로 "VAL2"라는 값을 설정
		req.getServletContext().setAttribute("CTX_ATTR2", "VAL2");
		
		// ServletContext에서 CTX_ATTR1와 CTX_ATTR2 속성 값 추출
		String val = (String)req.getServletContext().getAttribute("CTX_ATTR1");
		String val2 = (String)req.getServletContext().getAttribute("CTX_ATTR2");
		
		out.println("<h1>ServletContextListener TEST2</h1>");
		out.println("CTX_ATTR1 : " + val);
		out.println("CTX_ATTR2 L " + val2);
	}
	
}
