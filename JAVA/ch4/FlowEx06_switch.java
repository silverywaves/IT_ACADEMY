package ch4;

import java.util.*;

public class FlowEx06_switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("현재 월을 입력하세요.>");
		
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();		// 화면을 통해 입력받은 숫자를 month 에 저장
		
		switch(month) {
			case 3:
			case 4:
			case 5:
				System.out.println("현재의 계절은 봄입니다.");
				break;
			case 6: case 7: case 8:
				System.out.println("현재의 계절은 여름입니다.");
				break;
			case 9: case 10: case 11:
				System.out.println("현재의 계절은 가을입니다.");
				break;
			default:
			// case 12: case 1: case 2:
				System.out.println("현재의 계절은 겨울입니다.");
		}
	}

}
/*	switch 문
 * 		- 하나의 조건식으로 많은 경우의 수 처리 가능
 * 		- 조건식 계산 -> 결과 일치 case 문으로 이동 -> 이후 문장 수행 -> break 문 or switch 문의 끝에서 종료
 * 		- 일치 결과 없을 경우 default 문으로 이동
 * 		- 제약조건
 * 			- case 문의 값 : 정수 상수만 가능(변수, 실수, 문자열 불가), 중복 x
 * 			- switch 문의 조건식 결과 : 정수 또는 문자열
 * */
