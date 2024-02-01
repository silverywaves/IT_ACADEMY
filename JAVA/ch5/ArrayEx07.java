package ch5;

public class ArrayEx07 {

	public static void main(String[] args) {
		// 배열의 요소 중 제일 큰 값과 제일 작은 값 찾기
		int[] score = {79, 88, 91, 33, 100, 55, 95};
		
		int max = score[0];		// 배열의 첫번째 값으로 최대값을 초기화
		int min = score[0];		// 배열의 첫번째 값으로 최소값을 초기화
		
		for(int i=1; i<score.length; i++) {		// 배열의 두번째 요소부터 읽기 위해 변수 i 의 값을 1로 초기화
			if(score[i] > max) {
				max = score[i];
			} else if(score[i] < min) {
				min = score[i];
			}
		} // end of for
		
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	} // end of main

}
