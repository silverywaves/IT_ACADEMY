<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

참고 https://dololak.tistory.com/616

Listener
	: 웹 애플리케이션의 생명 주기 이벤트를 감지하고 이벤트에 따라 특정 작업을 수행하는 클래스
	: @WebListener 적용 or web.xml 등록
	      <listener> : 리스너를 등록할 때 사용하는 태그
		  	<listener-class> : 리스너 인터페이스를 구현한 리스너 클래스를 패키지명을 포함하여 지정
		  		구현한 리스너 클래스의 패키지명.클래스명
		  	</listener-class>
		  </listener>
	
ServletContextListener
	- 웹어플리케이션의 시작, 종료 이벤트에 대한 이벤트 리스너
	- 핸들러 메서드 => ServletContext에 대한 참조
	
ServletContextAttributeListener
	- ServletContext에 attribute를 추가하거나 제거, 수정됐을 때에 대한 이벤트 리스너\
	- 핸들러 메서드 => 추가하거나 제거, 수정된 attribute 정보
	
HttpSessionListener
	- HTTP 세션의 시작, 종료 이벤트에 대한 이벤트 리스너
	- 핸들러 메서드 => 현재 세션 객체
	
HttpSessionAttributeListener
	- HttpSession에 attribute를 추가하거나 제거, 수정됐을 때에 대한 이벤트 리스너
	- 핸들러 메서드 => 추가하거나 제거, 수정된 attribute 정보
	
ServletRequestListener
	- 클라이언트로부터의 요청으로 인한 ServletRequest 생성과 응답 이후 ServletRequest 제거시에 대한 이벤트 리스너
	- 핸들러 메서드 => 요청에 관련된 정보와 ServletContext에 대한 참조

ServletRequestAttributeListener
	- ServletRequest에 attribute를 추가하거나 제거, 수정됐을 때에 대한 이벤트 리스너
	- 핸들러 메서드 => 추가하거나 제거, 수정된 attribute 정보
	
	
	
	