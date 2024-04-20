<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%	/* request.getParameter()=> URL 파라미터 값을 가져와 변수에 저장
		param1, param2, flag 변수는 URL 파라미터를 통해 전달되는 값들을 저장 */
	String param1 = request.getParameter("param1");
	String param2 = request.getParameter("param2");
	String flag = request.getParameter("flag");
	/* System.out.println("param1 : " + param1);
	System.out.println("param2 : " + param2); */
%>

<!-- param1과 param2 변수의 값을 HTML에 출력 -->
PARAM1 : <%=param1 %> <br />
PARAM2 : <%=param2 %> <br />

<!-- HTML 폼 생성 -->
<form action="04JsToJsp.jsp" name="frm">	<!-- 04JsToJsp.jsp 페이지로 데이터를 전송 -->
	<input type="hidden" name="param1" />	<!-- 숨겨진 입력 필드(hidden input) => param1, param2, flag 변수 값 전달 준비 -->
	<input type="hidden" name="param2" />
	<input type="hidden" name="flag" />
</form>

<script>
	// formData = new FormData();  이렇게 해도 ok
	const form = document.frm;	// 앞서 생성한 폼 참조
	const flag = '<%=flag %>';	// JSP 스크립틀릿에서 가져온 flag 값

	if(flag==null||flag=='')
		test();
	
	function test(flag){	// JSP 스크립틀릿을 통해 가져온 flag 값을 사용하여 test() 함수 호출
		console.log(flag);
			form.param1.value="HELLO1";
			form.param2.value="HELLO2";
			form.flag.value="true";
		/* 	form.action="04JsToJsp.jsp"; */
		 	form.submit();
	}
	
	// test() 함수 내에서 flag 값이 없거나 비어 있으면 console.log()로 해당 값을 출력,
	// param1, param2, flag 입력 필드에 값을 설정한 후 폼을 제출
	
</script>

</body>
</html>