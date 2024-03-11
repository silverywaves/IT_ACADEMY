package Ch12;

class C06Super {
	void func1() {
		System.out.println("C06Super Func1 호출!");
	}
}

class C06Sub extends C06Super {
	void func1() {	// 오버라이딩 -> 메서드 영역 추가
		System.out.println("C06Sub Func1 호출!");
	}
	void func2() {
		System.out.println("C06Sub Func1 호출(extends..)!");
	}
}

public class C06UpDownCastingOverridingMain {

	public static void main(String[] args) {
//		C06Super ob1 = new C06Super();
//		ob1.func1();
//		
//		C06Sub ob2 = new C06Sub();
//		ob2.func1();
		
		C06Super ob3 = new C06Sub();
//		ob3.func2();	// Error : 확장된 부분 접근 안되어서 발생. DownCasting 필요
		ob3.func1();	// 오버라이딩된 하위 메서드에는 접근 가능
		
		// UPCASTING
		// 상위클래스형 참조변수 = 하위클래스형 객체
		// 확장된(추가된) 멤버변수 접근가능 ? (x) -> DownCasting
		// 확장된(추가된) 멤버메서드 접근가능 ? (x) -> DownCasting
		// 재정의된 멤버메서드에 접근가능 ? (o)
	}
}
