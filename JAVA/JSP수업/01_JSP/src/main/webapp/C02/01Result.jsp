<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%	/* request.getParameter() 사용 -> 사용자가 이전 페이지에서 입력한 URL 파라미터 값을 가져와 변수에 저장 */
		String username = request.getParameter("username");	// "username" 이름의 파라미터 값을 가져와 username 변수에 저장
		String password = request.getParameter("password");	// "password" 이름의 파라미터 값을 가져와 password 변수에 저장
		String bgColor = request.getParameter("bg");		//  "bg" 이름의 파라미터 값을 가져와 bgColor 변수에 저장
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body bgcolor=<%=bgColor %>>	<!-- <body> 태그의 bgcolor 속성에 스크립틀릿 사용 => bgColor 변수 값을 동적으로 설정(사용자가 입력한 "bg" 파라미터 값) -->
	<!-- 표현식 => username, password 변수값 출력(사용자가 입력한 "username"과 "password" 파라미터 값) -->
	USERNAME : <%=username %> <br />
	PASSWORD : <%=password %> <br />
	
</body>
</html>