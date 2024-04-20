<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%	/* 스크립틀릿 내에서 Scanner 클래스 사용 => 행(row), 열(col) 값 입력받기 */
	java.util.Scanner sc = new java.util.Scanner(System.in);	// 콘솔 입력을 받기 위한 Scanner 객체 생성
	System.out.println("행열 입력 : ");	// "행열 입력 :" 메시지 출력
	int row = sc.nextInt();				// 정수 값을 입력받아 row 변수에 저장
	int col = sc.nextInt();				// 정수 값을 입력받아 col 변수에 저장
	System.out.println("행 : " + row + " 열 : " + col);	// 입력받은 row와 col 값 출력
%>
<!-- 표현식 => 입력받은 row와 col 값을 HTML에 출력 -->
행 : <%=row %> <br />
열 : <%=col %> <br />
<hr />

	<table class="table">	<!-- 표 생성 => 스크립틀릿 중첩 : 행(row)과 열(col)에 따른 셀 값 생성 -->
		<%
			int cnt=1;		// 셀의 시작 값으로 cnt 변수를 1로 초기화
			for(int i=0;i<row;i++){	%>	<!-- 행의 수(row)만큼 반복 -->
			<tr>			<!-- 행 시작 -->
				<%
					for(int j=0;j<col;j++){ %>	<!-- 열의 수(col)만큼 반복 -->
						<td><%=cnt++ %></td>	<!-- 각 셀에 cnt 값 출력 후 cnt 값 1 증가 -->
				<%	}
				%>
			</tr>			<!-- 행 종료 -->
		<%	}
		%>
	</table>

</body>
</html>