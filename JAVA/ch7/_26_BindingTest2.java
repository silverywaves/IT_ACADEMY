package ch7;

class Parent26 {
	int x = 100;
	
	void method() {
		System.out.println("Parent26 Method");
	}
}

class Child26 extends Parent26 {
	// 멤버 정의 x / 단순히 조상으로부터 멤버들을 상속받음 
	// => 참조변수의 타입에 관계없이 조상의 멤버들을 사용
}

public class _26_BindingTest2 {

	public static void main(String[] args) {
		Parent26 p = new Child26();
		Child26 c = new Child26();
		
		System.out.println("p.x = " + p.x);
		p.method();
		// => method() : Parent26 Method
		// => x -> 100
		
		System.out.println("c.x = " + c.x);
		c.method();
		// => method() : Parent26 Method
		// => x -> 100
	}
}

/*	자손클래스에서 조상클래스의 멤버를 중복으로 정의하지 않았을 때는 참조변수의 타입에 따른 변화는 X
 * 	=> 참조변수의 타입에 따라 결과가 달라지는 경우는 조상 클래스의 멤버변수와 같은 이름의 멤버변수를 자손클래스에서 중복해서 정의한 경우 뿐
 * */
