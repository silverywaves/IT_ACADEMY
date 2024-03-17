package ch7;

public class _37_FighterTest_인터페이스구현 {

	public static void main(String[] args) {
		Fighter37 f = new Fighter37();
		
		if(f instanceof Unit37) 
			System.err.println("f는 Unit37클래스의 자손");
		if(f instanceof Fightable37) 
			System.err.println("f는 Fightable37 인터페이스를 구현");
		if(f instanceof Movable37) 
			System.err.println("f는 Movable37 인터페이스를 구현");
		if(f instanceof Attackable37) 
			System.err.println("f는 Attackable 인터페이스를 구현");
		if(f instanceof Object) 
			System.err.println("f는 Object 클래스의 자손");
	}
}

class Unit37 {
	int currentHP;	// 유닛의 체력
	int x;			// 유닛의 위치(x좌표)
	int y;			// 유닛의 위치(y좌표)
}

class Fighter37 extends Unit37 implements Fightable37{
	public void move(int x, int y) {}
	public void attack(Unit37 u) {}
}

interface Fightable37 extends Movable37, Attackable37{}
interface Movable37{void move(int x, int y);}
interface Attackable37{void attack(Unit37 u);}
