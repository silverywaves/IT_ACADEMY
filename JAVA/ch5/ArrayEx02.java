package ch5;

public class ArrayEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] score = new int[5];		// 길이가 5인 int 형 배열 생성 & int 형 기본값 0으로 초기화
		score[0] = 50;					// 각 요소에 직접 값 저장
		score[1] = 60;
		score[2] = 70;
		score[3] = 80;
		score[4] = 90;
			// 배열의 길이가 큰 경우 for 문 사용이 효율적
			// => for 문 배열 초기화 규칙
		
		int[] score1 = new int[] {50, 60, 70, 80, 90};	// 배열 생성 & 초기화 동시진행. {}내 개수로 배열길이 자동 결정 -> []내 길이 생략 가능
		int[] score2 = {50, 60, 70, 80, 90};			// new int[] 생략 가능
		
		int[] score3;
//		score3 = {50, 60, 70, 80, 90};					// 에러. 배열의 선언과 생성을 따로 하는 경우엔 'new 타입[]' 생략 불가
		score3 = new int[] {100, 90, 80, 70, 60};		// OK
		
//		int add(int[] arr) {/* 내용 생략 */}			// 매개변수로 int 배열을 받는 add 메서드의 정의
//		int result = add({100, 90, 80, 70, 60});		// 에러. 'new 타입[]' 생략 불가
//		int result = add(new int[] {100, 90, 80, 70, 60});
		
		
		// {} 안에 아무것도 넣지 않으면 길이가 0인 배열 생성
		// 참조변수 기본 값은 null 이지만, 배열을 가리키는 참조변수는 길이가 0인 배열로 초기화 하기도 함
		int[] score4 = new int[0];		
		int[] score5 = new int[] {};	
		int[] score6 = {};
		
	}

}
