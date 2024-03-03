package Ch04;

import java.util.Scanner;

public class C02Scanner {

	public static void main(String[] args) {

		System.out.println("-----------Scanner Test ----------");
		Scanner sc = new Scanner(System.in);

				System.out.print("정수 입력 :");
				int num1 = sc.nextInt();
				System.out.println("입력된 정수 값 : "+num1);
//				
//				System.out.print("실수 입력 :");
//				double num2 = sc.nextDouble();
//				System.out.println("입력된 실수 값 : "+num2);
//				
				System.out.print("문자열 입력 :");
				String str1 = sc.next();		//문자열입력받기기능함수,띄어쓰기는 포함하지않는다
				System.out.println("입력된 문자열 : "+str1);
//				System.out.print("입력 : ");
//				String s1 = sc.next();
//				String s2 = sc.next();
//				String s3 = sc.next();
//				System.out.printf("문자열 : %s %s %s\n",s1,s2,s3);

				System.out.print("문자열 입력 : " );
				String str = sc.nextLine();
				// 왜 nextLine()과 그 이외를 섞어쓰면 문제가 생길까?(line 이 먼저오면 상관 x, 다른게 먼저 오면 종료되어버림)
				// => nextInt : 가장 마지막 개행문자(엔터, newline) 제거 x, 스페이스바 나오면 값 나온걸로 처리
				// 개행문자전까지만 숫자로 입력받음
				
				// nextline 은 한줄을 입력받음. 버퍼에 입력된 문자열을 개행문자까지 가져옴
				
				// 같이 쓰면 nextline 안에 공백이 입력으로 처리되서 문제 발생
				
				// 같이쓰려면 중간에 nextLine(); 한번 더 삽입하거나 (버퍼공간 초기화 작업 필요)
				// nextLine()으로 받아서 parseInt 로 변경해서 출력해야함

				System.out.println("문자열 : " +  str);

		// 주의 사항!!여러개의 값을 Scanner 로 받을때
		


//		System.out.print("정수값 입력 : ");
//		int n1 = sc.nextInt();
//		System.out.println("정수값 : " + n1);
//		System.out.print("실수값 입력 : ");
//		double n2 = sc.nextDouble();
//
//		// 여기서 문제발생!
//		System.out.print("문자열입력 : ");
//		String str2 = sc.nextLine();
//		System.out.println("문자열 : " + str2);
//		System.out.print("문자열입력 : ");
//		
//
//		String str = sc.next();
//		System.out.println("문자열 : " + str);
//
//		System.out.println("프로그램을 종료합니다..");

	}
}
