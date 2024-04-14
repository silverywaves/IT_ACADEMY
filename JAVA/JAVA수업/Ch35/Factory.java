package Ch35;

// Building 추상 클래스를 상속받는 Factory 클래스 정의
public class Factory extends Building {

	@Override
	void BuildStructure() {
        // Building 추상 클래스의 BuildStructure 추상 메서드 오버라이드
        // Factory 건물의 건설 로직 구현 - 현재 구현상태 X
	}

	@Override
	void UnderAttack(Unit unit) {
        // Building 추상 클래스의 UnderAttack 추상 메서드 오버라이드
        // Factory 건물이 공격받았을 때의 로직 구현 - 현재 구현상태 X
	}

	
	
}
