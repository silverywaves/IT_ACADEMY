<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

Filter
	: 클라이언트로부터 서버로 request 들어오기 전, response 나가기 전에 서블릿을 거쳐서 필터링
		- Servlet : HttpServletRequest  /  Filter : ServletRequest(상위)
	: @WebFilter 등록 or web.xml 적용
		<filter>
			<filter-name>UTF_8_EncodingFilter</filter-name>
			<filter-class>Filter.UTF_8_EncodingFilter</filter-class>
		</filter>
		<filter-mapping>
			<filter-name>UTF_8_EncodingFilter</filter-name>
			<url-pattern>/*</url-pattern>	//  특정 URL 또는 URL 패턴에 적용 => /* : 모든 요청 다 받음
		</filter-mapping>
	
- init(FilterConfig config)
	: 서블릿 컨테이너가 필터 인스턴스를 초기화 하기 위해서 호출하는 메소드
- doFilter(ServletRequest resquest, ServletResponse response, FilterChain chain)
	: 필터에서 구현해야 하는 로직을 작성하는 메소드
- destory()
	: 필터 인스턴스를 종료시키기 전에 호출하는 메소드
	