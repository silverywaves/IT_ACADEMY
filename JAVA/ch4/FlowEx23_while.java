package ch4;

public class FlowEx23_while {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// while (조건식) { 조건식의 연산결과가 참(true)인 동안 반복될 문장 }	- 조건식 생략 불가
		int i = 5;
		
		while(i--!=0) {		// i-- 후위형 => 조건식이 평가된 후 i 의 값 감소
							// ex. i 값이 1일 때, 조건식이 참으로 평가된 후 1 감소되어 0 출력
			System.out.println(i + "- I can do it.");
		}
	}

}
