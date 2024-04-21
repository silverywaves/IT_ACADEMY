<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Main Page</h1>
	USERNAME : ${username} <br />
	<!-- ${username}: EL(Expression Language) 사용 -> username이라는 속성값 출력 -->
	<!-- EL : JSP에서 객체의 속성값이나 맵의 키값 등을 쉽게 출력할 수 있는 언어 -->
	PASSWORD : ${password} <br />
	<!-- ${password}: EL 사용 -> password라는 속성값 출력 -->
	
	<!-- 
		사용자의 username, password 정보를 화면에 출력
		EL을 사용하여 서버로부터 받은 username, password 값 출력
		페이지를 로드할 때 서버에서 전달받은 username, password 값 출력
	 -->
</body>
</html>