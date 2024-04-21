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
	
	<form action="${pageContext.request.contextPath}/login" method="post">
	<!-- HTML 폼을 시작, 액션 URL : ${pageContext.request.contextPath}/login, method="post" : 폼 데이터를 POST 방식으로 서버에 전송 -->
		<input type="text" name="username" /> <br />
		<input type="text" name="password" /> <br />
		<button>로그인</button>
	</form>

</body>
</html>