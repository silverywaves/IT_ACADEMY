package Ch35;

// Unit 클래스를 상속받는 Medic 클래스 정의
public class Medic extends Unit{

	@Override
	void move() {	// move 메서드 오버라이드 -> Medic 이동 동작 구현
		System.out.println("Medic Move...");	// "Medic Move..." 메시지 출력
	}

	@Override
	void underAttack(int damage) {	// underAttack 메서드 오버라이드 -> Medic 공격받았을 때 동작 구현
		System.out.println("Medic UnderAttack...");	// "Medic UnderAttack..." 메시지 출력
	
		if(this.hp-damage<0)	// 현재 체력에서 받은 데미지를 뺀 값이 0보다 작으면
			System.out.println("Medic Dead..");	// "Medic Dead.." 메시지 출력
		else					// 아니면
			this.hp-=damage;	// 현재 체력에서 데미지만큼 차감
		
	}

}
