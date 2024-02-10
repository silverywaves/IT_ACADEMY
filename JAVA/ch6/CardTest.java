package ch6;

public class CardTest {

	public static void main(String[] args) {
		System.out.println("Card.width = " + Card.width);	// 각 카드의 폭(width)과 높이(height)는 모든 인스턴스가 공통적으로 같은 값 유지
		System.out.println("Card.height = " + Card.height);	// => 클래스변수 선언
		// 클래스변수(static 변수)는 객체생성 없이 '클래스이름.클래스변수'로 직접 사용 가능
		
		Card c1 = new Card();
		c1.kind = "heart";		// 인스턴스변수 값 변경
		c1.number = 7;			// 인스턴스변수 값 변경
		
		Card c2 = new Card();
		c2.kind = "spade";
		c2.number = 4;
	
		System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
		System.out.println("c2는 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");
		
		System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다.");
		c1.width = 50;			// 클래스변수 값 변경(같은 저장공간 -> 한 카드의 width 값만 변경해도 모든 width 값 변경)
		c1.height = 80;			// 클래스변수 값 변경
		
		System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
		System.out.println("c2는 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");

	}
	
}

class Card{
	String kind;		// 각 Card 인스턴스는 자신만의 무늬(kind)와 숫자(number) 유지
	int number;			// => 인스턴스변수로 선언
	static int width = 100;
	static int height = 250;
}
