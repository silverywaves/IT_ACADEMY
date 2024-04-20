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
 <%	/* 변수와 로직 정의 */
 	String str1 = "Hello1";		// str1 변수에 "Hello1" 문자열 할당
 	String str2 = "Hello2";		// str2 변수에 "Hello2" 문자열 할당
 	String str3 = str1 + str2;	// str1과 str2의 값을 연결하여 str3 변수에 저장
 	int a = 0;	// 지역변수 a 선언, 초기값으로 0 할당
 	for(int i=0;i<10;i++){		// for 반복문 => 0~9 반복
 		a++;					// a 변수의 값 1 증가
 		System.out.println("HELLO WORLD " + i);	// 콘솔에 "HELLO WORLD" + 현재 반복 횟수 (i) 출력
 	}
 %>
 <!-- 스크립틀릿에서 정의한 변수들 값 출력 -->
<%=str1 %> <br />	<!-- str1 변수값 출력 // 결과 : Hello1 -->
<%=str2 %> <br />	<!-- str2 변수값 출력 // 결과 : Hello2 -->
<%=str3 %> <br />	<!-- str3 변수값 출력 // 결과 : Hello1Hello2 -->
<%=a %> <br />		<!-- a 변수의 값을 출력 // 결과 : 10 (반복문에서 10번 증가시켰기 때문) -->
</body>
</html>