<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	<%	/* request.getParameter() 사용 -> URL 파라미터 값을 가져와 변수에 저장 */
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String bgColor = request.getParameter("bg");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor=<%=bgColor %>>
	<!-- 스크립틀릿을 통해 전달받은 URL 파라미터 값 출력 -->
	USERNAME : <%=username %> <br />
	PASSWORD : <%=password %> <br />
	
	<!-- EL(Expression Language)을 사용하여 파라미터 값을 가져옴 -->
	<!-- param 객체 : 현재 요청에 전달된 모든 파라미터 값을 맵 형태로 보유 -->
	EL_TEST : ${param.username}
	EL_TEST : ${param.password}
	
</body>
</html>