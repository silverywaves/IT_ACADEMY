package ch7;

// 형변환은 참조변수의 타입을 변환하는 것(인스턴스 변환 X) -> 인스턴스에 아무련 영향 X
// 참조변수의 형변환을 통해, 참조하고 있는 인스턴스에서 사용할 수 있는 멤버의 범위(개수) 조절

class Car {
	// 속성
	String color;
	int door;
	// 기능
	void drive() {		// 운전하는 기능
		System.out.println("drive, Brr~");
	}
	void stop() {		// 멈추는 기능
		System.out.println("stop!!!");
	}
}

class FireEngine extends Car{	// 소방차
	void water() {		// 물을 뿌리는 기능
		System.out.println("water!!");
	}
}


class _22_CastingTest1 {	
	public static void main(String[] args) {
		Car car = null;			// Car 타입의 참조변수 car 선언 후 null 로 초기화
		FireEngine fe = new FireEngine();	// FireEngine 인스턴스를 생성하고 FireEngine 타입의 참조변수가 참조하도록 함
		FireEngine fe2 = null;
		
		fe.water();
		car = fe;				// 조상타입->자손타입 / car = (Car)fe; 에서 형변환 생략. 업캐스팅
		// 참조변수 fe 가 참조하고 있는 인스턴스를 참조변수 car 가 참조하도록 함
		// fe 의 값(fe 가 참조하고 있는 인스턴스의 주소)이 car 에 저장
		// 이 때 두 참조변수의 타입이 다르므로 참조변수 fe 가 형변환되어야 하지만 생략
		// => 참조변수 car 를 통해서도 FireEngine 인스턴스 사용 가능 but
		//		car 는 Car 타입이므로 Car 클래스의 멤버가 아닌 water() 는 사용 불가
//		car.water();			// The method water() is undefined for the type Car
		fe2 = (FireEngine)car;	// 자손타입<-조상타입 / 형변환 생략불가. 다운캐스팅
		// 참조변수 car 가 참조하고 있는 인스턴스를 참조변수 fe2 가 참조하도록 함
		// 두 참조변수의 타입이 다르므로 참조변소 car 형변환
		// car 에는 FireEngine 인스턴스 주소 저장되어 있는 상태 -> fe2 에도 FireEngine 인스턴스 주소 저장
		// => 참조변수 fe2 를 통해서도 FireEngine 인스턴스 사용 가능 but
		//		car 와는 달리 FireEngine 타입이므로 FireEngine 인스턴스의 모든 멤버 사용 가능
		fe2.water();
	}

}

