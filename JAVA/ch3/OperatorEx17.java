package ch3;

public class OperatorEx17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 실수형 변수 pi 의 값을 소수점 셋째자리까지 표현하기(넷째 자리에서 반올림)
		double pi = 3.141592;
		double shortPi = (int)(pi * 1000 + 0.5) / 1000.0;	// 반올림을 위해 0.5 더함
															// 1000 으로 나누면 3 출력
		
		System.out.println(shortPi);
	}

}
