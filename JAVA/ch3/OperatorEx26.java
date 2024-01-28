package ch3;

public class OperatorEx26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5;
		int b = 0;
		
		System.out.printf("a=%d, b=%d%n", a, b);
		System.out.printf("a!=0 || ++b!=0 = %b%n", a!=0 || ++b!=0);	// 우측 피연산자가 처리되면 b 의 값이 증가
		System.out.printf("a=%d, b=%d%n", a, b);
		System.out.printf("a==0 && ++b!=0 = %b%n", a==0 && ++b!=0);
		System.out.printf("a=%d, b=%d%n", a, b);
				// b 의 값은 0 => '||' 는 좌측 피연산자가 참이라서, '&&' 는 좌측 피연산자가 거짓이라서 우측 피연산자 평가 x
				// => 효율적인 연산
	}

}
