package ch7;

// 추상클래스 : 미완성 설계도 -> 미완성 메서드(추상메서드) 포함
// 추상클래스로는 인스턴스 생성 불가. 상속을 통해서만 자손클래스에 의해 완성 가능
// abstract class 클래스이름 { ... } <= 추상메서드가 있으니 상속을 통해 구현해주어야 하는 상태

// 추상메서드 : 선언부만 작성하고 구현부는 작성하지 않은 채 남겨둔 메서드(설계만 해놓고 수행될 내용을 작성하지 않아 미완성 메서드)
// 메서드의 내용이 상속받는 클래스에 따라 달라질 수 있기때문
// abstract 리턴타입 메서드이름();  <- 주석으로 어떤 기능을 수행할 목적으로 작성했는지 설명

// 추상클래스로부터 상속받는 자손클래스는 오버라이딩을 통해 조상인 추상클래스의 추상메서드를 모두 구현해야 함
// 하나라도 구현하지 않는다면, 자손클래스 역시 추상클래스로 지정해야 함(아무 내용없이 {}만 있어도 일반메서드로 간주됨)

abstract class Player32{			// 추상클래스
	abstract void play(int pos);	// 추상메서드
	abstract void stop();			// 추상메서드
}

class AudioPlayer32 extends Player32{
	void play(int pos) {
		System.out.println("추상메서드 구현");
	}
	void stop() {
		System.out.println("추상메서드 구현");
	}
}

abstract class AbstractPlayer32 extends Player32{
	void play(int pos) {
		System.out.println("추상메서드 구현");
	}
	// 추상메서드 stop 에 대해서 구현하지 않음 -> 추상클래스로 지정
}

public class _32_AbstractTest_추상클래스 {

}
