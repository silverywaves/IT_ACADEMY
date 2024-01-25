import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

@WebServlet("/headerInfo")

public class _6_HeaderInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html;charset=EUC-KR");
		
		PrintWriter out = res.getWriter();
		
		out.print("<html>");
		out.print("<head><title>Request 정보 출력 Servlet</title></head>");
		out.print("<body>");
		out.print("<h3>요청 헤더 정보</h3>");
			
			//Enumeration : java.util 패키지에 있음. 배열처럼 데이터 그룹으로 구성된 Collection 객체 
			//				커서(cursor) 개념으로 접근 -> 첫번째 요소 앞에 커서 위치
			//제네릭(Generics) : Collection 객체에 담기는 데이터의 타입을 Collection 객체 생성시 미리 선언하는 기능
			//위 기능을 이용하여 Enumeration<String> 객체 안에 저장되는 데이터 타입을 String 으로 선언
		Enumeration<String> em = req.getHeaderNames();
			//요청정보의 헤더 안에 있는 정보 중 헤더 이름들만 모아 Enumeration 객체에 담아서 반환
			//반환된 값의 시작주소를 em 변수에 저장
		
		while (em.hasMoreElements()) {		//em 이 가리키는 Enumeration 객체의 커서 다음 데이터 유무판단
											// -> 있으면 true, 없으면 false 반복
											// -> 커서가 마지막 요소에 있을때 false 반환 후 while 반복문 종료 
			
			String s = em.nextElement();	//em 의 커서 다음에 있는 요소를 반환하고 커서를 다음 요소로 이동시킴
											//변수 <String>으로 선언하여 String 타입으로 반환
											//반환값은 String s 변수에 저장
			
			out.println(s + " : " + req.getHeader(s) + "<br/>");
					//s 변수에는 요청정보의 헤더 이름이 들어있음
					// -> 헤더 이름을 getHeader() 메소드 인자로 지정하면 해당 이름을 찾아 값을 반환(헤더 값 추출)
		}
		
		out.print("</body></html>");
		out.close();
	}

}
