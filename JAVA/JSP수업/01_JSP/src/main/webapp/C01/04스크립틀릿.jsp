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
	java.util.Scanner sc = new java.util.Scanner(System.in);
	System.out.println("행열 입력 : ");
	int row = sc.nextInt();
	int col = sc.nextInt();
	System.out.println("행 : " + row + " 열 : " + col);
%>
행 : <%=row %> <br />
열 : <%=col %> <br />
<hr />

	<table class="table">
		<%
			int cnt=1;
			for(int i=0;i<row;i++){	%>
			<tr>
				<%
					for(int j=0;j<col;j++){ %>
						<td><%=cnt++ %></td>
				<%	}
				%>
			</tr>	
		<%	}
		%>
	</table>

</body>
</html>