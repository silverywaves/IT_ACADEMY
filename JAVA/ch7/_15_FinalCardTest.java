package ch7;

// 생성자를 이용한 final 멤버 변수의 초기화

class Card{
	final int NUMBER;			// 상수지만 선언과 함께 초기화 하지 않고
	final String KIND;			// 생성자에서 단 한번만 초기화 할 수 있음
	static int width = 100;
	static int height = 250;
	
	Card(String kind, int num){
		KIND = kind;			// 매개변수로 넘겨받은 값으로
		NUMBER = num;			// KIND 와 NUMBER 초기화
	}
	
	Card(){
		this("HEART", 1);
	}
	
	public String toString() {
		return KIND + " " + NUMBER;
	}
}

class _15_FinalCardTest {
	public static void main(String[] args) {
		Card c= new Card("HEART", 10);
//		c.NUMBER = 5;		// Error : The final field Card.NUMBER cannot be assigned
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
		System.out.println(c);		// System.out.println(c.toString());
	}
}
