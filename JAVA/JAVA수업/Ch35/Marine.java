package Ch35;

//Unit 클래스를 상속받는 Marine 클래스 정의
public class Marine extends Unit{

	String name;	// Marine 이름
	Gun gun;		// Marine 무기(총)
	

	Marine(){}		 // 기본 생성자(초기화X)
	Marine(String name){this.name = name;}	// 이름을 받아서 초기화하는 생성자
	Marine(String name,Gun gun){			// 이름과 총을 받아서 초기화하는 생성자
		this.name = name;	// 이름 설정
		this.gun = gun;		// 총 설정
		this.hp = 100;		// 체력을 100으로 설정
	}
	void attack(Unit unit) {		// 다른 유닛 공격 메서드
		gun.fire(unit);				// 현재 Marine의 총을 사용하여 공격
		
	}
	
	@Override
	void move() {	 // move 메서드 오버라이드 -> Marine의 이동 동작 구현
		System.out.println("Marine Move...");
	}
	@Override
	void underAttack(int damage) {	// underAttack 메서드를 오버라이드 -> Marine이 공격받았을 때 동작 구현
		System.out.println("Marine UnderAttack...");
	
		if(this.hp-damage<0)		// 현재 체력에서 받은 데미지를 뺀 값이 0보다 작으면
			System.out.println("Marine Dead..");	// "Marine Dead.." 메시지 출력
		else						// 아니면
			this.hp-=damage;		// 현재 체력에서 데미지만큼 차감
	}
	@Override
	public String toString() {		// 객체 정보를 문자열로 반환하는 메서드
		return "Marine [name=" + name + ", gun=" + gun + ", hp=" + hp + ", amor=" + amor + ", type=" + type + "]";
	}

	
	
	
}
