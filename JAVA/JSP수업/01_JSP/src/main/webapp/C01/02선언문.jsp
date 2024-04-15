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
<%! 
	int a = 0;
	public int countUp(){
		a++;
		return a;
	}
%>
a : <%=countUp() %> <br />

<%! 
	/* // 사용불가
	for(int i=0;i<10;i++){
		System.out.println("HELLO WORLD");
	} */
%>


</body>
</html>