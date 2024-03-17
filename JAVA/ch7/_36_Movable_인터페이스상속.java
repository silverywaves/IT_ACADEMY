package ch7;

// 인터페이스는 인터페이스로부터만 상속받을 수 있음
// 클래스와는 달리 다중상속 가능(여러 인터페이스로부터 상속받을 수 있음 <= class 와 달리 Object 클래스와 같은 최고 조상 없dma)

interface Movable{
	/* 지정된 위치(x,y)로 이동하는 기능의 메서드 */
	void move(int x, int y);
}

interface Attackable{
	/* 지정된 대상(u)을 공격하는 기능의 메서드 */
	void attack(Unit u);
}

// 인터페이스 구현 : extends 대신 implements 사용
class Fighter implements Fightable{		// Fighter 클래스는 Fightable 인터페이스를 구현한다
	public void move(int x, int y) {}
	public void attack(Unit u) {}
}
// => 구현하는 인터페이스의 메서드 중 일부만 구현시 abstract 를 붙여 추상클래스로 선언해야 하며, 상속과 구현을 동시에 할 수 있음
// class Fighter extends Unit implements Fightable{...}

interface Fightable extends Movable, Attackable{}
// => 자손인터페이스(Fightable)는 조상인터페이스(Movable, Attackable)에 정의된 멤버를 모두 상속
// => Fightable 자체에는 정의된 멤버가 하나도 없지만, 조상인터페이스로부터 상속받은 두 개의 추상메서드 move(int x, int y) & attack(Unit u) 을 멤버로 가짐

public class _36_Movable_인터페이스상속 {

}
