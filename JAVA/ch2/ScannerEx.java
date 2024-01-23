package ch2;

import java.util.*;		// Scanner 사용을 위해 추가

public class ScannerEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);	// Scanner 클래스 객체 생성
		
		System.out.print("두자리 정수를 하나 입력해주세요.>");
		String input = scanner.nextLine();	// 입력받은 내용을 input 에 저장
		int num = Integer.parseInt(input);	// 입력받은 내용을 int 타입의 값으로 변환
											// => 문자열을 숫자로 변환
		
		System.out.println("입력내용 :"+input);
		System.out.printf("num=%d%n", num);
	}

}

/*	int num = scanner.nextInt();	// 정수를 입력받아서 변수 num 에 저장
 * 									 but 화면에서 연속적으로 값을 입력받아 사용하기에 까다로움
 */