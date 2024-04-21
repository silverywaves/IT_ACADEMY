package Servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/join.do")
public class C04Servlet_Test extends HttpServlet {
	
	// GET : 회원가입 양식 보여주기(회원가입 페이지로 이동)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET / Join do");
		
		req.getRequestDispatcher("/WEB-INF/Join.jsp").forward(req,resp);	// Join.jsp로 포워딩
		// Join.jsp는 /WEB-INF 폴더에 위치 -> 직접적인 접근을 막기 위해 이렇게 사용
	}
	
	// POST : 회원가입 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Post / Join do");
		
		// 1 파라미터 받기
		String username = req.getParameter("username");
		String password = req.getParameter("password");
			
		// 2 유효성 체크
		if(!isValid(username,password)) {
			return ;
		}
			
		// 3 서비스 실행
		HttpSession session = req.getSession();
		
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		
		// 4 뷰 전달(Forward / Redirect)
		resp.sendRedirect("Main.jsp");	// Main.jsp로 리다이렉트
	}

	// username과 password의 유효성을 체크
	private boolean isValid(String username, String password) {
		return true;	// 현재는 항상 true를 반환 -> 제로 유효성 체크는 수행x
	}

	// 
}
