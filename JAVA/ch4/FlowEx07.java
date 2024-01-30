package ch4;

import java.util.*;

public class FlowEx07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("가위(1), 바위(2), 보(3) 중 하나를 입력하세요.>");
		
		Scanner scanner = new Scanner(System.in);
		int user = scanner.nextInt();			// 화면을 통해 입력받은 숫자를 user 에 저장
		int com = (int)(Math.random()*3) + 1;	// 1,2,3 중 하나가 com 에 저장. ( 1 <= Math.random() < 4)
						// 0.0 <= Math.random() < 1.0	: 해당 범위에 속하는 하나의 double 값 반환
		
		System.out.println("당신은 " + user + "입니다.");
		System.out.println("컴은 " + com + "입니다.");
		
		switch(user-com) {
			case 2: case -1:
				System.out.println("당신이 졌습니다.");
				break;
			case 1: case -2:
				System.out.println("당신이 이겼습니다.");
				break;
			case 0:
				System.out.println("비겼습니다.");
				break;							// 마지막 문장이므로 break 생략 가능
		}
	}

}
