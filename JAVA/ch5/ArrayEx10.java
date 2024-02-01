package ch5;

import java.util.*;		// Arrays.toString() 사용을 위해 추가

public class ArrayEx10 {

	public static void main(String[] args) {
		// 불연속적인 값들로 배열을 초기화
		int[] code = {-4, -1, 3, 6, 11};	// 불연속적인 값들로 구성된 배열
		int[] arr = new int[10];
		
		for(int i=0; i<arr.length; i++) {
			int tmp = (int)(Math.random()*code.length);	// code 길이 5 => tmp 에 0~4 범위의 임의의 정수 저장(index 번호와 일치)
//			int tmp = (int)(Math.random()*5);			// tmp 에 0, 1, 2, 3, 4 중의 하나가 저장
			arr[i] = code[tmp];							// ex. i=0, tmp=4
//			arr[0] = code[4];							  code[4]는 배열 code 의 5번째 요소이므로 11
//			arr[a] = 11;								  arr[0]에 11 저장
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
/* 연속적인 범위의 임의의 값으로 채우는 것은 random() 으로 가능
 * 	for(i=0; i<arr.length; i++){
 * 		arr[i] = (int)(Math.random()*5);	// 0~4 범위의 임의의 값 저장
 * 	}
 * */
