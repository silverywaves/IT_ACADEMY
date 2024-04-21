<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- java.sql 패키지의 모든 클래스 import(JDBC 관련 클래스들 사용하기 위함) -->
	<%@page import="java.sql.*" %>	
	<%
		Class.forName("com.mysql.cj.jdbc.Driver");	// Class.forName : MySQL JDBC 드라이버 로드
		String url = "jdbc:mysql://localhost/bookdb";	// 데이터베이스의 URL을 문자열로 선언(localhost 서버의 bookdb 데이터베이스에 연결)
		Connection conn = DriverManager.getConnection(url,"root","1234"); // DriverManager.getConnection(URL, 사용자 이름, 비밀번호) => 데이터베이스에 연결
		System.out.println("Connection conn : " + conn);	// 연결된 Connection 객체 정보를 콘솔에 출력
	%>
	<!-- JSP 표현식 => 연결된 Connection 객체의 정보를 웹 페이지에 출력 -->
	Connection : <%=conn %> <br />
	
	<!-- [MySQL 데이터베이스에 직접적으로 연결]
		1. MySQL JDBC 드라이버 로드
		2. 데이터베이스 URL, 사용자 이름, 비밀번호를 사용하여 데이터베이스에 연결
		3. 연결된 Connection 객체 정보를 콘솔에 출력하고 웹 페이지에 출력
	 -->

</body>
</html>