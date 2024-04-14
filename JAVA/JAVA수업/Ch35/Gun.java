package Ch35;

//Gun 추상 클래스 정의
public abstract class Gun {
	int bullitCnt;	// 총알의 개수
	int power;		// 총의 공격력
	
	abstract void fire(Unit unit);		// 추상 메서드로 fire 선언(구현은 하위 클래스에서) => 총을 발사할 때의 동작 구현
	abstract void reload(int bullit);	// 추상 메서드로 reload 선언(구현은 하위 클래스에서) => 총알을 재장전할 때의 동작 구현
	
}
