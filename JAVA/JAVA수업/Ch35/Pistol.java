package Ch35;

// Gun 클래스를 상속받는 Pistol 클래스 정의
public class Pistol extends Gun{

	
	Pistol(){	// 기본 생성자 => 파워, 총알 수량 초기화
		this.power  = 5;	// 파워를 5로 설정
		this.bullitCnt=10;	// 총알 수량을 10으로 설정
	}
	@Override
	void fire(Unit unit) {	// fire 메서드 오버라이드 -> Pistol 발사 동작 구현
		if(this.bullitCnt<=0) {				// 총알 수량이 0 이하일 경우
			System.out.println("탄약 부족..");	// "탄약 부족.." 메시지 출력
			return ;						// 메서드 종료
		}
			
		System.out.println("Pistol fire...");	// "Pistol fire..." 메시지 출력
		unit.underAttack(this.power);			// 주어진 유닛에게 설정된 파워만큼의 데미지 전달

		this.bullitCnt--;	// 총알 수량 감소
		
		
	}

	@Override
	void reload(int bullit) {	// reload 메서드 오버라이드 -> Pistol 재장전 동작 구현
		System.out.println("Pistol reload...");		// "Pistol reload..." 메시지 출력

	}

}
