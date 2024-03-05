package ch7;

final class Singleton{
	// 생성자의 접근 제어자를 private 로 지정하면, 외부에서 생성자에 접근 불가 -> 인스턴스 생성 불가
	// but 클래스 내부에서는 인스턴스 생성 가능
	private static Singleton s = new Singleton();	
	// getInstance() 에서 사용될 수 있도록 인승턴스가 미리 생성되어야 함 -> static 
	
	private Singleton() {
		// ...
	}
	
	// 인스턴스를 생성하지 않고고 호출할 수 있어야 함 -> static
	public static Singleton getInstance() {
		if(s==null)
			s = new Singleton();
		return s;
	}
}

class _19_SingletonTest_접근제어자 {
	public static void main(String[] args) {
//		Singleton s = new Singleton();	// Error : The constructor Singleton() is not visible
		Singleton s = Singleton.getInstance();
	}
}

/*	생성자가 private 인 클래스는 다른 클래스의 조상이 될 수 없음
 * 		- 자손클래스의 인스턴스를 생성할 때 조상클래스의 생성자를 호출해야 하는데, private 면 불가하기 때문
 * */


/*	제어자의 조합
 * 		- 클래스 : public, (default), final, abstract
 * 		- 메서드 : 모든 접근 제어자, final, abstract, static
 * 		- 멤버변수 : 모든 접근 제어자, final, static
 * 		- 지역변수 : final
 * */


/*	주의사항
 * 		- 메서드에 static & abstract 를 함께 사용 X
 * 		- 클래스에 abstract & final 동시에 사용 X
 * 		- abstract 메서드의 접근 제어자는 private X
 * 		- 메서드에 private & final 같이 사용할 필요 x
 * */