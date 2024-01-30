package ch4;

import java.util.*;		// Scanner 클래스를 사용하기 위해 추가

public class FlowEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input;
		
		System.out.print("숫자를 하나 입력하세요.>");
		
		Scanner scanner = new Scanner(System.in);
		String tmp = scanner.nextLine();		// 화면을 통해 입력받은 내용을 tmp 에 저장
		input = Integer.parseInt(tmp);			// 입력받은 문자열(tmp)을 숫자로 변환
		
		if(input==0) {
			System.out.println("입력하신 숫자는 0입니다.");
		}	// 블럭(block)-{}로 여러 문장을 하나의 단위로 묶은 것 -> '}' 다음에 ';' 안붙임
		if(input!=0)	// 블럭 내의 문장이 하나뿐일 때는 괄호{} 생략 가능
			System.out.println("입력하신 숫자는 0이 아닙니다.");		// if 문에 속한 문장
			System.out.printf("입력하신 숫자는 %d입니다.", input);		// if 문 밖의 문장 => 항상 출력
	}

}
