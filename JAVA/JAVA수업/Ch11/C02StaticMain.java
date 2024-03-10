package Ch11;

class C02Simple{
	int n1;
	static int n2;
	
	void func1() {
		n1 = 10;
		n2 = 20;
	}
	
	static void func2() {		// static  함수 : 멤버변수에는 접근 X
		// 객체 생성 이전에 사용 가능
		n2 = 30; 	// 접근 가능
//		n1 = 400;	// 접근 불가 <- 만들어질지 안만들어질지 모르는 n1 에 접근할 수 없음
	}
}

public class C02StaticMain {

	public static void main(String[] args) {
		
	}
}
