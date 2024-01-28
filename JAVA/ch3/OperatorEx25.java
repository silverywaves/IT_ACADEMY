package ch3;

import java.util.*;		// Scanner 클래스를 사용하기 위해 추가

public class OperatorEx25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		char ch = ' ';
		
		System.out.printf("문자를 하나 입력하세요.>");
		
		String input = scanner.nextLine();
		ch = input.charAt(0);
		
		if('0'<=ch && ch<='9') {						// 조건문 if : () 안의 연산결과가 참인 경우 블럭{} 내 문장 수행
			System.out.printf("입력하신 문자는 숫자입니다.%n");
		}
		
		if(('a'<=ch && ch<='z') || ('A'<=ch && ch<='Z')) {
			System.out.printf("입력하신 문자는 영문자입니다.%n");
		}
	}	// main

}
