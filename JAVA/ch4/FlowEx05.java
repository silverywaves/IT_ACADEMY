package ch4;

import java.util.*;

public class FlowEx05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 0;
		char grade = ' ', opt = '0';
		
		System.out.print("점수를 입력해주세요.>");
		
		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt();		// 화면을 통해 입력받은 점수를 score 에 저장
		
		System.out.printf("당신의 점수는 %d입니다.%n", score);
		
		if (score >= 90) {
			grade = 'A';
			if (score >= 98) {
				opt = '+';
			} else if (score < 94) {
				opt = '-';
			}
		} else if (score >= 80) {
			grade = 'B';
			if (score >= 88) {
				opt = '+';
			} else if (score < 84) {
				opt = '-';
			}
		} else {
			grade = 'C';
		}
		System.out.printf("당신의 학점은 %c%c입니다. %n", grade, opt);
	}

}
/*	중첩 if 문 => if 문의 블럭 내에 또 다른 if 문을 포함
 * 		if (조건식1) {
 * 			조건식1의 연산결과가 true 일 때 수행될 문장
 * 			if (조건식2) {
 * 				조건식1과 조건식2가 모두 true 일 때 수행될 문장
 * 			} else {
 * 				조건식1이 true, 조건식2가 false 일 때 수행될 문장
 * 			}
 * 		} else {
 * 			조건식1이 false 일 때 수행되는 문장
 * 		}
 * */
