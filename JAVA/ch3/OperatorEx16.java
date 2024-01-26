package ch3;

public class OperatorEx16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 실수형 변수 pi 의 값을 소수점 셋째자리까지 표현하기
		float pi = 3.141592f;
		float shortPi = (int)(pi * 1000) / 1000f;
		System.out.println(shortPi);
	}

}
/*	주의 : int / int = int , 나눗셈의 결과를 버림 (반올림 x)
 * 
 * 		(int)(pi * 1000) / 1000f;
 * 		-> (int)(3141.592f) / 1000f;
 * 		-> 3141 / 1000f;
 * 		-> 3141.0f / 1000f;
 * 		-> 3.141f
 * 
 * */
