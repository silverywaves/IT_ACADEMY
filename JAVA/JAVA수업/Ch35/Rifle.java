package Ch35;

// Gun 클래스를 상속받는 Rifle 클래스 정의
public class Rifle extends Gun{

	
	Rifle(){	// 기본 생성자 => 파워와 총알 수량 초기화
		this.power = 5;			// 파워를 5로 설정
		this.bullitCnt=20;		// 총알 수량을 20으로 설정
	}
	@Override
	void fire(Unit unit) {	// fire 메서드 오버라이드 -> Rifle 발사 동작 구현
		if(this.bullitCnt<=0) {				// 총알 수량이 0 이하일 경우
			System.out.println("탄약 부족..");	// "탄약 부족.." 메시지 출력
			return ;						// 메서드 종료
		}
			
		System.out.println("Rifle fire...");	// "Rifle fire..." 메시지 출력
		unit.underAttack(this.power*2);			// 주어진 유닛에게 설정된 파워의 2배만큼 데미지 전달

		this.bullitCnt-=2;	// 총알 수량 2 감소
		
	}

	@Override
	void reload(int bullit) {	// reload 메서드 오버라이드 -> Rifle 재장전 동작 구현
		System.out.println("Rifle reload...");	// "Rifle reload..." 메시지 출력
	}

}
