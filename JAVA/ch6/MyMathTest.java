package ch6;

public class MyMathTest {

	public static void main(String[] args) {
		// static 메서드는 같은 클래스 내의 인스턴스 메서드 호출 불가
		MyMath mm = new MyMath();		// MyMath 클래스의 인스턴스 먼저 생성
		long result1 = mm.add(5L, 3L);	// 메서드 호출
		
		long result2 = mm.subtract(5L, 3L);
		long result3 = mm.multiply(5L, 3L);
		double result4 = mm.divide(5L, 3L);		// double 대신 long 값으로 호출 -> double 로 자동형변환
		
		System.out.println("add(5L, 3L) = " + result1);
		System.out.println("subtract(5L, 3L) = " + result2);
		System.out.println("multiply(5L, 3L) = " + result3);
		System.out.println("divide(5L, 3L) = " + result4);
	}

}

class MyMath{
	long add(long a, long b) {
		long result = a+b;
		return result;
		// return a + b;	위의 두 줄을 한 줄로 간단히 표현 가능
	}
	long subtract(long a, long b) {
		return a - b;
	}
	long multiply(long a, long b) {
		return a * b;
	}
	double divide(double a, double b) {
		return a /b;
	}
}