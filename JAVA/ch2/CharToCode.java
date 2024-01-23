package ch2;

public class CharToCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch = 'A';			// 문자 'A' 를 char 타입의 변수 ch 에 저장
		// char ch = 65;			문자 코드를 알면 직접 변수 ch에 저장해도 됨
		int code = (int)ch;		// ch에 저장된 값을 int타입으로 변환하여 저장
		
		System.out.printf("%c=%d(%#X)%n", ch, code, code);
		
		char hch = '가';		// char hch = 0xAC00; / char hch = '\uAC00'; 도 가능
		System.out.printf("%c=%d(%#X)%n", hch, (int)hch, (int)hch);
	}

}
/*	문자형 char
 * 		문자를 저장하기 위한 변수 선언시 사용
 * 		단 하나의 문자(문자의 유니코드(정수))만 저장 가능
 * 		2byte(16bit) => 표현가능한 정수의 개수 : 2^16개 (65536개)
 * 					 => 유니코드는 양수(0) 포함으로 0~65535
 * 						단, 정수형 short 는 같은 2byte 지만 절반을 음수표현에 사용하여 -32768~32767
 * 
 * 	println()
 * 		변수의 타입이 정수형이면 변수에 저장된 값을 10진수로 해석하여 출력
 * 		변수의 타입이 문자형이면 저장된 숫자에 해당하는 유니코드 문자 출력
 * 		=> 값의 타입까지 알아야 올바른 해석 가능
 * 
 * 	형변환(캐스팅, casting)
 * 		어떤 타입을 다른 타입으로 변환하는 것
 * 
 * 	인코딩(encoding)
 * 		문자를 코드로 변환하는 것
 * 
 * 	디코딩(decoding)
 * 		코드를 문자로 변환하는 것
 */