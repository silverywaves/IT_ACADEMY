package ch4;

import java.util.*;

public class FlowEx17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		
		System.out.print("*을 출력할 라인의 수를 입력하세요.>");
		
		Scanner scanner = new Scanner(System.in);
		String tmp = scanner.nextLine();		// 화면을 통해 입력받는 내용을 tmp 에 저장
		num = Integer.parseInt(tmp);			// 입력받은 문자열(tmp)을 숫자로 변환
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
