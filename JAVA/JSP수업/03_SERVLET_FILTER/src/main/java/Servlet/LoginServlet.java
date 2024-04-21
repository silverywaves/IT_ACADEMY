package Servlet;

import java.io.IOException;

import Type.Role;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {	// HttpServlet 상속

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 모든 HTTP 요청 메서드(GET, POST, PUT, DELETE 등)에 대해 호출됨
		
		String method = req.getMethod();
		if(method.contains("GET")) {	// HTTP 요청 메서드가 GET일 경우
			System.out.println("GET /login");	//  로그를 출력
			req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);	// /WEB-INF/view/login.jsp로 포워딩
			return ;
		}
		
		// 1 파라미터 받기
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// 2 유효성 검사
		if(!isValid(username,password)) {
			return ;
		}
		
		// 3 서비스실행(비즈니스로직)
//		if(!username.equals("user1")) {
//			return ;
//		}
//		if(!password.equals("1234")) {
//			return ;
//		}
		// 세션을 생성하거나 기존 세션을 가져와 username과 role을 세션에 저장
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
		session.setAttribute("role", Role.ROLE_MANAGER);
		
		// 4 뷰
		resp.sendRedirect(req.getContextPath() + "/main");	// 요청이 처리된 후 /main 경로로 리다이렉트
		
	}

	private boolean isValid(String username, String password) {
		return true;
	}

}
