package Ch07;

import java.util.Scanner;

public class C00While_Test2 {

	public static void main(String[] args) {
		// 구구단 출력(2단-9단)
		// 2단 출력시
//		int i = 1;
//		while(i<=9) {
//			System.out.println("2 x " + i + " = " + (2*i));
//			i++;
//		}
		
		// 단수의 반복 : dan = 2; dan<=9; dan++		// 미리 설정해주는게 좋음
		// 곱해주는 수의 반복 : i=0; i<=9; i++			// 미리 설정해주는게 좋음
		
//		int dan = 2;
//		int i;
//		while(dan<=9) {
//			i=1;
//			while(i<=9) {
//				System.out.printf("%d X %d = %d%n", dan, i, dan*i);
//				i++;
//			}
//			System.out.println();
//			dan++;
//		}
//		
		// 구구단 출력(9단-2단 : *1~*9)
//		int dan = 9;
//		int i;
//		while(dan>=2) {
//			i=1;
//			while(i<=9) {
//				System.out.printf("%d X %d = %d%n", dan, i, dan*i);
//				i++;
//			}
//			System.out.println();
//			dan--;
//		}
		// 구구단 출력(9단-2단 : *9~*1)
//		int dan = 9;
//		int i;
//		while(dan>=2) {
//			i=9;
//			while(i>=1) {
//				System.out.printf("%d X %d = %d%n", dan, i, dan*i);
//				i--;
//			}
//			System.out.println();
//			dan--;
//		}
		
		
		// 구구단 출력(2단-N단)
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dan=2;
		int i;
		while(dan<=N) {
			
			i=1;
			while(i<=9) {
				
				System.out.printf("%d x %d = %d\n",dan,i,dan*i);
				i++;
			}
			System.out.println();
			dan++;	
		}
	}
}






















