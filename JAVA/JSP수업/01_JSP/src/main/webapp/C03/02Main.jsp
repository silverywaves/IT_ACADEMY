<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="02Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//문자열
	String num = request.getParameter("num");	// HTTP 요청에서 num이라는 이름으로 전달된 파라미터 값을 가져와 num 변수에 저장
	String div = request.getParameter("div");	// HTTP 요청에서 div라는 이름으로 전달된 파라미터 값을 가져와 div 변수에 저장
	int n = Integer.parseInt(num);	// 문자열 형태의 num 변수 값을 정수 형태로 변환하여 n 변수에 저장
	int d = Integer.parseInt(div);	// 문자열 형태의 div 변수 값을 정수 형태로 변환하여 d 변수에 저장
	
%>
<!-- n 변수의 값에서 d 변수의 값을 나눈 결과 출력(d==0 이면 에러 발생->에러 페이지(02Error.jsp)로 이동) -->
RESULT : <%=(n/d) %><br>

</body>
</html>