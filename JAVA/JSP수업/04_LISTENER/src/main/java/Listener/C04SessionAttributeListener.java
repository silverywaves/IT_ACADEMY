package Listener;


import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;


@WebListener
public class C04SessionAttributeListener implements HttpSessionAttributeListener{
	// C04SessionAttributeListener 클래스는 HttpSessionAttributeListener 인터페이스를 구현하여 HTTP 세션의 속성 변경 이벤트 감지

	  @Override
	    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) { // HTTP 세션에 속성이 추가될 때 호출
		  	// 추가된 속성의 이름, 값, 그리고 해당 세션의 ID를 출력
	        System.out.println("HttpSessionAttributeListener 속성 추가: " + httpSessionBindingEvent.getName() + " = " + httpSessionBindingEvent.getValue() +
	                " (세션: " + httpSessionBindingEvent.getSession().getId() + ")");
	    }

	    @Override
	    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) { // HTTP 세션에서 속성이 제거될 때 호출
	    	// 제거된 속성의 이름과 해당 세션의 ID를 출력
	        System.out.println("HttpSessionAttributeListener 속성 제거: " + httpSessionBindingEvent.getName() +
	                " (세션: " + httpSessionBindingEvent.getSession().getId() + ")");
	    }

	    @Override
	    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) { // HTTP 세션의 속성이 대체될 때 호출
	    	// 대체된 속성의 이름, 새 값, 그리고 해당 세션의 ID를 출력
	        System.out.println("HttpSessionAttributeListener 속성 대체: " + httpSessionBindingEvent.getName() + " = " + httpSessionBindingEvent.getValue() +
	                " (세션: " + httpSessionBindingEvent.getSession().getId() + ")");
	    }
	    
}
