package ch2;

public class FloatToBinEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f = 9.1234567f;
		int i = Float.floatToIntBits(f);
		
		System.out.printf("%f%n", f);
		System.out.printf("%X%n", i);	// 16진수로 출력
	}	

}

/*	실수에는 무한소수가 존재 -> 오차 발생 가능
 * 
 * 	정규화
 * 		2진수로 변환된 실수를 저장할 때 '1.xxx * 2ⁿ' 형태로 변환
 * 		'1.'을 제외한 23자리의 2진수가 가수로 저장, 나머지는 잘라냄
 * 		2진수는 1이면 반올림 진행
 * */
