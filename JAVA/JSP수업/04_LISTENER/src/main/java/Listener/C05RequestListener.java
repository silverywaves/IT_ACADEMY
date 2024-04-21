package Listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

@WebListener
public class C05RequestListener implements ServletRequestListener{
	// C05RequestListener 클래스는 ServletRequestListener 인터페이스를 구현하여 서블릿 요청의 생명주기 이벤트를 감지
	
	  @Override
	    public void requestInitialized(ServletRequestEvent servletRequestEvent) { // 서블릿 요청이 초기화될 때 호출
		  	// 현재 요청에 대한 HttpServletRequest 객체를 얻어와 요청 URI를 출력
	        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
	        System.out.println("요청 시작: " + request.getRequestURI());
	    }

	    @Override
	    public void requestDestroyed(ServletRequestEvent servletRequestEvent) { // 서블릿 요청이 종료될 때 호출
	    	// 현재 요청에 대한 HttpServletRequest 객체를 얻어와 요청 URI를 출력
	        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
	        System.out.println("요청 종료: " + request.getRequestURI());
	    }
}
