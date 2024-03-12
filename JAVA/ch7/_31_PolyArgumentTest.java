package ch7;

import java.util.Vector;
/*	Vector 클래스
 * 		- 이름때문에 클래스의 기능 오해 -> 동적으로 크기가 관리되는 객체배열
 * 
 * 	메서드 / 생성자
 * 	Vector()					: n개의 객체를 저장할 수 있는 Vector 인스턴스 생성
 * 								-> n개 이상의 인스턴스 저장시 자동적으로 크기 조정
 * 	boolean add(Object o)		: Vector 에 객체 추가 -> 성공시 true, 실패시 false
 *  boolean remove(Object o)	: Vector 에 저장되어있는 객체 제거 -> 성공시 true, 실패시 false
 *  boolean isEmpty()			: Vector 가 비어있는지 검사 -> 비어있으면 true, 비어있지 않으면 false
 *  Object get(int index)		: 지정된 위치(index) 객체 반환 -> 반환타입이 Object 타입이므로 형변환 필요
 *  int size()					: Vector 에 저장된 객체의 개수 반환
 * */

class Product31{
	int price;			// 제품의 가격 선언
	int bonusPoint;		// 제품구매시 제공하는 보너스점수 선언
	// 생성자
	Product31(int price){
		this.price = price;
		bonusPoint = (int)(price/10.0);	// 보너스점수는 제품가격의 10%
	}
	Product31(){	// 기본 생성자
		price = 0;
		bonusPoint = 0;
	}
}

class Tv31 extends Product31{
	Tv31(){
		// 조상클래스의 생성자 Product31(int price) 호출
		super(100);		// Tv31 가격을 100만원으로 함
	}
	//Object 클래스의 toString() 오버라이딩(재정의)
	public String toString() { return "Tv31"; }	
}
class Computer31 extends Product31{
	Computer31(){
		super(200);
	}
	public String toString() { return "Computer31"; }
}
class Audio31 extends Product31{
	Audio31(){
		super(50);
	}
	public String toString() { return "Audio31"; }
}

class Buyer31{				// 고객, 물건을 사는 사람
	int money = 1000;		// 소유금액
	int bonusPoint = 0;		// 보너스점수
	Vector item = new Vector();		// 구입한 제품을 저장하는데 사용될 Vector 객체
	
	void buy(Product31 p) {		
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		money -= p.price;				// 가진 돈에서 구입한 제품의 가격을 뺌
		bonusPoint += p.bonusPoint;		// 제품의 보너스 점수 추가
		item.add(p);					// 구입한 제품을 Vector 에 저장
		System.out.println(p + "을/를 구입하셨습니다.");	
	}
	
	void refund(Product31 p) {			// 구입한 제품 환불
		if(item.remove(p)) {			// 제품을 Vector 에서 제거
			money += p.price;			// 보유금액에서 환불한 제품의 가격 더함
			bonusPoint -= p.bonusPoint;	// 환불한 보너스 점수만큼 차감
			System.out.println(p + "을/를 반품하셨습니다.");
		} else {						// 제거에 실패한 경우
			System.out.println("구입하신 제품 중 해당 제품이 없습니다.");
		}
	}
	
	void summary() {			// 구매한 물품에 대한 정보 조회
		int sum = 0;			// 구입한 물품의 가격 합계
		String itemList = "";	// 구입한 물품 목록
		
		if(item.isEmpty()) {	// Vector 가 비어있는지 확인
			System.out.println("구입하신 제품이 없습니다.");
			return;
		}
		
		// 반복문을 이용해서 구입한 물품의 총 가격과 목록 만들기
		for(int i=0; i<item.size(); i++) {
			Product31 p = (Product31)item.get(i);	// Vector 의 i 번째에 있는 객체 얻어옴
			sum += p.price;
			itemList += (i==0) ? "" + p : ", " + p;
		}
		System.out.println("구입하신 물품의 총 금액은 " + sum + "만원입니다.");
		System.out.println("구입하신 제품은 " + itemList + "입니다.");
	}
}

public class _31_PolyArgumentTest {

	public static void main(String[] args) {
		Buyer31 b = new Buyer31();
		Tv31 tv = new Tv31();
		Computer31 com = new Computer31();
		Audio31 audio = new Audio31();
		
		b.buy(tv);
		b.buy(com);
		b.buy(audio);
		b.summary();
		System.out.println();
		b.refund(com);
		b.summary();
	}
}


/*	Vector 클래스
 * 		- 이름때문에 클래스의 기능 오해 -> 동적으로 크기가 관리되는 객체배열
 * 
 * 	메서드 / 생성자
 * 	Vector()					: n개의 객체를 저장할 수 있는 Vector 인스턴스 생성
 * 								-> n개 이상의 인스턴스 저장시 자동적으로 크기 조정
 * 	boolean add(Object o)		: Vector 에 객체 추가 -> 성공시 true, 실패시 false
 *  boolean remove(Object o)	: Vector 에 저장되어있는 객체 제거 -> 성공시 true, 실패시 false
 *  boolean isEmpty()			: Vector 가 비어있는지 검사 -> 비어있으면 true, 비어있지 않으면 false
 *  Object get(int index)		: 지정된 위치(index) 객체 반환 -> 반환타입이 Object 타입이므로 형변환 필요
 *  int size()					: Vector 에 저장된 객체의 개수 반환
 * */
