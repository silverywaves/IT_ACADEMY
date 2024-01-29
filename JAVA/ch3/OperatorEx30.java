package ch3;

public class OperatorEx30 {

	// 10진 정수를 2진수로 변환하는 메서드
	static String toBinaryString(int x) {
		String zero = "00000000000000000000000000000000";
		String tmp = zero + Integer.toBinaryString(x);
		return tmp.substring(tmp.length()-32);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dec = 8;
		
		System.out.printf("%d >> %d = %4d \t%s%n", dec, 0, dec >> 0, toBinaryString(dec >> 0));
		System.out.printf("%d >> %d = %4d \t%s%n", dec, 1, dec >> 1, toBinaryString(dec >> 1));
		System.out.printf("%d >> %d = %4d \t%s%n", dec, 2, dec >> 2, toBinaryString(dec >> 2));
		
		System.out.printf("%d << %d = %4d \t%s%n", dec, 0, dec << 0, toBinaryString(dec << 0));
		System.out.printf("%d << %d = %4d \t%s%n", dec, 1, dec << 1, toBinaryString(dec << 1));
		System.out.printf("%d << %d = %4d \t%s%n", dec, 2, dec << 2, toBinaryString(dec << 2));
		
		System.out.println();
		
		dec = -8;
		
		System.out.printf("%d >> %d = %4d \t%s%n", dec, 0, dec >> 0, toBinaryString(dec >> 0));
		System.out.printf("%d >> %d = %4d \t%s%n", dec, 1, dec >> 1, toBinaryString(dec >> 1));
		System.out.printf("%d >> %d = %4d \t%s%n", dec, 2, dec >> 2, toBinaryString(dec >> 2));
		
		System.out.printf("%d << %d = %4d \t%s%n", dec, 0, dec << 0, toBinaryString(dec << 0));
		System.out.printf("%d << %d = %4d \t%s%n", dec, 1, dec << 1, toBinaryString(dec << 1));
		System.out.printf("%d << %d = %4d \t%s%n", dec, 2, dec << 2, toBinaryString(dec << 2));
		
		System.out.println();
		
		dec = 8;
		System.out.printf("%d >> %2d = %4d \t%s%n", dec, 0, dec >> 0, toBinaryString(dec >> 0));
		System.out.printf("%d >> %2d = %4d \t%s%n", dec, 32, dec >> 32, toBinaryString(dec >> 32));
	}

}
/*	쉬프트 연산자 << >>
 * 		- 피연산자의 각 자리(2진수로 표현했을 때)를 오른쪽(>>) 또는 왼쪽(<<) 으로 이동(shift)
 * 		- 자리이동으로 저장범위를 벗어난 값들은 버려지고 빈자리는 0으로 채움
 * 		- '>>' 연산자는 음수의 경우 빈자리를 1로 채움 (양수일때는 0)
 * 		- 좌측 피연산자에만 산술변환 적용 -> int 보다 작은 타입은 int 로 자동변환, 연산결과 int
 * 			(피연산자 타입 일치시킬 필요 X)
 * 
 * 		- x << n == x * 2ⁿ
 * 		- x >> n == x / 2ⁿ
 * 
 * 		- 가독성 떨어지지만 속도가 빠름
 * */
