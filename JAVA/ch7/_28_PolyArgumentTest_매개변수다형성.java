package ch7;

// 참조변수의 다형적인 특징은 메서드의 매개변수에도 적용됨

class Product28{		// Tv28, Computer28, Audio28 클래스의 조상
	int price;			// 제품의 가격 선언
	int bonusPoint;		// 제품구매시 제공하는 보너스점수 선언
}
class Tv28 extends Product28{}
class Computer28 extends Product28{}
class Audio28 extends Product28{}

class Buyer28{				// 고객, 물건(Product28)을 사는 사람을 클래스로 표현
	int money = 1000;		// 소유금액
	int bonusPoint = 0;		// 보너스점수
	// 물건 구입 기능 추가
	// 구입할 대상 필요 => 매개변수로 구입할 제품 넘겨받음
//	void buy(Tv28 t) {		// tv 만 구매 가능 -> 다른 제품도 구매하려면 메서드 추가 필요
//		// 구매 후 Buyer28 의 보유금액 = 소유금액(money)에서 제품의 가격(t.price) 만큼 뺀 금액
//		money = money - t.price;
//		
//		// 구매 후 Byter28 의 보너스점수 = 기존 보너스점수(bonusPoint)에 제품의 보너스점수(t.bonusPoint) 더한 점수
//		bonusPoint = bonusPoint + t.bonusPoint;
//	}
//	void buy(Computer28 c) {
//		money = money - c.price;
//		bonusPoint = bonusPoint + c.bonusPoint;
//	}
//	void buy(Audio28 a) {	// 제품 종류가 늘어날때마다 buy 메서드 계속 추가해야함
//		money = money - a.price;
//		bonusPoint = bonusPoint + a.bonusPoint;
//	}
	// => 다형성을 이용해 간단히 처리
	void buy(Product28 p) {		// 매개변수가 Product28 타입의 참조변수
		// => 메서드의 매개변수로 Product28 클래스의 자손타입인 참조변수면 어느 것이나 매개변수로 받아들일 수 있다는 의미
		money = money - p.price;	// Product28 클래스에서 선언되어있기 때문에 참조변수 p 로 인스턴스 사용 가능
		bonusPoint = bonusPoint + p.bonusPoint;
	}
	// => 다른 제품 클래스가 추가되어도 Product28 클래스를 상속받기만 하면, buy(Product28 p) 메서드의 매개변수로 받아들여짐
}
public class _28_PolyArgumentTest_매개변수다형성 {

	public static void main(String[] args) {
		Buyer28 b = new Buyer28();
		Tv28 t = new Tv28();
		Computer28 c = new Computer28();
		b.buy(t);
		b.buy(c);
	}
}
