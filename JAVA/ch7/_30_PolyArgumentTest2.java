package ch7;

class Product30{
	int price;			// 제품의 가격 선언
	int bonusPoint;		// 제품구매시 제공하는 보너스점수 선언
	// 생성자
	Product30(int price){
		this.price = price;
		bonusPoint = (int)(price/10.0);	// 보너스점수는 제품가격의 10%
	}
	Product30(){}	// 기본 생성자
}

class Tv30 extends Product30{
	Tv30(){
		// 조상클래스의 생성자 Product30(int price) 호출
		super(100);		// Tv30 가격을 100만원으로 함
	}
	//Object 클래스의 toString() 오버라이딩(재정의)
	public String toString() { return "Tv30"; }	
}
class Computer30 extends Product30{
	Computer30(){
		super(200);
	}
	public String toString() { return "Computer30"; }
}
class Audio30 extends Product30{
	Audio30(){
		super(50);
	}
	public String toString() { return "Audio30"; }
}

class Buyer30{				// 고객, 물건을 사는 사람
	int money = 1000;		// 소유금액
	int bonusPoint = 0;		// 보너스점수

	Product30[] item = new Product30[10];	// 구입한 제품을 저장하기 위한 배열(Product30 배열 item 에 사용될 index)
	// 조상타입의 참조변수 배열을 사용하면, 공통의 조상을 가진 서로 다른 종류의 객체를 배열로 묶어 다룰 수 있음
	// 11개 이상의 제품 구입시 Vector 클래스 사용
	// -> 내부적으로 Object 타입 배열을 가지고 있어서, 이 배열에 객체 추가 제거 가능 & 배열 크기 알아서 관리
	int i = 0;
	
	void buy(Product30 p) {		
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		money -= p.price;				// 가진 돈에서 구입한 제품의 가격을 뺌
		bonusPoint += p.bonusPoint;		// 제품의 보너스 점수 추가
		item[i++] = p;					// 제품을 Product30[] item 에 저장
		System.out.println(p + "을/를 구입하셨습니다.");	
	}
	
	void summary() {			// 구매한 물품에 대한 정보 조회
		int sum = 0;			// 구입한 물품의 가격 합계
		String itemList = "";	// 구입한 물품 목록
		
		// 반복문을 이용해서 구입한 물품의 총 가격과 목록 만들기
		for(int i=0; i<item.length; i++) {
			if(item[i]==null) break;
			sum += item[i].price;
			itemList += item[i] + ", ";
		}
		System.out.println("구입하신 물품의 총 금액은 " + sum + "만원입니다.");
		System.out.println("구입하신 제품은 " + itemList + "입니다.");
	}
}

public class _30_PolyArgumentTest2 {

	public static void main(String[] args) {
		Buyer30 b = new Buyer30();
		b.buy(new Tv30());
		b.buy(new Computer30());
		b.buy(new Audio30());
		b.summary();
	}
}


