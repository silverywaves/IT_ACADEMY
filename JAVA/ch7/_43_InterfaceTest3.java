package ch7;

public class _43_InterfaceTest3 {

	public static void main(String[] args) {
		A43 a = new A43();
		a.methodA();
	}
}

class A43{
	void methodA() {
		I43 i = InstanceManager.getInstance();	// 제3의 클래스의 메서드를 통해 인터페이스 I를 구현한 클래스의 인스턴스를 얻어롬
		i.methodB();
		System.out.println(i.toString());	// i로 Object 클래스의 메서드 호출 가능
	}
}

interface I43{
	public abstract void methodB();
}

class B43 implements I43{
	public void methodB() {
		System.out.println("methodB in B class");
	}
	public String toString() {
		return "class B";
	}
}

class InstanceManager{
	public static I43 getInstance() {	// getInstance() 라는 메서드를 통해 제공받음 
		return new B43();				// -> 다른 인스턴스로 바꾸려면 여기만 변경하면 됨
	}
}