package Ch08;

// 멤버 변수

// 지역 변수	: {} 내에서 선언되어지는 변수
//			: {} 에서 더이상 실행 로직이 없다면 공간 반환(없어짐)
//			: 변수명의 중복시 좁은 지역의 변수 적용
//			: 매개변수, 멤버변수, 일반변수

// 전역 변수	: static 예약어 사용시 
//			: 전역변수를 사용하는 지역이 많아지면 의존이 높아짐(영향 많이 받음) => 적으면 좋음

class C05Simple{
	int num = 5;	// 멤버변수
	void Func1() {
		System.out.println("멤버변수 num : " + num);
		int num = 10;		// 변수명 중복의 경우 : 좁은 지역 변수 사용
		System.out.println("Func1 지역변수 num : " + num);		
		System.out.println("this.num : " + this.num);		// 멤버변수에 접근하고 싶을 때 this
	}
	void Func2() {
		System.out.println("멤버변수 num : " + num);
		if(true) {
			int num = 22;
			System.out.println("if 내의 지역 num : " + num);
		}
		System.out.println("멤버변수 num : " + num);
//		while(num<10) {		// 무한루프발생
//			int num = 5;	// 실행해도 계속 5
//			num++;
//		}
	}
	void Func3(int num) {
		System.out.println("num : " + this.num);
	}
	void Func4() {}
}

public class C05LocalVarMain {

	public static void main(String[] args) {
		C05Simple obj = new C05Simple();
//		obj.Func1();
//		obj.Func2();
		obj.Func3(100);
	}
}
