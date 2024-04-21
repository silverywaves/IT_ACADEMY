<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

이클립스, 톰캣 설치 후 new->server->톰캣버전선택->경로설정(톰캣폴더 더블클릭해서 권한승인 필수)
-> 아래쪽 서버보조창에서(없으면 window->show view에서 server창 추가) 톰캣서버 더블클릭
-> port name에서 톰캣서버 포트넘버 8081 설정 후 run 해서 실행되는지 확인
-> 정상실행되면 새 프로젝트(dynamic project) 생성

HTTP
	- 헤더 : HTTP 메시지(요청/응답)&본문에 대한 정보
		- General Header : 요청/응답이 이루어지는 날짜 및 시간등에 대한 일반적인 정보
		- Request/Response Header
			- Request : 웹브라우저가 웹서버에 요청하는 것을 텍스트로 변환한 메시지
				- GET : 요청하는 데이터가 HTTP Request Message의 Header 부분의 url 에 담겨서 전송
				- POST : HTTP Message의 Body 부분에 데이터가 담겨서 전송
			- Response : 웹서버가 웹브라우저에 응답하는 콘텐츠가 들어가있는 메시지
		- Entity Header : 실제 주고받는 컨텐츠와 관련된 http 본문에 대한 정보
	- 본문 : 실제 통신과정에서 주고받을 컨텐츠 
    
서버 > 웹서버, 응답자
	: 응답에 대한 처리 담당 (웹 프로그래머 역할)

클라이언트 > 웹브라우저, 요청자(사용자)
	: 사용자는 주소란을 이용해 정보 요청

톰캣(=WAS:Web Application Server) : 자바로 작성된 소스가 웹으로 출력될 수 있도록 번역

JSP(Java Server Page) 
	: 서버에서 실행하는 자바 페이지(주로 View 화면 출력용으로 사용)
	  동적 페이지를 생성하기 위한 서버측 스크립트 언어
	  전체 소스를 전송하기때문에 보안에 취약함
	  
JSP 동작 과정
	: 사용자가 브라우저 주소창을 이용해 정보(파일) 요청(주소창에 url 입력 => 브라우저는 서버에 정보 요청)
	  -> 웹서버는 클라이언트가 요청한 파일을 찾아 응답하기 위한 과정 진행(html, xml, json 파일만 자체적으로 처리 가능, 나머지는 html로 변경 필수-WAS)
	  -> 웹서버에서 톰캣으로 번역 요청
	  		1. .jsp -변경-> .java
	  		2. .java 컴파일(javac)
	  		3. 컴파일된 파일 실행(java)
	  		4. HTML 부분만 메모리에 출력(출력버퍼)
	  -> html 태그로 구성된 페이지가 화면에 출력

JSP 지시자 : 클라이언트의 요청에 jsp페이지가 실행될 때 필요한 정보를 JSP 컨테이너에게 알리는 역할
- import : 자바 라이브러리, 사용자정의 추가
- errorPage : 에러시 이동하는 파일 지정


** 현재 작업중인 페이지 -이동-> 다른 페이지 **

Forward(건네주기)
	- web container 차원에서의 페이지 이동(실제로 웹브라우저는 다른 페이지로 이동했는지 알 수 없음)
	  => 웹브라우저 -request-> URL1 -forward-> URL2 -response-> 웹브라우저
	- 웹브라우저에는 최초 호출한 URL만 표시(이동한 페이지의 URL정보 확인X)
	- 현재 실행중인 페이지와 forward에 의해 호출될 페이지는 request, response 객체 공유
	  => 사용자가 최초로 요청한 요청정보는 다음 URL에서도 유효

vs

Redirect
	- web container에서 다른 페이지로 이동하라고 명령
	  => 웹브라우저 -request1-> URL1 -redirect-> 웹브라우저 -request2-> URL2 -response-> 웹브라우저 
	- 웹브라우저는 URL을 지시된 주소로 바꾸고 그 주소로 이동
	- 다른 web container에 있는 주소로 이동 가능
	- 새로운 페이지에서는 request, response객체가 새롭게 생성(초기화)


=> 둘의 차이점 : 1. URL 변화여부 2. 객체 재사용여부
=> 시스템(session, DB)에 변화가 생기는 요청(로그인, 회원가입, 글쓰기) : redirect 방식 응답
   시스템(session, DB)에 변화 없는 단순조회(리스트보기, 검색) : forward 방식 응답
   
   
내장객체
	: JSP 페이지에서 사용할 수 있도록 JSP 컨테이너에 미리 정의된 객체
	: 별도의 import문 없이 사용 가능
	: 스크립틀릿 태그나 표현문 태그에 선언하거나 객체 생성 없이 직접 호출하여 사용 가능


Request 내장객체
	: 웹브라우저에서 서버의 JSP 페이지로 전달하는 정보 저장
		- 폼 페이지로부터 입력된 데이터를 전달하는 요청 파라미터값을 JSP 페이지로 가져옴
	: 요청 파라미터
		- 사용자가 폼페이지에 데이터를 입력한 후 서버에 전송할 때 전달되는 폼페이지의 입력된 정보형태
		- <name=value> 형식으로 웹브라우저에서 서버의 JSP 페이지로 전송
	: 요청 HTTP HEADER
		- http 헤더에 부가적인 정보를 담아 서버로 전송


Response 내장객체
	: 사용자의 요청을 처리한 결과를 서버에서 웹브라우저로 전달하는 정보 저장
		- 서버는 응답 헤더와 요청 처리 결과 데이터를 웹브라우저로 보냄
	: 페이지 이동 = 리다이렉션(Redirection)\
		- sendRedirect(String url)
	: 응답 HTTP HEADER
		- 서버가 웹브라우저에 응답하는 정보에 헤더를 추가하는 기능 제공(주로 서버에 대한 정보 저장)


Session
	: 웹서버에 존재하는 객체(웹브라우저마다 하나씩 존재)
		- 클라이언트와 웹서버간 상태를 지속적으로 유지하는 방법
		- 웹서버의 서비스를 제공받는 사용자를 구분하는 단위
	: 웹서버에서만 접근 가능 -> 보안 유지에 유리, 데이터 저장 한계X
	: 웹브라우저를 닫기 전까지 웹페이지를 이동하더라도 사용자의 정보가 웹서버에 보관되어있어 사용자 정보를 잃지 않음


Cookie
	: 서버가 상태정보를 클라이언트에 전송하여 저장하는 텍스트 조각
		- 클라이언트와 웹서버간의 상태를 지속적으로 유지하는 방법
	: 장점 - 클라이언트의 일정 폴더에 정보 저장 -> 웹서버 부하 줄어듦
	: 단점 - 웹브라우저가 접속했던 웹사이트에 관한 정보과 개인정보 기록 -> 보안 취약
	: 동작과정
		- 생성 Cookie(String name-쿠키를 식별하기 위한 이름, String value-쿠키값)
			: 웹 서버측에서 생성, 응답 데이터와 함꼐 저장되어 웹브라우저에 전송
		- 저장
			: 웹브라우저는 응답데이터에 포함된 쿠키를 쿠키 저장소에 보관(종류에 따라 메모리나 파일로 저장)
		- 전송
			: 웹브라우저는 한번 저장된 쿠키를 요청이 있을때마다 웹서버에 전송


EL
	: 자바 빈의 프로퍼티, 값을 JSP의 표현식 <%= %>이나 액션 태그 <jsp:useBean>를 사용하는것 보다 쉽고 간결하게 꺼낼수 있게 하는 기술
	: 연산처리 가능
	: 참고 : https://atoz-develop.tistory.com/entry/JSP-EL-%ED%91%9C%ED%98%84%EC%8B%9D-%EB%AC%B8%EB%B2%95%EA%B3%BC-%EC%82%AC%EC%9A%A9-%EB%B0%A9%EB%B2%95
	- ${} : JSP가 실행될 때 즉시 반영 => 객체 프로퍼티 값 꺼낼 때 주로 사용
	- #{} : 시스템에서 필요하다고 판단될 때 그 값을 사용 => 사용자 입력값을 객체의 프로퍼티에 담는 용도로 주로 사용

JSTL
	: JSP 확장 태그
	: https://mvnrepository.com/artifact/javax.servlet/jstl/1.2 에서 jar 파일 다운 후 프로젝트의 WEB-INF 안에 lib 폴더 생성하여 넣어주기
	: taglib 지시자로 라이브러리 선언 <%@ taglib prefix="접두사" uri="URI" %>
		- 참고 : https://atoz-develop.tistory.com/entry/JSP-JSTL-%EC%82%AC%EC%9A%A9-%EB%B0%A9%EB%B2%95-%EC%A3%BC%EC%9A%94-%ED%83%9C%EA%B7%B8-%EB%AC%B8%EB%B2%95-%EC%A0%95%EB%A6%AC
	- c:out : 출력문 / value에 EL 표현식 가능
		- <c:out value="출력값" default="기본값" /> 
		- <c:out value="출력값">기본값</c:out>
	- c:set : 변수 다룰때 사용(JSP의 로컬 변수가 아니라 서블릿 보관소(JspContext, ServletRequest, HttpSession, ServletContext)에 저장)
			: 이미 존재하는 변수에 값을 할당할 경우 기존 값을 덮어씀
		- <c:set var="변수명" value="값" scope="page(기본값)|request|session|application" />
		- <c:set var="변수명" scope="page(기본값)|request|session|application">값</c:set>
	- c:if : 조건문
		- <c:if test="조건식" var="변수명" scope="page(기본값) | request | session | application">내용</c:if>
	- c:choose : java의 switch-case와 같은 기능 => 여러 조건에 따라 다른 작업을 해야할 때 사용
		- <c:choose>
		    <c:when test="조건식"></c:when>	<!-- <c:when> 태그는 한 개 이상 존재 & <c:otherwise> 태그는 0개 혹은 1개 -->
		    <c:when test="조건식"></c:when>
		    ...
		    <c:otherwise></c:otherwise>	<!-- <c:when>의 조건에 일치하지 않으면 <c:otherwise> 실행 -->
		  </c:choose>
	- c:forEach : 반복문 => 목록에서 값을 꺼내서 처리할 때 사용
		- <c:forEach var="변수명" items="목록 데이터" begin="시작 인덱스" end="종료 인덱스">콘텐츠</c:forEach>
		
	
web.xml 생성 : 프로젝트 우클릭 -> Java EE Tools -> Generate Deployment Descriptor Stub


	
	
	

