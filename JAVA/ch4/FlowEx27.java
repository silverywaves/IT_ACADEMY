package ch4;

import java.util.*;

public class FlowEx27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 사용자로부터 반복해서 숫자를 입력받다가 0을 입력하면 입력을 마치고 총 합 출력
		int num;
		int sum = 0;
		boolean flag = true;	// while 문의 조건식으로 사용될 변수 : 고정된 값 유지 -> 무한반복문 -> 반복 멈추게 할 if 문 필수
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("합계를 구할 숫자를 입력하세요.(끝내려면 0을 입력)");
		
		while(flag) {	// flag 의 값이 true 이므로 조건식은 참
			System.out.print(">>");
			
			String tmp = scanner.nextLine();
			num = Integer.parseInt(tmp);
			
			if(num!=0) {
				sum += num;		// num 이 0이 아니면, sum 에 더함
			} else {
				flag = false;	// num 이 0이면, flag 의 값을 false 로 변경(반복 정지)
			}
		}	// while 문 종료
		System.out.println("합계:" + sum);
	}

}
