package Ch08;

// 오버로딩 : 메서드 이름은 같지만 매개변수 다양하게 for 개발의 편리성을 위하여 -> 함수 헤더부분을 다양하게 받을 수 있게함
class C06Simple{
	int sum(int x, int y) {		
		System.out.println("int sum(int x, int y)");
		return x + y;
	}
	int sum(int x, int y, int z) {	
		System.out.println("int sum(int x, int y, int z)");
		return x + y + z;
	}
	
	// 사용은 되지만, 함수의 반환타입(자료형)은 함수 오버로딩의 고려대상이 아님
	// 함수를 찾아낼 때 함수명과 매개변수의 형태로 구별
//	double sum(double x, double y, double z) {	
//		System.out.println("int sum(double x, double y, double z)");
//		return x + y + z;
//	}
	int sum(double x, double y, double z) {	
		System.out.println("int sum(double x, double y, double z)");
		return (int)(x + y + z);
	}
}

public class C06MethodOverloading {

	public static void main(String[] args) {
		C06Simple obj = new C06Simple();
		obj.sum(10, 20);
		obj.sum(10, 20, 30);
		obj.sum(10.5, 20.5, 30.5);
	}

}
