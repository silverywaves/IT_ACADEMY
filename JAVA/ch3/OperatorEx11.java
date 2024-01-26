package ch3;

public class OperatorEx11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char a = 'a';
		char d = 'd';
		char zero = '0';
		char two = '2';
		
		System.out.printf("'%c' - '%c' = %d%n", d, a, d - a);
		System.out.printf("'%c' - '%c' = %d%n", two, zero, two - zero);
		System.out.printf("'%c' = %d%n", a, (int)a);
		System.out.printf("'%c' = %d%n", d, (int)d);
		System.out.printf("'%c' = %d%n", zero, (int)zero);
		System.out.printf("'%c' = %d%n", two, (int)two);
	}

}
/*	사칙연산은 문자도 가능 => 문자는 실제로 유니코드(부호없는 정수)로 저장
 *		=> 해당 문자에서 0 을 빼주면 숫자로 변환 
 * */
