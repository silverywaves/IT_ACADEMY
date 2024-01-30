package ch4;

import java.util.*;		// Scanner 클래스를 사용하기 위해 추가

public class FlowEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("숫자를 하나 입력하세요.>");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();				// 화면을 통해 입력받은 숫자를 input 에 저장
		
		if(input==0) {
			System.out.println("입력하신 숫자는 0입니다");
		} else {	// input!=0 인 경우
			System.out.println("입력하신 숫자는 0이 아닙니다");
		}
	}

}
/*	if-else 문	=> 두 개의 블럭 중 한 블럭의 내용을 수행하고 if 문을 벗어남
 * 		if (조건식) {
 * 			조건식이 참(true)일 때 수행될 문장
 * 		} else {
 * 			조건식이 거짓(false)일 때 수행될 문장
 * 		}
 * */
