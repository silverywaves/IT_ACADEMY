package ch7;

// 고객(Buyer)이 buy(Product p) 메서드를 이용해 Tv 와 Computer 를 구입하고
// 고객의 잔고와 보너스 점수 출력

class Product29{		
	int price;			// 제품의 가격 선언
	int bonusPoint;		// 제품구매시 제공하는 보너스점수 선언
	// 생성자
	Product29(int price){
		this.price = price;
		bonusPoint = (int)(price/10.0);	// 보너스점수는 제품가격의 10%
	}
}

class Tv29 extends Product29{
	Tv29(){
		// 조상클래스의 생성자 Product29(int price) 호출
		super(100);		// Tv29 가격을 100만원으로 함
	}
	//Object 클래스의 toString() 오버라이딩
	public String toString() { return "Tv29"; }	
}
class Computer29 extends Product29{
	Computer29(){
		super(200);
	}
	public String toString() { return "Computer29"; }
}
class Buyer29{				// 고객, 물건을 사는 사람
	int money = 1000;		// 소유금액
	int bonusPoint = 0;		// 보너스점수

	void buy(Product29 p) {		
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		money -= p.price;	
		bonusPoint += p.bonusPoint;
		System.out.println(p + "을/를 구입하셨습니다.");
	}
}

public class _29_PolyArgumentTest {

	public static void main(String[] args) {
		Buyer29 b = new Buyer29();

		b.buy(new Tv29());
		b.buy(new Computer29());
		
		System.out.println("현재 남은 돈은 " + b.money + "만원 입니다.");
		System.out.println("현재 보너스점수는 " + b.bonusPoint + "점입니다.");
	}
}


/*	Object 는 모든 클래스의 조상 -> 이 메서드의 매개변수로 어떤 타입의 인스턴스도 가능
 * 	=> 이 하나의 메서드로 모든 타입의 인스턴스 처리 가능함
 * 		toString() 호출하여 문자열을 얻어 출력
 * */
