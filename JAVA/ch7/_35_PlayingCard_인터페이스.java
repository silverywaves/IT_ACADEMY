package ch7;

// 인터페이스 : 일종의 추상클래스(기본 설계도)
// 추상클래스처럼 추상메서드를 갖지만 추상클래스보다 추상화 정도가 높아 추상클래스와 달리 몸통을 갖춘 일반 메서드 또는 멤버변수를 구성원으로 가질 수 없음
// 추상메서드와 상수만 멤버로 가질 수 있음
// 접근제어자로 public or default 사용 가능

// interface 인터페이스이름 {
//		public static final 타입 상수이름 = 값;
//		public abstract 메서드이름(매개변수목록);
// }

// 모든 멤버변수는 public static final , 생략 가능
// 모든 메서드는 public abstract , 생략 가능. static 메서드 & 디폴트 메서드는 예외(JDK 1.8ver)
// why? -> 인터페이스에 정의된 모든 멤버에 예외없이 적용되는 사항이라 제어자 생략 가능 (생략된 제어자는 컴파일시 컴파일러가 자동 추가)

interface PlayingCard{
	public static final int SPADE = 4;
	final int DIAMOND = 3;		// public static final int DIAMOND = 3;
	static int HEART = 2;		// public static final int HEART = 2;
	int CLOVER = 1;				// public static final int CLOVER = 1;
	
	public abstract String getCardNnumber();
	String getCardKind();		// public abstract String getCardKind();
}

public class _35_PlayingCard_인터페이스 {

}
