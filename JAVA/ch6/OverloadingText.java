package ch6;

class OverloadingText {

	public static void main(String[] args) {
		MyMath3 mm = new MyMath3();
		System.out.println("mm.add(3, 3) 결과:" + mm.add(3, 3));
//		add 메서드가 prinln 메서드보다 먼저 출력 
//		=> println 메서드가 결과를 출력하려면 add 메스드 결과가 먼저 계산되어야 하기 때문
//		위 문장은 아래 두 문장을 하나로 합친 것으로 생각하면 됨
//		int result = mm.add(3, 3);
//		System.out.println("mm.add(3, 3) 결과:" + result);
		System.out.println("mm.add(3l, 3) 결과:" + mm.add(3l, 3));
		System.out.println("mm.add(3, 3l) 결과:" + mm.add(3, 3l));
		System.out.println("mm.add(3l, 3l) 결과:" + mm.add(3l, 3l));
		
		int[] a = {100, 200, 300};
		System.out.println("mm.add(a) 결과 : " + mm.add(a));
	}
}
class MyMath3 {
	int add(int a, int b) {
		System.out.print("int add(int a, int b) - ");
		return a+b;
	}
	long add(int a, long b) {
		System.out.print("long add(int a, long b) - ");
		return a+b;
	}
	long add(long a, int b) {
		System.out.print("long add(long a, int b - ");
		return a+b;
	}
	long add(long a, long b) {
		System.out.print("long add(long a, long b - ");
		return a+b;
	}
	int add(int[] a) {		// 배열의 모든 요소의 합을 결과로 돌려줌
		System.out.print("int add(int[] a) - ");
		int result = 0;
		for(int i=0; i<a.length; i++) {
			result += a[i];
		}
		return result;
	}
}


/*	오버로딩(overloading)
 *   : 한 클래스 내에 같은 이름의 메서드를 여러개 정의하는 것
 *   : 오버로딩된 메서드들은 매개변수에 의해서만 구별 가능
 *   	=> 반환 타입은 오버로딩을 구현하는데 영향 X
 *   
 *  - 조건
 *  	- 메서드 이름이 같아야 함
 *  	- 매개변수의 개수 또는 타입이 같아야 함
 *  
 *  - 장점
 *  	- 기억하기 쉽고 이름도 짧아져서 오류 가능성 줄어듦 & 기능 예측 쉬움
 *  	- 메서드의 이름 절약 가능
 * */
