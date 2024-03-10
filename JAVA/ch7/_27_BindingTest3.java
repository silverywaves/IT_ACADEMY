package ch7;

class Parent27 {
	int x = 100;
	
	void method() {
		System.out.println("Parent Method");
	}
}

class Child27 extends Parent27 {
	int x = 200;
	
	void method() {
		System.out.println("x = " + x);				// = this.x
		System.out.println("super.x = " + super.x); // super.x = 조상클래스인 Parent27 에 선언된 인스턴스 변수 x
		// => 다른 외부 클래스에서 참조변수를 통해 직접적으로 인스턴스 변수에 접근
		// => 인스턴스 변수에 직접 접근하면, 참조변수의 타입에 따라 사용되는 인스턴스 변수가 달라질 수 있음
		System.out.println("this.x = " + this.x);	// this.x = Child27 클래스의 인스턴스변수 x
	}
}

public class _27_BindingTest3 {

	public static void main(String[] args) {
		Parent27 p = new Child27();
		Child27 c = new Child27();
		
		System.out.println("p.x = " + p.x);
		p.method();
		System.out.println();
		System.out.println("c.x = " + c.x);
		c.method();
		
	}
}
