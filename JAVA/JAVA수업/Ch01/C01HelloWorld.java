package Ch01;	// 패키지 구별 코드(폴더 개념) - 특정 다른 폴더로의 접근 허용 or 제한

public class C01HelloWorld {	// 클래스 영역(객체지향 문법 적용되는 범위) - 절차지향도 포함

	public static void main(String[] args) {	// 메서드 영역(절차지향 문법 적용되는 범위)

		// 메서드 종류
		// 라이브러리 메서드 : 미리 제공되어지는 메서드(System Library 등)
		// 사용자정의 메서드 : 개발자에의해 만들어지는 메서드
		// main 메서드	 : 최초 실행 메서드 -> 메모리 공간 생성

		System.out.println("Hello World");
	}

}
