package ch4;

public class FlowEx31_continue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1~10 사이의 숫자 중 3의 배수 제외하여 출력
		for(int i=0; i<=10; i++) {
			if(i%3==0)
				continue;	// 참의 경우 continue 문~반복문 블럭 끝'}' 사이의 문장 건너뜀
			System.out.println(i);
		}
	}

}
/*	continue 문
 * 		- 반복문 내에서만 사용
 * 		- 반복문의 끝으로 이동하여 다음 반복 수행 -> 전체 반복 중 특정조건을 만족하는 경우 제외시 사용
 * 		- for 문 : 증감식으로 이동 / while 문 & do-while 문 : 조건식으로 이동
 * */
