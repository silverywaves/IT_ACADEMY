package com.edu.test;

//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;


@WebServlet("/second")		// 서블릿 실행을 위한 URI를 "/second"로 설정
public class _2_SecondServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		System.out.println("SecondServlet!!");
		
		PrintWriter out = resp.getWriter();		//getter 메소드 : 값을 추출해주는 기능을 수행
												//Writer : 자바에서 외부로 데이터를 출력하기 위한 출력스트림을 나타내는 단어
		// -> 클라이언트에게 응답 관련 작업을 수행하는데, 데이터를 출력하기 위한 출력스트림을 추출하는 메소드
		//out 이라는 이름의 출력스트림 생성하고 resp.getWriter() 메소드가 반환한 출력스트림을 대입
		// -> out 을 통해 클라이언트에 데이터를 출력
		
		out.print("<html><head><title>Test</title></head>");
		out.print("<body><h1>have a nice day!!</h1></body>");
		out.print("</html>");		//out 이라는 스트림(서비스를 요청한 웹 브라우저와 연결되어있음)에 문자열을 출력
									//출력스트림은 일대일로만 대응 -> 서버에서 보내는 데이터는 무조건 웹 브라우저쪽으로 전송
		out.close();				//앞에서 생성한 out 이라는 이름의 스트림을 닫아줌(출력스트림을 끊어주는 명령문) = "자원 해제"
	}

}
