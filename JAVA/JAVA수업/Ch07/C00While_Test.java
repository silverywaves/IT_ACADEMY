package Ch07;

import java.util.Scanner;

public class C00While_Test {

	public static void main(String[] args) {
		// 변수의 초기값 / 조건식 / 연산작업 정리
		Scanner sc = new Scanner(System.in);
		
		// N - M 까지의 합을 구합니다.(N<M)
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//		int i = N;
//		int sum = 0;
//		while(i<=M) {
//			sum += i;
//			i++;
//		}
//		System.out.println(sum);
//		-2-
//		for(int i=N;i<=M;i++) {
//			sum += i;
//		}
//		System.out.println(sum);
//		
//		-------------------------------------------------------------------
//		//01 1 - N 까지 수중에 짝수/홀수의 합을 각각 출력
//		int N = sc.nextInt();
//		int sum1 = 0;
//		int sum2 = 0;
//		int i = 0;
//		while(i<=N) {
//			if(i%2==0) {
//				sum1 += i;
//				i++;
//			}else {
//				sum2 += i;
//				i++;
//			}
//		}
//		System.out.println("짝수합 : " + sum1);
//		System.out.println("홀수합 : " + sum2);

//		-2-
//		for(int i=1;i<=N;i++) {
//			if(i%2==0) {
//				sum1 += i;
//			} else {
//				sum2 += i;
//			}
//		}
//		System.out.println("짝수합 : " + sum1);
//		System.out.println("홀수합 : " + sum2);
//		
		//1 - N 까지 수중에 3의 배수만 출력하고 그합도 출력
//		int N = sc.nextInt();
//		int i = 0;
//		int sum = 1;
//		while(i<=N) {
//			if(i%3==0) {
//				sum += i;
//				System.out.println(i);
//				i++;
//			}
//		}System.out.println(sum);
//		-------------------------------------------------------------
		
		//1 - N까지 수중에 4의 배수를 출력하고 4의배수가 아닌 나머지의 합을 구하세요
//		int N = sc.nextInt();
//		int i = 1;
//		int sum = 0;
//		while(i<=N){
//			if(i%4==0) {
//				System.out.println(i);
//				i++;
//			}else {
//				sum += i;
//				i++;
//			}
//		} 
//		System.out.println(sum);
//		----------------------------------------------------------------

		
		//구구단 N 단 역순출력(N<=9)
//		int N = sc.nextInt();
//		int i = 9;
//		while(i>=1) {
//			System.out.println(N + " * " + i + " = " + N*i);
//			i--;
//		}
//		----------------------------------------------------------------
		
		// 양의 정수를 입력받아서 소수인지 아닌지를 판별하는 코드 작성
		// 소수 : 약수가 1과 자기 자신뿐인 수
//		int num = sc.nextInt();
//	
//		int i = 2;
//		boolean is소수 = true;
//		while(i<num) {
//			if(num%i==0) {
//				is소수=false;
//				break;
//			}
//			i++;
//		}
//		if(num<=1) {
//			System.out.println(num + "은 소수가 아닙니다.");
//		} else {
//			if(!is소수)
//				System.out.println(num + "은 소수가 아닙니다.");
//			else
//				System.out.println(num + "은 소수입니다.");
//		}
//		------------------------------------------------------------------
		
		//정수값을 입력받아서 처리합니다 (String x)
		//입력 : 1234
		//출력 : 4321

//		N%10;	//4
//		(N/10)%10;	//123%10 = 3
//		((N/10)/10)%10;	// 12%10 = 2
//		((N/10)/10)/10;	// 12/10 = 1
		
//		---------------------------------------------------------------------
//		System.out.print("입력 : " );
//		int num = sc.nextInt();
		
		//자리수 구하기 1234 -> 4 , 12345 -> 5
//		int digit=0;
//		int tmp = num;
//		int result=0;
//		while(tmp!=0) {
//			digit++;
//			tmp=tmp/10;
//		}
////		System.out.println("자리수 : " + digit);
//		
//		while(num!=0) {
//			//System.out.println("num : " + num);
//			//System.out.print((num%10));
//			result += (int) ((num%10)*(Math.pow(10, digit-1)));	// 제곱 계산
//			digit--;
//			num=num/10;
//		}
//		System.out.println("출력 : " + result);
				
		//문자열로 처리
//		String num_2 = num+"";
//		String tmp ="";
//		for(int i=num_2.length()-1; i>=0 ;i--) {
//			tmp = tmp+num_2.charAt(i);
//		}
//		System.out.println("출력 : " + Integer.parseInt(tmp));
//		---------------------------------------------------------------------------
		
		
		// 이중 while 문제 -> 나중에 풀기
		//자연수 n을 입력받아 "출력 예"와 같이 n x n크기에 공백으로 구분하여 출력되는 프로그램을 작성하시오. 
		//10 미만의 홀수만 출력하시오.
		// 주의! 숫자는 공백으로 구분하되 줄사이에 빈줄은 없다.
		//입력 : 3
		//출력 :
		//1 3 5
		//7 9 1
		//3 5 7
		
//		---------------------------------------------------------------------------
//		개행도 문자라고 생각하고 풀기.
		//별찍기(그냥찍기/높이입력받아서 찍기)=>미리 바뀌어야하는 값 정리해두고 풀어야 나중에 안헷깔림
//		높이 : 4		=> 개행 4번
//		****
//		****
//		****
//		****
		
//		행증가(i) : i=0; i<4; i++
//		높이 : n
		
//
////		----------------------------- 그냥 찍기
//			int i = 0;	// 행증가
//			int j = 0;	// 별찍기
//			while(i<4) {
//				j=0;
//				while(j<4) {
//					System.out.print("*");
//					j++;
//				}
//				System.out.println();
//				i++;
//			}
//		
////		----------------------------- 높이입력받아서 찍기
//			int n = sc.nextInt();
//			
//			for(int i=0;i<n;i++) {
//			  for(int j=0;j<n;j++) {
//				  System.out.print("*");
//			  }  
//			  System.out.println();
//			 }
//
//			-2-
//			int i = 0;
//			int j = 0;
//			while(i<n) {
//				j=0;
//				while(j<n) {
//					System.out.print("*");
//					j++;
//				}
//				System.out.println();
//				i++;
//			}
		
		
		
////	----------------------------- 그냥 찍기
//		
//		높이 : 4			i		j
//		*				0		0-0
//		**				1		0-1
//		***				2		0-2
//		****			3		0-3
//					i=0;i<4;i++		j=0;j<=i;j++
//		int i = 0;
//		int j = 0;
//		while(i<4) {
//			j=0;
//			while(j<=i) {
//				System.out.print("*");
//				j++;
//			}
//		System.out.println();
//		i++;
//	}
//		-2-
//		for(int i=0;i<4;i++) {
//			for(int j=0;j<=i;j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
////	----------------------------- 높이입력받아서 찍기
//		int n = sc.nextInt();
//		int i = 0;
//		int j = 0;
//		while(i<n) {
//			j=0;
//				while(j<=i) {
//					System.out.print("*");
//					j++;
//				}
//			System.out.println();
//			i++;
//		}		
//		-2-
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<=i;j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
	
//		--------------------------------------------------------
//		높이 : 4		i		j
//		****		0		0-3
//		***			1		0-2
//		**			2		0-1
//		*			3		0-0
//				i=0;i<4;i++ j=3;j>=i;j--
		
//		int i = 0;
//		int j = 0;
//		while(i<4) {
//			j=3;
//				while(j>=i) {
//					System.out.print("*");
//					j--;
//				}
//			System.out.println();
//			i++;
//		}
//		-2-
//		for(int i=0; i<4; i++) {
//			for(int j=3; j>=i; j--) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
////	----------------------------- 그냥 찍기
//					
//		높이 : 4		i		j(공백)		k(별)
//		   *		0		0-2			0-0
//		  ***		1		0-1			0-2
//		 *****		2		0-0			0-4
//		*******		3		-			0-6
//			i=0;i<4;i++ / j=0;j<=3-i;j++ / k=0;k<=i*2;k++
//		int i = 0;
//		int j = 0;
//		int k = 0;
//		while(i<4) {
//			// 공백
//			j=0;
//			while(j<=3-i) {
//				System.out.print(" ");
//				j++;
//			}
//			// 별
//			k = 0;
//			while(k<=i*2) {
//				System.out.print("*");
//				k++;
//			}
//			System.out.println();
//			i++;
//		}
//		--------------------------------------------------
//		높이를 입력받아 찍기
//		int n = sc.nextInt();	// 입력받는 높이
//		int i = 0;	// 행
//		int j = 0;	// 공백
//		int k = 0;	// 별
//		while(i<n) {
//			j=0;
//			while(j<=(n-2)-i) {
//				System.out.print(" ");
//				j++;
//			}
//			k=0;
//			while(k<=i*2) {
//				System.out.print("*");
//				k++;
//			}
//			System.out.println();
//			i++;
//		}
//		-2-
//		정삼각형 피라미드의 *은 홀수로 증가, 공백은 총높이-행
//		높이(n) : 6		i(행)	공백			별
//		12345*			1		5			1
//		1234***			2		4			3
//		125*****		3		3			5
//		12*******		4		2			7
//		1*********		5		1			9
//		***********		6		0			11
//							n(총높이)-i(행)  (i(행)*2)-1
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=n-i;j++) {		// j 가 n-1 보다 작거나 같으면 공백 출력
//				System.out.print(" ");
//			}
//			for(int j=1;j<=(i*2)-1;j++) {	// j 가 (i*2)-1 보다 작거나 같으면 * 출력
//				System.out.print("*");
//			}
//			System.out.println();			// 줄바꿈
//		}
		
		
////	----------------------------- 높이입력받아서 찍기			
		
		
		
		
//		
//		높이 : 4		
//		*******		1	-	7
//		 *****		2	1	5
//		  ***		3	2	3
//		   *		4	3	1
//		int n = sc.nextInt();
//		for(int i=n;i>0;i--) {
//			for(int j=n-i;j>0;j--) {
//				System.out.print(" ");
//			}
//			for(int j=(i*2)-1;j>0;j--) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
//		높이 : 7		
//		   *
//		  ***
//		 *****
//		*******	
//		 *****
//		  ***
//		   *
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=(i*2)-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=n-1;i>0;i--) {
			for(int j=n-i;j>0;j--) {
				System.out.print(" ");
			}
			for(int j=i*2-1;j>0;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
//	   높이 : 7
//		*******	   
//		 *****
//		  ***
//		   *
//	      ***
//		 *****
//		*******	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
