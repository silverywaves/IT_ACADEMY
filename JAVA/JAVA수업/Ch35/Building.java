package Ch35;

public abstract class Building {	// Building 클래스를 추상 클래스로 정의	 

	int hp;	
	int sheld;	
	int ammor;	
	
	abstract void BuildStructure();			// 추상 메서드로 BuildStructure 선언(구현은 하위 클래스에서) => 건물의 구조를 건설하는 로직을 구현
	abstract void UnderAttack(Unit unit);	// 추상 메서드로 UnderAttack 선언(구현은 하위 클래스에서) => 건물이 공격을 받았을 때의 동작을 구현
	
	
	
}
