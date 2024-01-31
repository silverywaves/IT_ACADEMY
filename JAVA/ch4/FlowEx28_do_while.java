package ch4;

import java.util.*;

public class FlowEx28_do_while {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 0, answer = 0;
		
		answer = (int)(Math.random() * 100) + 1;	// 1~100 사이의 임의의 수를 저장
		Scanner scanner = new Scanner(System.in);
		
		// do { 조건식의 연산결과가 참일 때 수행될 문장 } while (조건식);	<- 끝에 ';' 조심
		do {
			System.out.print("1과 100 사이의 정수를 입력하세요.>");
			input = scanner.nextInt();
			
			if(input > answer) {
				System.out.println("더 작은 수로 다시 시도해보세요.");
			} else if(input < answer) {
				System.out.println("더 큰 수로 다시 시도해보세요.");
			}
		} while(input!=answer);		// input 과 answer 이 다른 동안 반복 -> 같아지면 중단
		System.out.println("정답입니다.");
	}

}
