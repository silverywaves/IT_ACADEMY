package ch7;

import static java.lang.Integer.*;		// Integer 클래스의 모든 static 메서드
import static java.lang.System.out;		// System.out 을 out 만으로 참조 가능
//import static java.lang.Math.random;	// Math.random() 만
import static java.lang.Math.*;

public class _12_StaticImportEx1 {

	public static void main(String[] args) {
		// System.out.println(Math.random());
		out.println(random());
		
		// System.out.println("Math.PI : " + Math.PI);
		out.println("Math.PI : " + Math.PI);
	}
}
/*	static import 문
 * 	- static 멤버를 호출할 때 클래스 이름 생략 가능
 * */
