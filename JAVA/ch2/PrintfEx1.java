package ch2;

public class PrintfEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b = 1;
		short s = 2;
		char c = 'A';
		
		int finger = 10;
		long big = 100_000_000_000L;
		long hex = 0xFFFF_FFFF_FFFF_FFFFL;
		
		int octNum = 010;		// 8진수 10, 10진수로는 8
		int hexNum = 0x10;		// 16진수 10, 10진수로는 16
		int binNum = 0b10;		// 2진수 10, 10진수로는 2
		
		System.out.printf("b=%d%n", b);
		System.out.printf("s=%d%n", s);
		System.out.printf("c=%c, %d %n", c, (int)c)
		;
		System.out.printf("finger=[%5d]%n", finger);
		System.out.printf("finger=[%-5d]%n", finger);
		System.out.printf("finger=[%05d]%n", finger);
		
		System.out.printf("big=%d%n", big);
		System.out.printf("hex=%#x%n", hex);	// '#' 은 접두사(16진수 0x, 8진수 0)
		
		System.out.printf("octNum=%o, %d%n", octNum, octNum);
		System.out.printf("hexNum=%x, %d%n", hexNum, hexNum);
		System.out.printf("binNum=%s, %d%n", Integer.toBinaryString(binNum), binNum);
				// Integer.toBinaryString(int i) : 정수를 2진 문자열로 변환
	}

}

/*	printf() : 지시자(specifier)를 통해 변수의 값을 여러 가지 형식으로 변환하여 출력
 * 
 * 	%b		: boolean 형식
 * 	%d		: 10진(decimal) 정수 형식	- 출력될 값이 차지할 공간을 숫자로 지정 가능
 * 	%o		: 8진(octal) 정수 형식	- '#'을 사용하면 접두사 '0' 가 붙음
 * 	%x, %X	: 16진(hexa-decimal) 정수 형식 - '#'을 사용하면 접두사 '0x','0X' 가 붙음
 * 	%f		: 부동 소수점(floating-point) 형식(기본적으로 소수점 아래 6자리까지만 출력)
 * 	%e, %E	: 지수(exponent) 표현식 형식
 * 	%c		: 문자(character)
 *  %s		: 문자열(string)
 *  %n		: 줄바꿈
 *  
 * */
 