package Servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//URI : /join
//doGet / doPost 를 이용해서 Join 처리하세요
//유효성 검증 실패시 /WEB-INF/error.jsp 로 포워딩
//회원가입 성공시 /login 으로 리다이렉트 
@WebServlet("/join")
public class JoinServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/Join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1 파라미터
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// 2 유효성
		if(!isValid(username,password)) {
			// req.setAttribute("msg", "Validation Check Error");
			// req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req,resp);
			return ;
		}
		
		// 3 서비스
		HttpSession session = req.getSession();
		
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		
		// 4 뷰	// WEB-INF 내 페이지로 리다이렉트하는경우 => WEB-INF 이동불가 -> 매핑된 uri 경로 잡아줘야함
		resp.sendRedirect("login.jsp");
		// req.getContextPath() + "/login"
	}

	private boolean isValid(String username, String password) {
		if(username==null)
			return false;
		else if(password==null)
			return false;
		return true;
	}

}
