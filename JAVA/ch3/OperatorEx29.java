package ch3;

public class OperatorEx29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte p = 10;
		byte n = -10;
		
		System.out.printf(" p = %d \t%s%n", p, toBinaryString(p));			// 양의 정수 p
		System.out.printf("~p = %d \t%s%n", ~p, toBinaryString(~p));
		System.out.printf("~p+1 = %d \t%s%n", ~p+1, toBinaryString(~p+1));	// p 에 대한 음의 정수
		System.out.printf("~~p = %d \t%s%n", ~~p, toBinaryString(~~p));		// p 에 비트 전환 연산 2번 적용 => 원래의 값
																			// 단, 연산결과 타입은 byte 가 아닌 int
		System.out.println();
		System.out.printf("n = %d%n", n);									// 음의 정수 n
		System.out.printf("~(n-1) = %d%n", ~(n-1));							// n 에 대한 양의 정수
	}
	
	// 10진 정수를 2진수로 변환하는 메서드
	static String toBinaryString(int x) {
		String zero = "00000000000000000000000000000000";
		String tmp = zero + Integer.toBinaryString(x);
		return tmp.substring(tmp.length()-32);
	}

}
/*	비트 전환 연산자 ~
 * 		피연산자를 2진수로 표현했을 때, 0은 1로, 1은 0으로 바꿈. (! 와 유사)
 * 		부호있는 타입의 피연산자는 부호가 반대로 변경 => 피연산자의 1의 보수 얻을 수 있음 => 1의 보수 연산자
 * */
