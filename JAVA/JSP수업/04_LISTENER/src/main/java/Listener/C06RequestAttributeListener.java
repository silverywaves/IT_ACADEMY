package Listener;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

@WebListener
public class C06RequestAttributeListener implements ServletRequestAttributeListener{
	// C06RequestAttributeListener 클래스는 ServletRequestAttributeListener 인터페이스를 구현하여 서블릿 요청의 속성 변경 이벤트를 감지
	
	  @Override
	    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) { // 요청에 속성이 추가될 때 호출
		  	// 현재 요청에 대한 HttpServletRequest 객체를 얻어와 속성 이름, 값, 요청 URI를 출력
	        HttpServletRequest request = (HttpServletRequest) servletRequestAttributeEvent.getServletRequest();
	        System.out.println("ServletRequestAttributeListener 속성 추가: " + servletRequestAttributeEvent.getName() + " = " + servletRequestAttributeEvent.getValue() +
	                " (요청: " + request.getRequestURI() + ")");
	    }

	    @Override
	    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) { // 요청에서 속성이 제거될 때 호출
	    	// 현재 요청에 대한 HttpServletRequest 객체를 얻어와 제거된 속성의 이름과 요청 URI를 출력
	        HttpServletRequest request = (HttpServletRequest) servletRequestAttributeEvent.getServletRequest();
	        System.out.println("ServletRequestAttributeListener 속성 제거: " + servletRequestAttributeEvent.getName() + " (요청: " + request.getRequestURI() + ")");
	    }

	    @Override
	    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) { // 요청의 속성이 대체될 때 호출
	    	// 현재 요청에 대한 HttpServletRequest 객체를 얻어와 대체된 속성의 이름, 값, 요청 URI를 출력
	        HttpServletRequest request = (HttpServletRequest) servletRequestAttributeEvent.getServletRequest();
	        System.out.println("ServletRequestAttributeListener 속성 대체: " + servletRequestAttributeEvent.getName() + " = " + servletRequestAttributeEvent.getValue() +
	                " (요청: " + request.getRequestURI() + ")");
	    }
}
