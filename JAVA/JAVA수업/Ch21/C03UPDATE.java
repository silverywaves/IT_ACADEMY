package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C03UPDATE {

	public static void main(String[] args) {
		// DB Conn Data
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/testDB";
		
		// JDBC 참조변수
		Connection conn = null;				// DBMS의 특정 DB연결을 위한 참조변수
		PreparedStatement pstmt = null;		// SQL 쿼리 전송용 참조변수
		ResultSet rs = null;				// SQL 쿼리 중 조회결과(ex.SELECT) 수신용 참조변수
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");		// 1 드라이브 파일을 메모리공간에 적재
			System.out.println("Driver Loading Success");
			conn = DriverManager.getConnection(url, id, pw);	// 2 객체 생성
			System.out.println("DB Connected");
			
			pstmt = conn.prepareStatement("update tbl_std set name=? where userid=?");
			pstmt.setString(1,"HI");
			pstmt.setString(2,"user1");
			
			int result = pstmt.executeUpdate();
			
			if(result>0) 
				System.out.println("UPDATE 성공");
			else
				System.out.println("UPDATE 실패");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {		
			try {
				pstmt.close();		// 자원 제거 - pstmt 먼저 해줘야함(stack 쌓이는 순서)
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();		// 자원 제거
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
