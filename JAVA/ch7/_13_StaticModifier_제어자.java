package ch7;

class _13_StaticModifier_제어자 {
	static int width = 200;		// 클래스 변수(static 변수)
	static int height = 120;	// 클래스 변수(static 변수)
	
	static {					// 클래스 초기화 블럭
		// static 변수의 복잡한 초기화 수행
	}
	
	static int max(int a, int b) {		// 클래스 메서드(static 변수)
		return a > b ? a : b;
	}
	
}
/*	제어자(modifier)
 * 		- 클래스, 변수 또는 메서드의 선언부에 함게 사용 -> 부가적인 의미 부여
 * 		- 접근 제어자 : public, protected, default, private		-> 한번에 하나만 선택해서 사용
 * 		- 그		외 : static, final, abstract, native, transient, synchronized, volatile, strictfp
 * */

/*	static - 클래스의, 공통적인
 * 	- 사용될 수 있는 곳 : 멤버변수, 메서드, 초기화 블럭
 * 		- 멤버변수 : 모든 인스턴스에 공통적으로 사용되는 클래스변수
 * 				  클래스 변수는 인스턴스를 생성하지 않고도 사용 가능
 * 				  클래스가 메모리에 로드될 때 생성
 * 		- 메서드 : 인스턴스를 생성하지 않고도 호출이 가능한 static 메서드
 * 				 static 메서드 내에서는 인스턴스 멤버들을 직접 사용 불가
 * */

