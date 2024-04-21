package Filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Type.Role;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class PermissionFilter implements Filter {	// PermissionFilter 클래스는 Filter 인터페이스를 구현
	// PermissionFilter : 사용자의 권한과 요청한 페이지의 권한을 비교하여 접근을 허용하거나 거부하는 역할
	
	// 해당 페이지에 대한 허용 등급
	// /user	Role.ROLE_USER
	// /manager	Role.ROLE_manager
	// /admin	Role.ROLE_ADMIN
	Map<String, Role> pageGradeMap = new HashMap();	// pageGradeMap은 URL 패턴에 따른 권한 정보를 담는 HashMap
	
	@Override	// 필터 초기화 시 호출, 각 페이지의 URL과 권한 정보를 pageGradeMap에 저장(각 페이지의 URL과 권한 정보를 pageGradeMap에 초기화)
	public void init(FilterConfig filterConfig) throws ServletException {
		String path = filterConfig.getServletContext().getContextPath();
		
		pageGradeMap.put(path+"/user", Role.ROLE_USER);
		pageGradeMap.put(path+"/manager", Role.ROLE_MANAGER);
		pageGradeMap.put(path+"/admin", Role.ROLE_ADMIN);
	}

	@Override	// doFilter 메서드 오버라이드(모든 요청이 들어올 때마다 호출) => 필터 로직 구현
	// => 요청이 들어오면 사용자의 권한과 페이지의 권한을 확인하여 접근 허용 or 거부, 작업이 끝나면 로그 출력
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 전
		System.out.println("PermissionFilter start---");
		// 현재 요청의 HTTP 요청과 세션을 얻어와서 사용자의 권한 정보 추출
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Role userRole = (Role)session.getAttribute("role");	// 현재 접속 USER의 Role
		// 로그인 안한 상태
		if(userRole==null) {		// 사용자의 권한이 없으면 예외 발생
			throw new ServletException("익명 계정으로는 접근이 불가능한 페이지입니다.");
		}
		
		// 계정 로그인 상태
		// PageGradeMap 에서 어떤 요청(/user, /manager, /admin)이 있는지 확인해서 해당 페이지권한 추출
		String reqUri = req.getRequestURI();
		System.out.println("URI : " + reqUri);
		Role pageRole = pageGradeMap.get(reqUri);
		
		// 접속계정 : ROLE_USER(0) , 요청페이지 ROLE_MANAGER(1), ROLE_ADMIN(2)
		if(userRole.ordinal()<pageRole.ordinal()) {	// 사용자의 권한과 페이지의 권한 비교 -> 사용자의 권한<페이지의 권한 : 예외 발생
			throw new ServletException("해당 권한으로는 접근이 불가능합니다.");
		}
		// FilterChain의 doFilter 메서드 호출 => 요청을 다음 필터로 전달 or 최종적으로 서블릿으로 전달
		chain.doFilter(request,response);
		
		// => 만약 사용자의 권한이 없거나 페이지의 권한이 더 높다면 예외 발생, 체인의 다음 필터나 서블릿은 실행 x
		
		// 후
		System.out.println("PermissionFilter end----");
		
	}

}
