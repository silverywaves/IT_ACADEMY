package ch5;

public class ArrayEx09 {

	public static void main(String[] args) {
		// 배열의 요소의 순서를 반복해서 바꿈(shuffle) - 카드섞기, 로또번호생성 등
		int[] ball = new int[45];		// 45개의 정수값을 저장하기 위한 배열 생성
		
		// 배열의 각 요소에 1~45 값 저장
		for(int i=0; i<ball.length; i++) {
			ball[i] = i + 1;		// ball[0] 에 1 저장
		}
		
		int temp = 0;		// 두 값을 바꾸는데 사용할 임시변수
		int j = 0;			// 임의의 값을 얻어서 저장할 변수
		
		// 배열의 i 번째 요소와 임의의 요소에 저장된 값을 서로 바꿔서 값을 섞음
		// 0번째부터 5번째 요소까지 모두 6개만 변경
		for(int i=0; i<6; i++) {
			j = (int)(Math.random()*45);	// 0~44 범위의 임의의 값을 얻음
			temp = ball[i];
			ball[i] = ball[j];
			ball[j] = temp;		// ball[i]와 ball[j]의 값을 서로 바꿈
		}
		
		// 배열 ball 의 앞에서부터 6개의 요소 출력
		for(int i=0; i<6; i++) {
			System.out.printf("ball[%d]=%2d%n", i, ball[i]);
		}
	}

}
