package com.example.app.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;

public class BookListController implements SubController {  // SubController와 상속관계여야 FrontController에서 가져다 쓸 수 있음

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BookListController's execute() invoke..");
		try {
			// GET MAPPTING
			String method = request.getMethod();	// 메서드 가져오기
			if(method.contains("GET")){				// 만약 메서드가 contains 에서 'get' 이라면
				request.getRequestDispatcher("/WEB-INF/view/book/list.jsp").forward(request, response);
				return ;				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 예외페이지로 넘기기 or new ServletException("message") 처리
		}
	}

}
