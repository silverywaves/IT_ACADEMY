<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 내용값 유지가능 -->
<%! 		/* 선언문 => 서블릿의 멤버 변수나 메서드 정의 */
	int a = 0;					/* a라는 정수 변수 선언, 초기값으로 0 할당 */
	public int countUp(){		/* countUp이라는 public 메서 선언 */
		a++;					/* a 변수 값을 1 증가 */
		return a;				/* 증가된 a 변수 값 반환 */
	}
%>

<!-- 표현식 -->
a : <%=countUp() %> <br />		<!-- countUp 메서드 호출, 반환값 출력 // 결과 : a 변수 값에서 1 증가된 값 -->

<%! 
	/* // 반복문 사용불가
	for(int i=0;i<10;i++){
		System.out.println("HELLO WORLD");
	} */
%>

<!-- HTML과 Java 코드의 혼합 사용 가능 => 동적 웹 페이지 생성시 유용함 -->


</body>
</html>