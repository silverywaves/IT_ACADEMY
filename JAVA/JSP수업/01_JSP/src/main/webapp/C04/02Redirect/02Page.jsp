<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>02PAGE</h1>
	<%
		// 1. userid와 pwd 파라미터 값
		String userid =request.getParameter("userid");
		String pwd =request.getParameter("pwd");
		// 2. 가져온 파라미터 값을 콘솔에 출력
		System.out.println("=============================");
		System.out.println("[02Page] userid : "+userid);
		System.out.println("[02Page] pwd : "+pwd);
		System.out.println("=============================");
		
		// 3. 02page라는 이름의 속성을 설정
		request.setAttribute("02page", "02Value");
		
		// 4. 03Page.jsp로 페이지 Redirect -> 제어 전달
		response.sendRedirect("03Page.jsp");	
		// 03page 이동하라고 하는 과정에서 새로운 request 생성(01Start로 응답->01Start에서 03으로 재요청)

	%>
	
	
</body>
</html>