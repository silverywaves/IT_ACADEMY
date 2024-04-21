package Listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener	// 어노테이션을 통해 이 클래스는 웹 리스너로 동작하도록 지정
public class C01ServletContextListener implements ServletContextListener {
	// C01ServletContextListener 클래스는 ServletContextListener 인터페이스를 구현(웹 애플리케이션의 생명주기 이벤트 처리)

	@Override
	public void contextInitialized(ServletContextEvent sce) {	// 웹 애플리케이션이 초기화 될 때 호출
		System.out.println("C01ServletContextListener's contextInitialized invoke");
		// ServletContextEvent 객체 sce를 통해 ServletContext에 CTX_ATTR1 이름으로 CTX_ATTR1_VALUE 값을 속성으로 설정
		sce.getServletContext().setAttribute("CTX_ATTR1", "CTX_ATTR1_VALUE");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {	// 웹 애플리케이션이 소멸될 때 호출
		System.out.println("C01ServletContextListener's contextDestroyed invoke");
	}	

	
}
