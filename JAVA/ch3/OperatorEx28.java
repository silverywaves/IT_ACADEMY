package ch3;

public class OperatorEx28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0xAB, y = 0xF;
		
		System.out.printf("x = %#X \t\t%s%n", x, toBinaryString(x));	// toBinaryString() : 4byte 정수를 32자리 2진수로 변환
		System.out.printf("y= %#X \t\t%s%n", y, toBinaryString(y));
		System.out.printf("%#X | %#X = %#X \t%s%n", x, y, x | y, toBinaryString(x | y));
		System.out.printf("%#X & %#X = %#X \t%s%n", x, y, x & y, toBinaryString(x & y));
		System.out.printf("%#X ^ %#X = %#X \t%s%n", x, y, x ^ y, toBinaryString(x ^ y));
		System.out.printf("%#X ^ %#X ^ %#X = %#x %s%n", x, y, y, x ^ y ^ y, toBinaryString(x ^ y ^ y));
	}		// main 끝
	
	static String toBinaryString(int x) {
		String zero = "00000000000000000000000000000000";
		String tmp = zero + Integer.toBinaryString(x);
		return tmp.substring(tmp.length()-32);
	}

}
/*	비트연산자
 * 		피연산자를 비트단위로 논리 연산, 정수(문자 포함)만 허용. 실수 허용 x
 * 		피연산자의 타입을 일치시키는 산술 변환 일어날 수 있음
 * 
 * 		< 2진수 표현시 >
 * 		| (OR연산자)	: 피연산자 중 한 쪽의 값이 1이면, 결과는 1. 그 외에는 0
 * 						  주로 특정 비트의 값을 변경할 떄 사용
 * 		& (AND연산자)	: 피연산자 양 쪽이 모두 1이어야만 결과가 1. 그 외에는 0
 * 						  주로 특정 비트의 값을 뽑아낼 때 사용
 * 		^ (XOR연산자)	: 피연산자의 값이 서로 다를 때만 결과가 1. 그 외에는 0
 * 						  배타적 XOR(eXclusive OR) <- 배타적인 경우(값이 서로 다름)에만 참(1)
 * 						  간단한 암호화에 사용
 * */
