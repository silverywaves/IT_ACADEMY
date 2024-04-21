<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

서블릿 라이프 사이클
	1. 요청시 servlet 클래스 로딩 -> 요청에 대한 servlet 객체 생성
	2. 서버는 init() 호출(최초 1회 동작) -> servlet 초기화
	3. service() 호출(요청시마다 동작) -> servlet이 브라우저의 요청을 처리하도록 시킴
	4. service()는 특정 HTTP요청(GET,POST 등)을 처리하는 메서드(doGet(),doPost() 등) 호출
	5. 서버는 destroy() 호출(코드수정, 종료시 동작) -> sevlet 제거
	
- init() : 서블릿 초기화 작업 수행시 자동 호출
	public void init(파라미터x) throws ServletExeception{	// throws 절 생략가능
		to-do
	}
	=> ServletConfig 파라미터를 받는 경우 슈퍼클래스의 init 메서드 호출 지정
	
- service() : 요청마다 반복 호출
- distroy() : 서블릿 마무리 작업 수행시 자동 호출
	public void destroy(파라미터x){	// throws 절 사용불가
		to-do
	}
- doGet()/doPost()
	doGet() : URL(Header(헤더))에 변수를 포함시켜 요청 => url에 데이터 노출, 캐싱 가능
	doPost() : Body(바디)에 변수를 포함시켜 요청 => url에 데이터 노출X, 캐싱 불가



