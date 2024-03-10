package Ch12;

// 메서드 오버라이딩(함수 재정의)
// 상속관계를 전제로 상위클래스의 메서드를 하위클래스가 재정의(고쳐서 사용)하는 것을 허용한 문법
// 메서드의 헤더부분은 동일하게 두고 본체({})의 로직을 다양하게 둠으로써(다형성) 같은 함수를
// 상위클래스로부터 물려받더라도 각 하위 클래스마다 다양한 형태의 결과물을 만들어낼 수 있음

class Animal{
	void sound() {System.out.println("소리낸다");}
}

class Dog extends Animal{

	@Override		// 메타데이터 : 정보표시 or 지시
	void sound() {
//		super.sound();
		System.out.println("멍멍 소리낸다");
	}
//	void sound() {System.out.println("멍멍 소리낸다");}	
	// 우클릭->source->override->상위클래스 조회&선택
	
}

class Cat extends Animal{

	@Override
	void sound() {
//		super.sound();
		System.out.println("야옹 소리낸다");
	}
//	void sound() {System.out.println("야옹 소리낸다");}
	
}

public class C03OverridingMain {

	public static void main(String[] args) {
		Animal ani = new Animal();
		Cat tory = new Cat();
		Dog poppi = new Dog();
		
		ani.sound();
		tory.sound();
		poppi.sound();
		
		// Upcasting 
		Animal ani2 = poppi;	// 상위클래스 자료형 = 하위클래스 자료형	 => 형변환 발생
		ani2.sound();
	}
}
