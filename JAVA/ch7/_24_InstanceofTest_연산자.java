package ch7;

// instanceof 연산자 : 참조변수가 참조하고 있는 인스턴스의 실제 타입 확인, 주로 조건문에 사용
// 					 참조변수 instanceof 타입(클래스명) -결과-> boolean 값(true or false)
//					 결과값이 true => 참조변수가 검사한 타입으로 형변환 가능
//						:실제 인스턴스와 같은 타입의 instanceof 연산 이외에 조상타입의 instanceof 연산에도 true 반환

public class _24_InstanceofTest_연산자 {

	public static void main(String[] args) {
		FireEngine fe = new FireEngine();	// FireEngine 타입의 인스턴스 생성
		
		if(fe instanceof FireEngine) {
			System.out.println("This is a FireEngine instance.");
		}
		
		if(fe instanceof Car){
			System.out.println("This is a Car instance.");
		}
		
		if(fe instanceof Object) {
			System.out.println("This is a Object instance.");
		}
		
		// Car 타입과 Object 타입의 결과값이 true ??
		// => FireEngine 클래스는 Object 클래스와 Car 클래스의 자손 클래스이므로, 조상 멤버들을 상속받았기 때문!
		// => FireEngine 인스턴스는 Object 인스턴스와 Car 인스턴스를 포함
		
		System.out.println(fe.getClass().getName());	// 클래스 이름 출력
	}
}

//class Car() {}			// 이전 예제에 사용한 class 존재하여 주석처리함
//class FireEngine() {}		// 존재하지 않으면 기재해줘야함


/* 조상타입의 참조변수로 자손타입의 인스턴스를 참조 할 수 있음 -> 참조변수의 타입과 인스턴스의 타입이 항상 일치 X
 * 조상타입의 참조변수로는 실제 인스턴스의 멤버들을 모두 사용할 수 없으므로,
 * 실제 인스턴스와 같은 타입의 참조변수로 형변환을 해야만 인스턴스의 모든 멤버들을 사용할 수 있음
 * */

