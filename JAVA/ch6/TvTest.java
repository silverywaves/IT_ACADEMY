package ch6;

class Tv {

		// TV 의 속성(멤버변수)
		String color;	// 색상
		boolean power;	// 전원상태(ON / OFF)
		int channel;	// 채널
		
		
		// TV 의 기능(메서드)
		void power() {power = !power;}	// TV 를 켜거나 끄는 기능을 하는 메서드
		void channelUp() {++channel;}	// TV 의 채널을 높이는 기능을 하는 메서드
		void channelDown() {--channel;}	// TV 의 채널을 낮추는 기능을 하는 메서드
}

class TvTest {	
		public static void main(String[] args) {	
			Tv t;				// Tv 클래스 타입의 참조변수 t 선언
			t = new Tv();		// Tv 인스턴스 생성 후 생성된 Tv 인스턴스 주소를 t 에 저장
			t.channel = 7;		// Tv 인스턴스의 멤버변수 channel 의 값을 7로 설정
			t.channelDown();	// Tv 인스턴스 메서드 channelDown() 호출
			
			System.out.println("현재 채널은 " + t.channel + "입니다.");
	}

}
/*	인스턴스의 생성
 * 		클래스명 변수명;			// 클래스의 객체를 참조하기 위한 참조변수 선언
 * 		변수명 = new 클래스명();	// 클래스의 객체 생성 후, 객체의 주소를 참조변수에 저장
 * 
 * 	인스턴스의 멤버변수(속성) 사용
 * 		참조변수.멤버변수			// 참조변수에 저장된 주소에 있는 인스턴스의 멤버변수
 *	=> 인스턴스는 참조변수를 통해서만 다룰 수 있음
 *	=> 참조변수의 타입은 인스턴스 타입과 일치
 * 
 * */
