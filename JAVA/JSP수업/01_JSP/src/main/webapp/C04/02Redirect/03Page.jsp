<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>03PAGE</h1>

	<%
	String userid = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	// request 객체에서 "02page"라는 이름으로 설정된 속성 값을 가져와 value 변수에 저장
	String value = (String)request.getAttribute("02page");
	// request.getAttribute("02page")에서 반환되는 값은 Object 타입 -> 원하는 타입으로 형변환을 해야 실제 값에 접근 가능
	
	System.out.println("=============================");
	System.out.println("[03Page] userid : " + userid);
	System.out.println("[03Page] pwd : " + pwd);
	System.out.println("[03Page] 02Page : " + value);
	System.out.println("=============================");
	
	request.setAttribute("03page", "03Value");
	
	//Redirect
	//response.sendRedirect("04Page.jsp");
	%>
	

</body>
</html>