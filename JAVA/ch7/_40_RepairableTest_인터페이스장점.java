package ch7;

/*	인터페이스의 장점
 * 		- 개발 시간 단축
 * 		- 표준화 가능
 * 		- 서로 관계없는 클래스들에게 관계를 맺어줄 수 있음
 * 		- 독립적인 프로그래밍 가능
 * */

public class _40_RepairableTest_인터페이스장점 {

	public static void main(String[] args) {
		Tank40 tank = new Tank40();
		Dropship40 dropship = new Dropship40();
		
		Marine40 marine = new Marine40();
		SCV scv = new SCV();
		scv.repair(tank);	// scv가 Tank를 수리하도록 함
		scv.repair(dropship);
//		scv.repair(marine);  // Marine 은 Repairable 인터페이스 구현 x -> 에러발생
		// Error : The method repair(Repairable) in the type SCV is not applicable for the arguments (Marine40)
	}
}

interface Repairable{}	// Repairable 인터페이스 정의 후 수리 가능한 기계화 유닛에게 이 인터페이스를 구현하도록 함
// => Repairable 에 정의된 것은 아무것도 없고, 인스턴스 타입체크에만 사용됨

class Unit40{
	int hitPoint;
	final int MAX_HP;
	Unit40(int hp){
		MAX_HP = hp;
	}
	// ...
}

class GroundUnit extends Unit40{
	GroundUnit(int hp){
		super(hp);
	}
}

class AirUnit extends Unit40{
	AirUnit(int hp){
		super(hp);
	}
}

class Tank40 extends GroundUnit implements Repairable{
	Tank40(){
		super(150);		// Tank40 의 HP 는 150
		hitPoint = MAX_HP;
	}
	
	public String toString() {
		return "Tank40";
	}
	// ...
}

class Dropship40 extends AirUnit implements Repairable{
	Dropship40(){
		super(125);		// Dropship 의 HP 는 125
		hitPoint = MAX_HP;
	}
	
	public String toString() {
		return "Dropship40";
	}
}

class Marine40 extends GroundUnit{
	Marine40(){
		super(40);
		hitPoint = MAX_HP;
	}
	// ...
}

class SCV extends GroundUnit implements Repairable{
	SCV(){
		super(60);
		hitPoint = MAX_HP;
	}
	
	void repair(Repairable r) {		// 매개변수로 넘겨받은 유닛을 수리한다
		// 매개변수 r 의 타입이 Repairable 이므로 인터페이스 Repairable 에 정의된 멤버만 사용 가능
		// => instanceof 연산자로 타입 체크한 뒤 캐스팅하여 Unit40 클래스에 정의된 hitPoint 와 MAX_HP 사용할 수 있도록 함
		if (r instanceof Unit40) {
			Unit40 u = (Unit40)r;
			while(u.hitPoint != u.MAX_HP) {
				/* Unit40 의 HP 를 증가시킴 */
				u.hitPoint++;
			}
			System.out.println(u.toString() + "의 수리가 끝났습니다.");
		}
	}
}