<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%	/* 스크립틀릿 내에서 네 개의 문자열 변수(msg1, msg2, msg3, msg4) 선언 및 값 할당 */
	String msg1 = "HELLO WORLD1";
	String msg2 = "HELLO WORLD2";
	String msg3 = "HELLO WORLD3";
	String msg4 = "HELLO WORLD4";
%>

<script>
	/* JavaScript 코드 영역에서 JSP 스크립틀릿을 통해 선언한 변수 값 사용 */
	const message1 = '<%=msg1%>';	/* JSP 스크립틀릿에서 선언한 각 msg 변수의 값을 가져와 각 message 상수에 할당 */
	const message2 = '<%=msg2%>';
	const message3 = '<%=msg3%>';
	const message4 = '<%=msg4%>';
	console.log(message1);		/* 각 message 상수의 값을 콘솔에 출력 */
	console.log(message2);
	console.log(message3);
	console.log(message4);
</script>

<!-- => JSP에서는 자바 코드와 HTML, JavaScript 코드를 함께 사용하여 동적인 웹 페이지 생성 가능 -->

</body>
</html>