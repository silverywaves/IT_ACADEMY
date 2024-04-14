package Ch35;

// Unit 클래스를 상속받는 Madic 클래스 정의
public class Madic extends Unit {

	@Override
	void move() {	// move 메서드 오버라이드 -> Medic 이동 동작 구현
		System.out.println("Medic Move...");
	}

	@Override
	void underAttack(int damage) {	// underAttack 메서드 오버라이드 -> Medic 공격받았을 때 동작 구현
		System.out.println("Medic UnderAttack");

		if(this.hp-damage<0)		// 현재 체력에서 받은 데미지를 뺀 결과가 0보다 작으면
			System.out.println("Medic Attacked");	// "Medic Attacked" 메시지 출력
		else
			this.hp-=damage;		// 아니면 현재 체력에서 데미지 차감
	}

}
