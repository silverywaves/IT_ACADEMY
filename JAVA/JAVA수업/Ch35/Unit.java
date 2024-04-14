package Ch35;

// 추상 클래스 Unit 정의
public abstract class Unit {
	int hp;			// 유닛의 체력
	int amor;		// 유닛의 방어력
	String type;	// 유닛의 타입
	
	abstract void move();	// 추상 메서드 move 선언(하위 클래스에서 반드시 구현)
	abstract void underAttack(int damage);	// 추상 메서드 underAttack 선언(하위 클래스에서 반드시 구현)
		
}
