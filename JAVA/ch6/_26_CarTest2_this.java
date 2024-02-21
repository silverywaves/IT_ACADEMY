package ch6;

// 생성자에서 다른 생성자 호출하기 - this
// 1. 생성자의 이름으로 클래스이름 대신 this 사용
// 2. 한 생성자에서 다른 생성자를 호출할 때 반드시 첫 줄에서만 호출 가능
//    -> 생성자 내에서 초기화 작업도중에 다른 생성자를 호출하면, 다른 생성자 내에서도 멤버변수들의 값을 초기화 할 것이므로
//       다른 생성자의 호출하기 이전의 초기화 작업이 무의미해 질 수 있음

// * this : 인스턴스 자신을 가리키는 "참조변수", 인스턴스 주소가 저장되어있음
// * this(), this(매개변수) : "생성자", 같은 클래스의 다른 생성자를 호출할 때 사용


class Car2{
	String color;		// 색상
	String gearType;	// 변속기 종류 = auto(자동), manual(수동)
	int door;			// 문의 개수
	
	Car2(){
		this("white", "auto", 4);		// Car(String color, String gearType, int door)를 호출
	}				
	
	Car2(String color){
//		door = 5;					// Error : Constructor call must be the first statement in a constructor
//		Car2(color, "auto", 4);		// Error1 : 생성자의 두번째 줄에서 다른 생성자 호출 / Error2 : Car2 대신 this 써야함
		this(color, "auto", 4);		// 정상
	}
	
	Car2(String color, String gearType, int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}

public class _26_CarTest2_this {
	public static void main(String[] args) {
		Car2 c1 = new Car2();
		Car2 c2 = new Car2("blue");
		
		System.out.println("c1의 color = " + c1.color + ", gearType = " + c1.gearType + ", door = " + c1.door);
		System.out.println("c2의 color = " + c2.color + ", gearType = " + c2.gearType + ", door = " + c2.door);
	}
}	
