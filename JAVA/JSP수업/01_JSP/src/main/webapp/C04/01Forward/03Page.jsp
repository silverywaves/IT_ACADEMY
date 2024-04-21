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
		// 1. userid와 pwd 파라미터 값
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		// 2. 파라미터 값 콘솔에 출력
		System.out.println("---------03Page---------");
		System.out.println("userid : " + userid);
		System.out.println("pwd : " + pwd);
		System.out.println("---------03Page---------");
		
		// 3. 02Page.jsp에서 전달된 속성 값을 가져와 출력
		String Page02_value = (String)request.getAttribute("02Page");	// getAttribute 기본적으로 object 타입 -> 다운
		// 4. 04Page.jsp로 페이지 Forwarding -> 제어 전달
		request.getRequestDispatcher("04Page.jsp").forward(request,response);
		%>
		<!-- 5. userid, pwd, Page02_value 값 출력 --> 
		USERID : <%=userid %><br/>
		PWD : <%=pwd %><br/>
		Page02_VALUE : <%=Page02_value %><br/>
	
</body>
</html>