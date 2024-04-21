package Servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login.do")
public class C03Servlet_Test extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HTTP GET 요청을 처리하는 메서드
		System.out.println("doGet");
		// 1 파라미터 받기
		String username = req.getParameter("username");
		String password = req.getParameter("password");
			
		// 2 유효성 체크
		if(!isValid(username,password)) {
			return ;
		}
			
		// 3 서비스 실행
		// session 꺼내기
		HttpSession session = req.getSession();
		
		if(!username.equals("user1")) {	// username이 "user1"이 아닐 경우
			session.setAttribute("msg","USERID를 올바르게 입력하세요");	// 메시지를 세션에 저장
			req.getRequestDispatcher("Request_Get.jsp").forward(req, resp);	// Request_Get.jsp로 포워딩
			return ;
		}
		if(!password.equals("1234")) {	// password가 "1234"가 아닐 경우
			session.setAttribute("msg","PASSWORD가 잘못 입력되었습니다");	// 메시지를 세션에 저장
			req.getRequestDispatcher("Request_Get.jsp").forward(req, resp);	// Request_Get.jsp로 포워딩
			return ;
		}
		// 유효한 경우 username과 password를 세션에 저장
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		
		// 4 뷰 전달(Forward / Redirect)
		resp.sendRedirect("Main.jsp");	// Main.jsp로 리다이렉트
	}

	// username과 password가 null인지 체크하는 유효성 검사 메서드
	private boolean isValid(String username, String password) {
		if(username==null)
			return false;
		else if(password==null)
			return false;
		return true;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost");
		// 1 파라미터 받기
		String username = req.getParameter("username");
		String password = req.getParameter("password");
			
		// 2 유효성 체크
		if(!isValid(username,password)) {
			return ;
		}
			
		// 3 서비스 실행
		// session 꺼내기
		HttpSession session = req.getSession();
		
		if(!username.equals("user1")) {
			session.setAttribute("msg","USERID를 올바르게 입력하세요");
			req.getRequestDispatcher("Request_Get.jsp").forward(req, resp);
			return ;
		}
		if(!password.equals("1234")) {
			session.setAttribute("msg","PASSWORD가 잘못 입력되었습니다");
			req.getRequestDispatcher("Request_Get.jsp").forward(req, resp);
			return ;
		}
		
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		
		// 4 뷰 전달(Forward / Redirect)
		resp.sendRedirect("Main.jsp");
	}

//	@Override
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		System.out.println("service");
//	}	// 위 두 함수와 같이 사용 불가(ServletRequest가 상위-> doGet,doPost 사용하려면 형변환 필요)

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	
	
}
