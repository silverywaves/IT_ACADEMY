<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 사용자의 입력을 받기 위한 HTML 폼(form) 시작 -->
	<form action="02Main.jsp">	<!-- action : 사용자가 폼을 제출할 때 이동할 페이지 지정(02Main.jsp 페이지로 이동) -->
		<input type="text" name=num />	
		<input type="text" name=div />	  
		<input type="submit" />		<!-- 폼 제출 버튼(사용자가 입력한 정보와 함께 폼을 서버로 전송 -->
	</form>

</body>
</html>