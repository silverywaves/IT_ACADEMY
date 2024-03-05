package ch7;

/*	다형성(polymorphism)
 * 	- 여러가지 형태를 가질 수 있는 능력	<- 객체지향개념
 * 	- 상속관계에 있을 경우, 조상클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조할 수 있도록 함 (반대는 불가)
 *  - 참조변수가 사용할 수 있는 멤버의 개수 <= 인스턴스 멤버 개수
 * */

public class _20_Polymorphism_다형성 {
	Tv20 t = new Tv20();	// 조상 타입의 참조변수 -> 자손 인스턴스 참조
	CaptionTv20 c = new CaptionTv20();
}

class Tv20{
	boolean power;	// 전원상태(on/off)
	int channel;	// 채널
	
	void power() {
		power = !power;
	}
	void channelUp() {
		++channel;
	}
	void channelDown() {
		--channel;
	}
}

class CaptionTv20 extends Tv20{
	String text;		// 캡션을 보여주기 위한 문자열
	void caption() {
		// ... 내용생략
	}
}