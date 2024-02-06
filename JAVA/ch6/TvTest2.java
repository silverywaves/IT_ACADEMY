package ch6;

class TvTest2 {

	public static void main(String[] args) {
		Tv t1 = new Tv();	// 인스턴스 t1 생성
							// 참조변수 t1 이 가리키고(참조하고)있는 인스턴스를 간단히 인스턴스 t1 이라고 함
		Tv t2 = new Tv();	// 인스턴스 t2 생성
		System.out.println("t1의 channel 값은 " + t1.channel + "입니다.");
		System.out.println("t2의 channel 값은 " + t2.channel + "입니다.");
		
		t1.channel = 7;		// 인스턴스 t1의 멤버변수인 channel 값 변경
		System.out.println("t1의 channel 값을 7로 변경하였습니다.");
		
		System.out.println("t1의 channel 값은 " + t1.channel + "입니다.");
		System.out.println("t2의 channel 값은 " + t2.channel + "입니다.");
	}

}
// 같은 클래스로부터 생성되었어도 각 인스턴스 속성(멤버변수)은 서로 다른 값 유지 가능
// 메서드 내용은 모든 인스턴스에 대해 동일