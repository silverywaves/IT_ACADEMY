package ch1;	// 패키지 선언

// 패키지 가져오기
import java.util.*;	// 해당 패키지 내 모든 클래스 불러옴

public class Hello {	// 클래스블록

	public static void main(String[] args) {	// main 메서드의 선언문(main 메서드 블록)
	// public||private||protected static void[리턴자료형/void는 리턴값 없음] 메서드명(입력자료형, 매개변수)
		System.out.println("Hello, world.");	// 화면에 글자를 출력
		
		System.out.println("Hello, /* 이것은 주석 아님*/ world.");
		System.out.println("Hello, world. // 이것도 주석 아님");
		
		
	}

}

//큰따옴표(") 안에 주석이 있을 때는 주석이 아닌 문자열로 인식
