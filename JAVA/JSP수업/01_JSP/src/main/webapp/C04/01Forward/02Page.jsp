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
		// 1. userid와 pwd 파라미터 값 추출
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		// 2. 가져온 파라미터 값을 콘솔에 출력
		System.out.println("---------02Page---------");
		System.out.println("userid : " + userid);
		System.out.println("pwd : " + pwd);
		System.out.println("---------02Page---------");
		
		// 3. 새로운 속성값을 Request에 추가
		request.setAttribute("02Page","02Page_Value");
		
		// 4. 03Page.jsp로 페이지 Forwarding
		request.getRequestDispatcher("03Page.jsp").forward(request,response);	
		// request, response는 초기화X 그대로 전달(url 안바뀜, forwarding 끝날때까지 공유상태)
		 
		
		
	%>


</body>
</html>