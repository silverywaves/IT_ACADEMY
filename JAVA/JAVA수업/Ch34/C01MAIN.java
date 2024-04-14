package Ch34;

// C01Interface 애노테이션을 사용해 A 클래스 정의
@C01Interface(value = "HELLO WORLD", number = 5) // C01Interface 애노테이션을 A 클래스에 적용 -> value와 number 속성 값 설정
class A{
	String value;	// 문자열 타입 인스턴스 변수 value 선언
	int num;		// 정수 타입 인스턴스 변수 num 선언
	A(){			// A 클래스 생성자 정의
		// 현재 인스턴스의 클래스에서 C01Interface 애노테이션 가져옴
		C01Interface test = this.getClass().getAnnotation(C01Interface.class);
		// C01Interface 애노테이션의 value와 number 속성 값 출력
		System.out.println("A()  value : " + test.value() );
		System.out.println("A()  number : " + test.number() );
		// 가져온 애노테이션의 value와 number 값을 인스턴스 변수에 저장
		this.value = test.value();
		this.num = test.number();
	}
}

class B{	// B 클래스 정의
	String value;	// 문자열 타입 인스턴스 변수 value 선언
	int num;		// 정수 타입 인스턴스 변수 num 선언
}

public class C01MAIN {	// C01MAIN 클래스 정의

	public static void main(String[] args) {
		A a = new A();	// A 클래스의 인스턴스 생성
		// A 클래스의 인스턴스에 저장된 num과 value 값 출력
		System.out.println(a.num+" | "+a.value);
	}
}
