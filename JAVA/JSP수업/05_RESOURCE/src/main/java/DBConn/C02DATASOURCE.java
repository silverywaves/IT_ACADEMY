package DBConn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Dbtest_dataSource")	// 서블릿 클래스를 /Dbtest_dataSource URL 패턴에 매핑
public class C02DATASOURCE extends HttpServlet {	// C02DATASOURCE 클래스  선언, HttpServlet 클래스 상속
	// Connection, PreparedStatement, ResultSet 객체를 참조하기 위한 멤버 변수 선언
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	// 데이터베이스 연결 정보를 저장하기 위한 url, id, pw 변수 선언
	private String url;
	private String id;
	private String pw;
	// dataSource 꺼내오기 => DataSource 객체를 참조하기 위한 멤버 변수 선언
	private DataSource dataSource;
	
	// init
	@Override
	public void init() throws ServletException {
		try {
			Context initContext  = new InitialContext();	// 초기 컨텍스트 생성
			Context envContext = (Context)initContext.lookup("java:/comp/env");	// 환경 컨텍스트 검색
			dataSource = (DataSource)envContext.lookup("jdbc/MysqlDB");	// JNDI 이름 "jdbc/MysqlDB"를 사용하여 DataSource 검색
			conn = dataSource.getConnection();	// DataSource를 사용하여 데이터베이스 연결
			System.out.println("Connection : " + conn);	// 연결된 데이터베이스 정보를 콘솔에 출력
			
		} catch(Exception e) {	// 예외가 발생할 경우 예외 정보 출력
			e.printStackTrace();
		}
	}

	// service
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("DB CONNECTION : " + conn);
	}
	
	/*	[데이터베이스에 DataSource를 사용하여 연결]
	 * 	1. init()에서 JNDI를 통해 DataSource 검색 -> 데이터베이스에 연결
	 * 	2. service()에서 클라이언트 요청 처리 -> 현재 데이터베이스 연결 상태 출력
	 * */	
}
