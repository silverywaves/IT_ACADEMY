<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	스클립틀릿 : JSP -> Servlet으로 변환될때 Servlet내의 Service라는 함수안에서 처리되는 로직
	Service라는 함수내에서 동작하기때문에 지역변수나 반복/분기처리 가능
	but 함수를 벗어나면 지역변수는 소멸되기 때문에 요청시(ex.새로고침) 상태값 초기화
	Service 함수 내 또 Service 함수 생성 불가
 -->
 <%
 	String str1 = "Hello1";
 	String str2 = "Hello2";
 	String str3 = str1 + str2;
 	int a = 0;	// 지역변수
 	/* for(int i=0;i<10;i++){
 		a++;
 		System.out.println("HELLO WORLD " + i);
 	} */
 %>
<%=str1 %> <br />
<%=str2 %> <br />
<%=str3 %> <br />
<%=a %> <br />
</body>
</html>