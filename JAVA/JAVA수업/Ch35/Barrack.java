package Ch35;

interface UnitFactory{	// UnitFactory 인터페이스 정의
	
	Unit createUnit();	// Unit 생성 추상 메서드 선언

}

class MarineFactory implements UnitFactory{	// UnitFactory 인터페이스를 구현하여 MarineFactory 클래스 정의

	@Override
	public Unit createUnit() {
		return new Marine();	// Marine 유닛 생성하여 반환
	}
	
}

class MedicFactory implements UnitFactory {	// UnitFactory 인터페이스를 구현하여 MedicFactory 클래스 정의

	@Override
	public Unit createUnit() {
		return new Medic();		// Medic 유닛 생성하여 반환
	}
	
}

public class Barrack extends Building {		// Building 클래스를 상속받아 Barrack 클래스 정의

	private MarineFactory marineFactory;	// MarineFactory 타입의 marineFactory 인스턴스 변수 선언
	private MedicFactory medicFactory;		// MedicFactory 타입의 medicFactory 인스턴스 변수 선언	
	Barrack(){		// Barrack 클래스의 기본 생성자 정의
		// MarineFactory와 MedicFactory의 인스턴스 생성 -> marineFactory와 medicFactory 변수에 할당
		marineFactory = new MarineFactory();
		medicFactory = new MedicFactory();
	}
	
	public Unit getMarine() {				// Marine 유닛 생성 메서드 정의
		return marineFactory.createUnit();	// marineFactory 사용하여 Marine 유닛 생성 & 반환
	}
	
	public Unit getMedic() {				// Medic 유닛 생성 메서드 정의
		return medicFactory.createUnit();	// medicFactory 사용하여 Medic 유닛 생성 & 반환
	}

	@Override
	void BuildStructure() {
        // Building 클래스의 추상 메서드 오버라이드
        // Barrack 건물의 건설 로직 구현 - 현재 구현상태 X
	}

	@Override
	void UnderAttack(Unit unit) {
        // Building 클래스의 추상 메서드 오버라이드
        // Barrack 건물이 공격받았을 때의 로직 구현 - 현재 구현상태 X
	}
	
}
