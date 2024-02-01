package ch5;

public class ArrayEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] score = new int[5];
		int k = 1;
		
		score[0] = 50;		// index 의 범위는 0부터 '배열길이-1' 까지
		score[1] = 60;
		score[k+1] = 70;	// score[2] = 70
		score[3] = 80;
		score[4] = 90;
		
		int tmp = score[k+2] + score[4];		// int tmp = score[3] + score[4]
		
		// for 문으로 배열의 모든 요소 출력
		for(int i=0; i<score.length; i++) {
			System.out.printf("score[%d]:%d%n", i, score[i]);
		}
		
		System.out.printf("tmp:%d%n", tmp);
		
		System.out.printf("score[%d]:%d%n", 7, score[7]);	// index 범위 벗어남(ArrayIndexOutOfBoundsException)
			// 컴파일시에는 문제가 없는 이유?!
			// 변수의 값을 index 로 사용시, 변수의 값은 실행시에 대입 -> 컴파일러가 미리 범위를 알 수 없음.
	}

}
