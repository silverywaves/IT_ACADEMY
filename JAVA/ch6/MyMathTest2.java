package ch6;

class MyMath2 {
	long a, b;
	// 인스턴스변수 a, b 만을 이용해서 작업하므로 매개변수 필요 X
	long add() {return a + b;}	// a, b 는 인스턴스 변수
	long subtract() {return a - b;}
	long multiply() {return a * b;}
	double divide() {return a / b;}
	
	// 인스턴스변수와 관계없이 매개변수만으로 작업 가능 -> static 붙여 클래스메서드로 선언
	static long add(long a, long b) {return a + b;}		// a, b 는 지역변수
	static long subtract(long a, long b) {return a - b;}
	static long multiply(long a, long b) {return a * b;}
	static double divide(double a, double b) {return a / b;}

}

class MyMathTest2{
	public static void main(String[] args) {
		// 클래스메서드 호출. 인스턴스 생성없이 호출가능
		System.out.println(MyMath2.add(200l, 100l));
		System.out.println(MyMath2.subtract(200l, 100l));
		System.out.println(MyMath2.multiply(200l, 100l));
		System.out.println(MyMath2.divide(200.0, 100.0));
		
		MyMath2 mm = new MyMath2();	// 인스턴스 생성
		mm.a = 200l;
		mm.b = 100l;
		// 인스턴스메서드는 객체생성 후에만 호출 가능
		System.out.println(mm.add());		// () 매개변수 선언 x <- 인스턴스변수로 충분히 작업 가능
		System.out.println(mm.subtract());
		System.out.println(mm.multiply());
		System.out.println(mm.divide());
	}
}
/*	클래스메서드(static 메서드) / 인스턴스 메서드
 * 		- 클래스를 설계할 때, 멤버변수 중 모든 인스턴스에 공통으로 사용하는 것에 static
 * 		- 클래스 변수는 인스턴스를 생성하지 않아도 사용 가능
 * 		- 클래스 메서드는 인스턴스 변수 사용 불가
 * 		- 메서드 내 인스턴스 변수를 사용하지 않으면 static 붙이는 것 고려
 * */
