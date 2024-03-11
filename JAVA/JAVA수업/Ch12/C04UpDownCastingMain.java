package Ch12;

class Super{
	int n1;
}

class Sub extends Super{
	int n2;
}

public class C04UpDownCastingMain {
	
	public static void main(String[] args) {
		// NoCasting
		Super ob1 = new Super();	// 자료형 일치 -> NoCasting
		ob1.n1 = 10;
		Sub ob2 = new Sub();		// 자료형 일치 -> NoCasting
		ob2.n2 = 10;
		ob2.n2 = 10;
		// UpCasting : 상위클래스형으로 형변환(자동형변환:부모->자식 확장되면 확장되었지 축소되진 않음)
		// 상위클래스 참조변수 = 하위클래스 객체
		// 사용이유 : 객체를 사용하기 위한 공통객체가 필요한 경우, 상위클래스로 연결하기위함
		Super ob3 = new Sub();		// Super ob3 = (Super)new Sub();
		ob3.n1 = 100;		// 접근 가능
//		ob3.n2 = 200;		// Error(접근 불가) <- 공간은 있지만, 자식 확장전까지만 연결됨
		
		// DownCasting : 하위클래스형으로 형변환(강제형변환)
		// 하위클래스 참조변수 = 상위클래스형 객체
		// UpCasting 후에 DownCasting 이루어짐 (UpCasting 상태를 전제로 생각해야함)
		Sub ob4 = (Sub)ob3;		// 오른쪽변 : 시작주소(Super 클래스형) -> 왼쪽으로 형을 맞춰줘야함
//		Sub ob4 = (Sub)new Super();	
//		ob4.n2=200;				// 실행시 오류 : 범위에 n2 가 없음
		
		ob4.n1 = 100;
		ob4.n2 = 200;
	}
}
