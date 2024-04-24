package com.example.app.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;

public class BookListController implements SubController {  // SubController와 상속관계여야 FrontController에서 가져다 쓸 수 있음

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BookListController's execute() invoke..");
		
	}

}
