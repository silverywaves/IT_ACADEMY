<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- JSP 페이지에서 사용할 클래스와 패키지 import
	java.util.Scanner: 자바 표준 라이브러리의 Scanner 클래스를 import
	C03.*: C03 패키지 내의 모든 클래스를 import
-->
<%@page import="java.util.Scanner,C03.*" %>
<%	/* Scanner 객체, SimpleDto 객체 생성 */
	Scanner sc = new Scanner(System.in);	// 표준 입력(System.in)을 읽기 위한 Scanner 객체 생성
	// JSP는 웹 환경에서 실행 -> 표준 입력은 사용 X
/* 	C03.SimpleDto dto = new C03.SimpleDto("hong",44,"대구"); // import 이후 C03 적어줄 필요 없음 */ 
	SimpleDto dto = new SimpleDto("hong",44,"대구");	// SimpleDto 클래스의 객체 dto(이름이 "hong", 나이가 44, 주소가 "대구"인 데이터를를 담고있음) 생성 및 초기화
%>
<!-- 표현식 => 객체의 값을 HTML에 출력 -->
SIMPLEDTO : <%=dto %>

</body>
</html>