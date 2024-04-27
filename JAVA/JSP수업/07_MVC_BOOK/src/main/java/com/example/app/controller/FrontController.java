package com.example.app.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.book.BookAddController;
import com.example.app.controller.book.BookDeleteController;
import com.example.app.controller.book.BookListController;
import com.example.app.controller.book.BookReadController;
import com.example.app.controller.book.BookUpdateController;

/*@WebServlet("/")*/	// web.xml 로 설정 완료
public class FrontController extends HttpServlet {	

	private Map<String,SubController> map;		// URI에 따른 SubController 객체를 저장할 맵 선언

	// 우클릭->source->override 
	// 서블릿 초기화 메서드 재정의 : init()
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FrontController's init() invoke..");	// 실행 로그 출력
		
		map = new HashMap();	// 맵 객체 초기화
		
		// 프로젝트 컨텍스트 경로 받기  // ServletContext : 웹 애플리케이션의 환경 정보를 제공하는 객체
		String path = config.getServletContext().getContextPath();
		
		// 메인페이지 '/'
		map.put(path+"/", new HomeController());	
		// 키 : path+"/"(path가 "index"면 키는 "index/")
		// 값 : HomeController 클래스의 새 인스턴스
		
		// book과 관련된 요청 URI에 대한 SubController 매핑
		// 하나의 프로젝트로만 처리하는 것이 아니라면 uri 앞에 프로젝트 경로가 들어가야 함(없으면 프로젝트 안의 경로 찾아갈 수 없음) -> init(ServletConfig)를 통해 진행
		// map => HashMap 객체
		// put => HashMap에 키-값 추가하는 메서드
		map.put(path+"/book/add", new BookAddController());			// 도서 추가
		map.put(path+"/book/list", new BookListController());		// 도서 조회
		map.put(path+"/book/read", new BookReadController());		// 도서 상세 조회
		map.put(path+"/book/update", new BookUpdateController());	// 도서 수정
		map.put(path+"/book/delete", new BookDeleteController());	// 도서 삭제
		
		// user와 관련된 요청 URI에 대한 SubController 매핑
		
		
		// lend와 관련된 요청 URI에 대한 SubController 매핑
	}
	
	// 우클릭->source->override 
	// HTTP 요청 처리 메서드 재정의 : service(HttpServletRequest request, HttpServletResponse response)
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();	// 요청 URI 가져오기 => 어떠한 요청이 왔는지는 request에서 그대로 꺼내와서 쓸 수 있음
		System.out.println("FrontController's service() invoke..");	// 실행 로그 출력
		
		SubController controller = map.get(uri);	// 요청 URI에 해당하는 SubController 객체 가져오기
		// null 체크
		if(controller==null) {	// SubController 객체가 null인 경우
			throw new ServletException("해당 페이지는 존재하지 않습니다");		// 예외 발생 및 메시지 출력
		}
		controller.execute(request, response);	// 가져온 SubController 객체의 execute 메서드 호출
		// controller: SubController 구현 객체 => 요청 URI에 따라 적절한 작업을 수행하는 컨트롤러 참조
		// request: javax.servlet.http.HttpServletRequest 객체 => 클라이언트의 HTTP 요청 정보 -> 요청 파라미터, 헤더, 세션 등의 정보 추출 가능
		// response: javax.servlet.http.HttpServletResponse 객체 => 클라이언트에게 응답을 보낼 때 사용 -> 응답의 상태 코드, 헤더, 본문 등을 설정 가능
	}
	
}
