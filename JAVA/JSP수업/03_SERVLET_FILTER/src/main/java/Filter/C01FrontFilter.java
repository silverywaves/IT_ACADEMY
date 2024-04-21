package Filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

//@WebFilter("/login")
public class C01FrontFilter implements Filter {	// C01FrontFilter 클래스는 Filter 인터페이스를 구현함

	@Override	// doFilter 메서드 오버라이드 -> 필터 로직 구현(모든 요청이 들어올 때마다 호출)
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {	// 필터에서 구현해야 하는 로직 작성
		
		// request 전 처리
		System.out.println("C01FrontFilter START------");	// 필터 작업 시작을 알리는 로그 출력
		chain.doFilter(req, resp);	// 다음 필터가 있으면 필터 호출, 필터가 없으면 dispatcherServlet 호출
		// response 후 처리
		System.out.println("C01FrontFilter END-------");	// 필터 작업이 끝났음을 알리는 로그 출력
		
		// 필터는 체인 형태로 동작 -> 여러 개의 필터가 순차적으로 적용
		
	}

}
