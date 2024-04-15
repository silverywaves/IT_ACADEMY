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
		String userid =request.getParameter("userid");
		String pwd =request.getParameter("pwd");
		System.out.println("=============================");
		System.out.println("[02Page] userid : "+userid);
		System.out.println("[02Page] pwd : "+pwd);
		System.out.println("=============================");
		request.setAttribute("02page", "02Value");
		
		//Redirect
		response.sendRedirect("03Page.jsp");	// 03page 이동하라고 하는 과정에서 새로운 request 생성(01Start로 응답->01Start에서 03으로 재요청)

	%>
	
	
</body>
</html>