package DBConn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Dbtest_jdbc")	 // 서블릿 클래스를 /Dbtest_jdbc URL 패턴에 매핑
public class C01JDBC extends HttpServlet {	// C01JDBC 클래스 선언, HttpServlet 클래스 상속

	// Connection, PreparedStatement, ResultSet 객체를 참조하기 위한 멤버 변수 선언
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 데이터베이스 연결 정보를 저장하기 위한 url, id, pw 변수 선언
	private String url;
	private String id;
	private String pw;
	
	// init 오버라이드(서블릿 초기화시 호출)
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	// MySQL JDBC 드라이버 로드
			// 데이터베이스 연결 정보 초기화
			url = "jdbc:mysql://localhost/bookdb";
			id="root";
			pw="1234";
			// 데이터베이스 연결
			conn = DriverManager.getConnection(url,id,pw);
			// 연결된 데이터베이스 정보를 콘솔에 출력
			System.out.println("Connection conn : " + conn);
		} catch (Exception e) {		// 예외가 발생할 경우 예외 정보 출력
			e.printStackTrace();
		}
	}

	// service 오버라이드(클라이언트 요청 처리)
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();		// PrintWriter로 응답 보내기
		out.println("DB CONNECTION : " + conn);	// 데이터베이스 연결 상태 출력
	}
	
	/*	[데이터베이스에 연결]
	 * 	1. init()에서 MySQL JDBC 드라이버 로드 -> 데이터베이스에 연결
	 * 	2. service()에서 클라이언트 요청 처리 -> 현재 데이터베이스 연결 상태 출력
	 * */	
	
	
}
