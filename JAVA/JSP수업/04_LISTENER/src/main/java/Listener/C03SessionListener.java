package Listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class C03SessionListener implements HttpSessionListener{
	// C03SessionListener 클래스는 HttpSessionListener 인터페이스를 구현하여 HTTP 세션의 생명주기 이벤트를 감지
	
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {	// HTTP 세션이 생성될 때 호출
        System.out.println("세션 생성: " + httpSessionEvent.getSession().getId()); // 세션 ID와 함께 세션이 생성되었음을 알림
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) { // HTTP 세션이 소멸될 때 호출
        System.out.println("세션 소멸: " + httpSessionEvent.getSession().getId());	// 세션 ID와 함께 세션이 소멸되었음을 알림
    }
}
