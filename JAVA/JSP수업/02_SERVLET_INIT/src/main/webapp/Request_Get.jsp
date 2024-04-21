<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div>
		MESSAGE : ${msg}
		<!-- ${msg}: EL(Expression Language) 사용 -> msg라는 속성값 출력
				msg : 서버에서 전달받은 메시지 -->
	</div>
	<form action="${pageContext.request.contextPath}/login.do">	<!-- 로그인 정보 입력 -->
	<!-- ${pageContext.request.contextPath}/login.do : 로그인 요청을 처리할 서블릿 또는 JSP 경로 설정 -->
		<input type="text" name="username" />
		<input type="text" name="password" />
		<button>요청</button>
	</form>
	
	<%	// 폼을 제출한 후 세션에서 msg 속성 제거
		session.removeAttribute("msg");	// removeAttribute("msg") : 세션에서 msg 속성 제거
	%>

</body>
</html>