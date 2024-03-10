package ch7;

// 조상 타입의 참조변수 vs 자손 타입의 참조변수 차이점 : 사용할 수 있는 멤버의 개수
// 조상클래스에 선언된 멤버변수와 같은 이름의 인스턴스변수를 자손 클래스에 중복으로 정의했을 때,
// 조상타입의 참조변수는 자손 인스턴스를 참조하는 경우와 자손타입의 참조변수로 자손 인스턴스를 참조하는 경우 결과가 다름

// 메서드의 경우 조상 클래스의 메서드를 자손 클래스에서 오버라이딩하면 참조변수의 타입에 관계없이 항상
// 인스턴스의 메서드(오버라이딩된 메서드)가 호출되지만, 멤버변수의 경우 참조변수의 타입에 따라 달라짐

// 멤버변수가 조상 클래스와 자손 클래스에 중복 정의된 경우,
// 조상타입의 참조변수를 사용했을 때는 조상 클래스에 선언된 멤버변수 사용,
// 자손타입의 참조변수를 사용했을 때는 자손 클래스에 선언된 멤버변수 사용

public class _25_BindingTest_참조변수_인스턴스_연결 {

	public static void main(String[] args) {
		Parent25 p = new Child25();	// Child23 의 객체를 생성해서 Parent23 타입의 참조변수가 참조하도록 함
		Child25 c = new Child25();	// Child23 의 객체를 생성해서 Child23 타입의 참조변수가 참조하도록 함
		// => 다른 타입의 참조변수 p, c 는 모두 Child23 인스턴스를 참조함
		
		System.out.println("p.x = " + p.x);
		p.method();
		// 조상타입의 참조변수 p 로 Child23 인스턴스의 멤버들을 사용
		// => method() : Child25 Method
		// => x -> 100
		
		System.out.println("c.x = " + c.x);
		c.method();
		// 자손타입의 참조변수 c 로 Child23 인스턴스의 멤버들을 사용
		// => method() : Child25 Method
		// => x -> 200
		
		// 메서드 : 참조변수의 타입에 관계없이 항상 실제 인스턴스의 타입인 Child23 클래스에 정의된 메서드 호출
		// 인스턴스변수 : 참조변수의 타입에 따라 달라짐
	}
}

class Parent25{
	int x = 100;
	
	void method() {
		System.out.println("Parent25 Method");
	}
}
class Child25 extends Parent25{
	int x = 200;
	
	void method() {
		System.out.println("Child25 Method");
	}
}
// => Parent23 클래스와 Child23 클래스는 서로 같은 멤버들을 정의함
