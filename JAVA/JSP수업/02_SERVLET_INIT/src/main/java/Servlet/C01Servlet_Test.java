package Servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/Servlet_Test01")
public class C01Servlet_Test extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// 최초 1회 실행
		System.out.println("INIT");
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// 요청시마다 실행
		System.out.println("SERVICE");		
	}

	@Override
	public void destroy() {
		// 서블릿 내용 수정(코드수정) or 종료시 or 재시작시!!
		System.out.println("DESTROY");
	}

	
}
