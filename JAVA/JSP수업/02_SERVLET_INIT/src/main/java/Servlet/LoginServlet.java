package Servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



//URI : /login
//service함수를 를 이용해서 login 처리하세요
//유효성 검증 실패시 /WEB-INF/error.jsp 로 포워딩 (에러메시지도 같이보여주면 좋고..아니어도 패스)
//회원가입 성공시 Main.jsp 로 리다이렉트 
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// 1 파라미터
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		// 2 유효성
//		if(!isValid(username,password)) {
//			return ;
//		}
//		// 3 서비스
//		HttpSession session = req.getSession();
//		
//		if(!username.equals("aa")) {
//			req.getRequestDispatcher("/login.jsp").forward(req, resp);
//			return ;
//		} else if (!password.equals("aa")){
//			req.getRequestDispatcher("/login.jsp").forward(req, resp);
//			return;
//		}
//		
//		session.setAttribute("username", username);
//		session.setAttribute("password", password);
//		
//		// 4 뷰
//		resp.sendRedirect("Main.jsp");
//	}
//	
//	
//
//
	private boolean isValid(String username, String password) {
		if(username==null) {
			return false;
		} else if(password==null)
			return false;
		return true;
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();	// 메서드 요청사항 확인
		
		if(method!=null && method.contains("GET")) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return ;
		}
		// 1 파라미터
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// 2 유효성
		if(!isValid(username,password)) {
			return ;
		}
		// 3 서비스
		HttpSession session = req.getSession();
		
		if(!username.equals("aa")) {
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return ;
		} else if (!password.equals("aa")){
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		
		// 4 뷰
		resp.sendRedirect("Main.jsp");
		
	}

}
