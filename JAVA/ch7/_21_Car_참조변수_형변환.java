package ch7;

class _21_Car_참조변수_형변환 {		// FireEngine, Ambulance 클래스의 조상
	String color;
	int door;
	void drive() {			// 운전하는 기능
		System.out.println("drive, Brrr");
	}
	void stop() {			// 멈추는 기능
		System.out.println("stop!");
	}
	
	FireEngine f;
	Ambulance a;
//	a = (Ambulance)f;		// Error : 상속관계가 아닌 클래스간의 형변환 불가
//	f = (FireEngine)a;		// 소방차와 앰뷸런스 두 클래스는 서로 아무 관계가 없음
}

class FireEngine extends _21_Car_참조변수_형변환{ // 소방차
	void water() {			// 물 뿌리는 기능
		System.out.println("water");
	}
}



class Ambulance extends _21_Car_참조변수_형변환{	// 앰뷸런스
	void siren() {			// 사이렌을 울리는 기능
		System.out.println("siren");
	}
}

/*	서로 상속관계에 있는 클래스 사이에서는 참조변수도 형변환 가능
 * 		- 자손타입의 참조변수 -> 조상타입의 참조변수(Up-casting)	  : 형변환 생략 가능
 * 		- 조상타입의 참조변수 -> 자손타입의 참조변수(Down-casting) : 형변환 생략 불가
 * */
