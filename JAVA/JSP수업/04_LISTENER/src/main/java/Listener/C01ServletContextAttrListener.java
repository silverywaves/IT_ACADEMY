package Listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;

// 서블릿 컨텍스트의 속성 변경을 감지하는 리스너를 서블릿 컨텍스트에 등록 : @WebListener 적용 or web.xml 에서 확인
public class C01ServletContextAttrListener implements ServletContextAttributeListener {
	// C01ServletContextAttrListener 클래스는 ServletContextAttributeListener 인터페이스를 구현

	@Override	// 속성이 서블릿 컨텍스트에 추가되었을 때 호출되는 메서드
	public void attributeAdded(ServletContextAttributeEvent scae) {
		// 추가된 속성에 대한 정보는 ServletContextAttributeEvent 객체 scae를 통해 확인
		System.out.println("C01ServletContextAttrListener's attributeAdded invoke..");
	}

	@Override	// 서블릿 컨텍스트에서 속성이 제거되었을 때 호출되는 메서드
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		// 제거된 속성에 대한 정보는 scae 객체를 통해 확인
		System.out.println("C01ServletContextAttrListener's attributeRemoved invoke..");		
	}

	@Override	// 서블릿 컨텍스트에서 속성이 교체(수정)되었을 때 호출되는 메서드
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		// 교체된 속성에 대한 정보는 scae 객체를 통해 확인
		System.out.println("C01ServletContextAttrListener's attributeReplaced invoke..");
	}

}
