package ch7;

import java.text.SimpleDateFormat;
import java.util.Date;

public class _11_ImportTest {

	public static void main(String[] args) {
		// 현재 날짜와 시간을 지정된 형식에 맞춰 출력하는 예제
		Date today = new Date();
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
		
		System.out.println("오늘 날짜는 " + date.format(today));
		System.out.println("현재 시간은 " + time.format(today));
	}
}
/*	import 문
 * 	- 컴파일러에게 소스파일에 사용된 클래스의 패키지에 대한 정보 제공
 * 	- 모든 소스파일(.java)에서 package 문 다음 & 클래스 선언문 이전에 위치
 * 	- 여러번 선언 가능
 * 	- import 패키지명.클래스명;	or	import 패키지명.*;
 * 		- 단, * 는 하위 패키지의 클래스까지 포함하는 것은 아니라는 점
 * 	- 단축키 : ctrl+shift+o
 * */
