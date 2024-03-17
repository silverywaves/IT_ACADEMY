package ch7;

// 기존 클래스로부터 공통된 부분을 뽑아내어 추상클래스 만들어보기
//	class Marine{		// 보병
//		int x, y;		// 현재위치
//		void move(int x, int y) { /* 지정된 위치로 이동 */ }
//		void stop() { /* 현재 위치에 정지 */ }
//		void stimPack() { /* 스팀팩 사용 */ }
//	}
//	
//	class Tank{			// 탱크
//		int x, y;		// 현재위치
//		void move(int x, int y) { /* 지정된 위치로 이동 */ }
//		void stop() { /* 현재 위치에 정지 */ }
//		void changeMode() { /* 공격모드 변환 */ }
//	}
//	
//	class Dropship{		// 수송선
//		int x, y;		// 현재위치
//		void move(int x, int y) { /* 지정된 위치로 이동 */ }
//		void stop() { /* 현재 위치에 정지 */ }
//		void load() { /* 선택된 대상을 태움 */ }
//		void unload() { /* 선택된 대상을 내림 */ }
//	}

abstract class Unit{
	int x, y;
	abstract void move(int x, int y);
	void stop() { /* 현재 위치에 정지 */ }
}

class Marine extends Unit {		// 보병
	void move(int x, int y) { /* 지정된 위치로 이동 */ }
	void stimPack() { /* 스팀팩 사용 */ }
}
class Tank extends Unit {		// 탱크
	void move(int x, int y) { /* 지정된 위치로 이동 */ }
	void changMode() { /* 공격모드 변환 */ }
}
class Dropship extends Unit {
	void move(int x, int y) { /* 지정된 위치로 이동 */ }
	void load() { /* 선택된 대상을 태움 */ }
	void unload() { /* 선택된 대상을 내림 */ }
}

// => stop 메서드는 선언부와 구현부 모두 공통적
// Marine, Tank => 지상유닛 / Dropship 은 공중유닛 => 이동하는 방법이 서로 달라서 move 메서드의 실제 구현내용은 다를 것
// but, move 메서드의 선언부는 같기때문에 추상메서드로 정의 가능

public class _34_UnitTest_추상클래스작성 {

	public static void main(String[] args) {
		Unit group[] = new Unit[4];
//		Object group[] = new Object[4];  <- 이렇게 실행시, Object 클래스에 move 메서드가 정의되어있지 않아 move 메서드 호출시 오류 발생
		group[0] = new Marine();
		group[1] = new Tank();
		group[2] = new Marine();
		group[3] = new Dropship();
		
		for(int i=0; i<group.length; i++) {
			group[i].move(100, 200);		// Unit 배열의 모든 유닛을 좌표(100, 200)의 위치로 이동
			// => Unit 클래스의 추상메서드인 move 를 호출하는 것 같이 보이지만, 실제로는 이 추상메서드가 구현된 Marine, Tank, Dropship 인스턴스의 메서드가 호출된 것
		}
		// => 공통조상인 Unit 클래스 타입의 참조변수 배열을 토앻 서로 다른 종류의 인스턴스를 하나의 묶음으로 다룰 수 있음(다형성)
	}
}

