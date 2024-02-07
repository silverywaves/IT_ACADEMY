package ch5;

public class ArrayEx19 {

	public static void main(String[] args) {
		int[][] score = {
							{100, 100, 100},
							{20, 20, 20},
							{30, 30, 30},
							{40, 40, 40}
						};	// 생성과 초기화 동시 가능
		
		int sum = 0;
		
		for(int i=0; i<score.length;i++) {
			for(int j=0; j<score[i].length; j++) {
				System.out.printf("score[%d][%d]=%d%n", i, j, score[i][j]);
			}
		}
		
		for(int[] tmp : score) {		// score 의 각 요소(1차원 배열 주)를 tmp 에 저장
			for (int i: tmp) {			// tmp 는 1차원 배열을 가리키는 참조변수
				sum += i;
			}
		}
		
		System.out.println("sum=" + sum);
		
	}

}
