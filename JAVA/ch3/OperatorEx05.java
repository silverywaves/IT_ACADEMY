package ch3;

public class OperatorEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 4;
		
		System.out.printf("%d + %d = %d%n", a, b, a + b);
		System.out.printf("%d - %d = %d%n", a, b, a - b);
		System.out.printf("%d * %d = %d%n", a, b, a * b);
		System.out.printf("%d / %d = %d%n", a, b, a / b);	// int / int = int : 소수점 이하는 버려짐(반올림x)
		System.out.printf("%d / %f = %f%n", a, (float)b, a / (float)b);
			// 올바른 연산결과를 위해 한 쪽을 실수형으로 형변환
			// int / float = float / float = float
		
/*		System.out.println(3/0);		// 오류 발생(ArithmeticException)
		System.out.println(3/0.0);		// Infinity 출력
			피연산자가 정수인 경우, 나누는 수로 0 사용 불가
*/
	}

}
