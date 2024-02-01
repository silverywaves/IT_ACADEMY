package ch5;

import java.util.*;		// Arrays.toString() 사용을 위해 추가

public class ArrayEx03 {
 
	public static void main(String[] args) {
		int[] iArr1 = new int[10];	// 길이가 10인 int 형 배열 생성
		int[] iArr2 = new int[10];
//		int[] iArr3 = new int[] {100, 95, 80, 70, 60};		<- new int[] 생략 가능
		int[] iArr3 = {100, 95, 80, 70, 60};
		char[] chArr = {'a', 'b', 'c', 'd'};
		
		for(int i=0; i<iArr1.length; i++) {
			iArr1[i] = i + 1;
		}
		
		for(int i=0; i<iArr2.length; i++) {
			iArr2[i] = (int)(Math.random()*10) + 1;
		}
		// 배열에 저장된 값 출력
//		for(int i=0; i<iArr1.length; i++) {
//			System.out.println(iArr1[i]);		// 줄바꿈 O. 배열의 요소를 순서대로 하나씩 출력
//		}
		for(int i=0; i<iArr1.length; i++) {
			System.out.print(iArr1[i]+",");		// 줄바꿈 X. 각 요소간의 구별을 위해 쉼표 추가
		}
		System.out.println();					// 다음 출력이 바로 이루어지지 않도록 줄바꿈

		// Arrays.toString(배열이름) : 배열의 모든 요소를 [첫번째 요소, 두번째 요소,...] 형식의 문자열로 반환
		System.out.println(Arrays.toString(iArr2));
		System.out.println(Arrays.toString(iArr3));
		System.out.println(iArr3);				// 배열을 가리키는 참조변수 iArr3의 값 출력('타입@주소' 형식)
		System.out.println(Arrays.toString(chArr));
		System.out.println(chArr);				// 각 요소가 구분자 없이 출력 <- println 메서드가 char 배열일때만 이렇게 동작하도록 작성됨
	}

}
