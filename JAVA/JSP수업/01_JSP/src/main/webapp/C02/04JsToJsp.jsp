<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String param1 = request.getParameter("param1");
	String param2 = request.getParameter("param2");
	String flag = request.getParameter("flag");
	/* System.out.println("param1 : " + param1);
	System.out.println("param2 : " + param2); */
%>

PARAM1 : <%=param1 %> <br />
PARAM2 : <%=param2 %> <br />

<form action="04JsToJsp.jsp" name="frm">
	<input type="hidden" name="param1" />
	<input type="hidden" name="param2" />
	<input type="hidden" name="flag" />
</form>

<script>
	// formData = new FormData();  이렇게 해도 ok
	const form = document.frm;
	const flag = '<%=flag %>';

	if(flag==null||flag=='')
		test();
	
	function test(flag){
		console.log(flag);
			form.param1.value="HELLO1";
			form.param2.value="HELLO2";
			form.flag.value="true";
		/* 	form.action="04JsToJsp.jsp"; */
		 	form.submit();
	}
</script>

</body>
</html>