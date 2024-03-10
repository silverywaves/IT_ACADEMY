package Ch10;

import java.util.Arrays;
import java.util.Scanner;

// 배열	=> 컬렉션(자료구조class-List or Map)으로 더 많이 사용 & 대체
// 1차원 / 2차원 / 다차원
// 많은 연관된 데이터들(동일한 자료형)을 묶어서 저장 => 동일한 데이터타입의 여러 값들을 저장하기 위한 자료구조
// 기억장소가 연속적으로 할당
// 동적 확장 불가(파이썬, JS 는 가능)

public class C01ArrayMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr1 = new int[5];		// int[] arr1 or int arr1[] => 위치 상관 x
		arr1[0] = sc.nextInt();
		arr1[1] = sc.nextInt();
		arr1[2] = sc.nextInt();
		arr1[3] = sc.nextInt();
		arr1[4] = sc.nextInt();
		
		System.out.println("배열길이 : " + arr1.length);
//		System.out.println(arr1 instanceof Object);
		
		// 1. for 문
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		
//		// 2. 개량된 for 문
//		for(int val:arr1) {
//			System.out.println(val);
//		}
//		System.out.println();
//		
//		// 3. 람다의 stream 함수
//		Arrays.stream(arr1).forEach(item->System.out.println(item));
//		System.out.println();
//		Arrays.stream(arr1).forEach(System.out::println);				// 1.8 version 이상	
		
		// 최댓값, 최솟값 구하기
		int max = arr1[0];
		int min = arr1[0];
		for(int i=0;i<arr1.length;i++) {
			if(max<arr1[i]) {
				max = arr1[i];
				}
			if(min>arr1[i]) {
				min = arr1[i];
			}
		}
		System.out.printf("MAX : %d, MIN : %d\n", max, min);
		
		System.out.println(Arrays.stream(arr1).max().getAsInt());
		System.out.println(Arrays.stream(arr1).min().getAsInt());
		System.out.println(Arrays.stream(arr1).average().getAsDouble());
	
		// -------------------------------
		double arr2[] = new double[5];
	}
}
