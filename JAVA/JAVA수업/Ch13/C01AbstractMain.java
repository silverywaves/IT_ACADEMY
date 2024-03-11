package Ch13;

// 일반클래스 상속관계
class Super1 {
	void Func() {};		// 내용은 없지만 완성형 함수
}

class Son1 extends Super1 {
	void Func() {
		System.out.println("Son1's Function()");
	}
}

// 추상클래스 상속관계
abstract class Super2 {
	abstract void Func();	// 미완성형 함수(선언만 하고 정의되지 않음=>헤더 o, 바디(구현부) X)
	// 추상클래스 및 메서드 선언을 위해 class 와 메서드 앞에 abstract 기재 
}

class Son2 extends Super2 {

	@Override
	void Func() {
		System.out.println("Son2's Function()");
	}
	
}

public class C01AbstractMain {

	public static void main(String[] args) {
//		// 01
//		Super1 ob1 = new Super1();	// 상위클래스 객체 생성 o
//		Son1 ob2 = new Son1();		// 하위클래스 객체 생성 o
//		ob1.Func();					// 상위클래스에서 하위클래스가 추가한 메서드 접근 x => 접근 가능으로 바꾸기 위해서
//									// 상위클래스에서 정의한 메서드를 하위클래스에서 재정의한 경우(오버라이딩) 접근 o (or DownCasting)
//			// => 내용이 없어서 출력이 안되는 것. 접근하는데 문제는 없음
//		Super1 ob3 = ob2;			// UpCasting
//		ob3.Func();
		
		// 02
//		Super2 ob1 = new Super2();	// Error : 추상클래스는 미완성형으로 객체 생성 x
		Son2 ob2 = new Son2();		// 하위클래스에서 미완성형 메서드가 완성형으로 정의되어있음 -> 객체 생성 o
		
		Super2 ob3 = ob2;			// Son2 하위클래스를 Super2 상위클래스로 UpCasting 가능
		ob3.Func();					// 접근할 수 있는 범위가 Son2 까지 확장되어 접근 가능해짐 
									// -> Son2's Function() 리턴
	}
}

// 추상클래스 - 미완성형으로 객체 생성 불가 -> UPCASTING 용도로 사용
// 추상메서드를 하나 이상 포함 (일반 메서드도 포함 가능)
// 	추상메서드 - 정의되지 않고 선언만 한 메서드(헤더만 있는 상태) -> 미완성된 함수
// Why ? 업무분장을 위한 용도로도 쓰임 - 프로그램을 동일한 규격으로 만들기 위한 가이드(메서드명, 설계구조 등 자유도 낮춤)
//		 프로그램을 구체적으로 어덯게 구현할지 결정되지 않은 경우

