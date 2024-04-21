<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>LOGIN</h1>
	<form action="${pageContext.request.contextPath}/login">
		<!-- 
			action: 폼 데이터가 전송될 URL 지정
			${pageContext.request.contextPath}/login : 현재 웹 애플리케이션의 컨텍스트 경로를 기반으로 "/login" 경로로 데이터를 전송
		 -->
		<input type="text" name="username" />
		<input type="text" name="password" />
		<button>요청</button>
	</form>
</body>
</html>