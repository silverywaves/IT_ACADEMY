<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!-- 
    isErrorPage="true": 이 페이지가 에러 페이지임을 지정(예외가 발생할 경우 보여지는 에러 페이지)
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>ERROR PAGE</h1>
<!-- 표현식 => 예외 객체의 메시지를 HTML에 출력 -->
Error : <%=exception.getMessage() %>
<!-- exception.getMessage(): JSP에서 예외 처리 페이지에서 사용할 수 있는 내장 객체(발생한 예외의 메시지 가져옴) 
  	 isErrorPage="true" => 다른 JSP 페이지에서 예외가 발생하면 이 페이지가 에러 메시지와 함께 출력 -->
</body>
</html>