<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>		<!-- JSP 페이지 지시어 => 속성 설정 -->
<!-- 
	language="java": JSP 페이지의 스크립트 언어가 Java임을 지정
	contentType="text/html; charset=UTF-8": 브라우저에 전송될 문서의 타입과 문자 인코딩 설정
	pageEncoding="UTF-8": JSP 페이지의 문자 인코딩 설정
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
	선언문(서블릿으로 변환되는 자바파일의 속성/기능추가 = 서블릿의 멤버 변수나 메서드 정의)
 -->
 	<%! 
 		String name="Hong Gil Dong";	/* name이라는 문자열 변수 선언, 초기값으로 "Hong Gil Dong" 할당 */
 		public String testFunc(){		/* testFunc이라는 공개(public) 메서드 선언 */
 			System.out.println("선언문 TEST");	/* 콘솔에 "선언문 TEST" 메시지 출력 */
 			return "HELLO WORLD";		/* "HELLO WORLD" 문자열 반환 */
 		}
 	%>
 	
<!-- 
	표현식(HTML로 표시/표현할 때 사용되는 코드 =  HTML로 표시되는 코드나 값 출력)
 -->
 	<%=name %> <br />			<!-- name 변수 값 출력 // 결과 : Hong Gil Dong -->
 	<%=testFunc() %> <br />		<!-- testFunc 메서드 호출 및 반환값 출력 // 결과 : HELLO WORLD -->
 	 	
</body>
</html>