<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="03Error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- C03 패키지의 모든 클래스를 import(SimpleDto 클래스 포함) -->
	<%@page import="C03.*" %>
	<%	// 스크립트릿 시작 : 사용자로부터 입력 받은 정보 처리, 예외를 발생시킬 수 있는 조건 검사
		// 1. username, age, addr 파라미터 값을 가져와서 각각의 변수에 저장
		String name = request.getParameter("username");	// HTTP 요청에서 username이라는 이름으로 전달된 파라미터 값을 가져와 name 변수에 저장
		int age = Integer.parseInt(request.getParameter("age")); // HTTP 요청에서 age라는 이름으로 전달된 파라미터 값을 가져와 정수로 변환하여 age 변수에 저장
		String addr = request.getParameter("addr");	// HTTP 요청에서 addr라는 이름으로 전달된 파라미터 값을 가져와 addr 변수에 저장
	
		// 2. 변수들의 유효성 검사
		if(name.isEmpty())
			throw new Exception("이름이 공백입니다..");	// name 변수가 비어있으면 예외 발생 & 메시지 지정
		if(age==0)
			throw new Exception("나이가 공백입니다..");	// age 변수가 0이면 예외 발생 & 메시지 지정
		if(addr.isEmpty())
			throw new Exception("주소가 공백입니다..");	// addr 변수가 비어있으면 예외 발생 & 메시지 지정
		
		// 3. 검사를 통과하면 SimpleDto 객체 생성
		SimpleDto dto = new SimpleDto(name,age,addr);	// 위에서 검증한 name, age, addr 값을 사용하여 SimpleDto 객체 생성
		
		// 4. 생성된 객체 출력
		out.println(dto);	// 생성한 dto 객체 출력
		
		// => 만약 변수들 중 하나라도 유효하지 않은 값이면, 예외 발생시키고 03Error.jsp 페이지로 이동
	%>
	

</body>
</html>