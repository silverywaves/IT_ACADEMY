package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C05SELECT {

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
			
			pstmt = conn.prepareStatement("select * from tbl_data");
			
			rs = pstmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					System.out.print(rs.getString(1)+" ");
					System.out.print(rs.getString(2)+" ");
					System.out.print(rs.getString(3)+" ");
					System.out.print(rs.getString("관리구역명")+" ");
					System.out.println();
					
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {		
			try {
				rs.close();			// 자원 제거
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();		// 자원 제거
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
