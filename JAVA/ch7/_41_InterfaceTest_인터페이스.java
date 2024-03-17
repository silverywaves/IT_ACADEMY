package ch7;

/*	본직적 측면에서 인터페이스란?
 * 	클래스를 사용하는 쪽(User)과 클래스를 제공하는 쪽(Provider)이 있음
 *  메서드를 사용(호출)하는 쪽(User)에서는 사용하려는 메서드(Provider)의 선언부만 알면 됨(내용은 몰라도 ok)
 * 
 * */

class A41{
	public void methodA(B41 b) {
		b.methodB();
	}
}

class B41{
	public void methodB() {
		System.out.println("methodB()");
	}
}
// 클래스 A 를 작성하려면 클래스 B 가 작성되어 있어야하고, 클래스 B 의 methodB()의 선언부가 변경되면 이를 사용하는 클래스 A 도 변경되어야 함
// => 직접적인 관계의 두 클래스는 한 쪽이 변경되는 다른 한 쪽도 변경되어야 함
// 만약, 클래스 A 가 클래스 B 를 직접 호출하지 않고 인터페이스를 매개체로 해서 클래스 B의 메서드에 접근하도록 하면,
// 클래스 B에 변경사항이 생기거나 같은 기능의 다른 클래스도 대체되어도 클래스 A는 영향을 받지 않게 됨

class _41_InterfaceTest_인터페이스 {
	public static void main(String[] args) {
		A41 a = new A41();
		a.methodA(new B41());		// methodB()
	}
}
