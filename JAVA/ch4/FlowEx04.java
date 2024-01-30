package ch4;

import java.util.*;

public class FlowEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 0;			// 점수를 저장하기 위한 변수
		char grade = ' ';		// 학점을 저장하기 위한 변수. 공백으로 초기화
		
		System.out.print("점수를 입력하세요.>");
		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt();	// 화면을 통해 입력받은 숫자를 score 에 저장
		
		if (score >= 90) {			// score 90점 이상이면 A 학점
			grade = 'A';
		} else if (score >= 80) {	// score 80점 이상이면 B 학점
			grade = 'B';
		} else if (score >= 70) {	// score 70점 이상이면 C 학점
			grade = 'C';
		} else {					// 나머지는 D 학점
			grade = 'D';
		}
		
		System.out.println("당신의 학점은 " + grade + "입니다.");
		
	}

}
/*	if-else if 문 => 처리해야할 경우의 수가 셋 이상
 * 		if (조건식1) {
 * 			조건식1의 연산결과가 참일 때 수행될 문장
 * 		} else if (조건식2) {
 * 			조건식2의 연산결과가 참일 때 수행될 문장
 * 		} else if (조건식3) {	// 여러개의 else if 사용 가능
 * 			조건식3의 연산결과가 참일 때 수행될 문장
 * 		} else {				// 마지막에는 보통 else 블럭으로 끝, 생략 가능 -> 어떤 블럭도 수행 x 가능성有
 * 			위의 어느 조건식도 만족하지 않을 때 수행될 문장
 * 		}
 * */
