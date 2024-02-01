package ch5;

public class ArrayEx06 {

	public static void main(String[] args) {
		// 배열의 모든 요소를 더해서 총합과 평균 구하기
		int sum = 0;			// 총점을 저장하기 위한 변수
		float average = 0f;		// 평균을 저장하기 위한 변수
		
		int[] score = {100, 88, 100, 100, 90};
		
		for(int i=0; i<score.length; i++) {
			sum += score[i];							// 반복문을 이용해 배열에 저장된 값 모두 더함
		}
		
		average = sum / (float)score.length;			// 계산결과를 배열의 개수로 나누어 평균 구하기
						// 결과를 float 로 얻기 위해 형변환 진행
		
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + average);

	}

}
