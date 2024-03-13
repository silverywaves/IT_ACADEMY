package Ch14;

class A {
	int x;
	int y;
	@Override
	public String toString() {
		return "x = " + x + " y = " + y ;
		
	}
	
}

public class C01ObjectMain {

	public static void main(String[] args) {
		Object ob = new Object();
		
		System.out.println(ob);				// 클래스형 자료형이라면 toString 과 동일한 결과(자동호출) -why?
		System.out.println(ob.toString());	
//      class Object { ... return getClass().getName() + "@" + Integer.toHexString(hashCode()); ... }
		
		A ob2 = new A();	
//		ob2.		// 어떤 단위를 받을 때 Object 단위로 받으면 모든 단위 받을 수 있음 (업캐스팅) 메서드 옆 "-Object"
//		ob2.		// calss A 오버라이딩 후 -> toString() : String -A 로 바뀜(재정의된 상태 의미)
					// 나머지는 여전히 Object
		System.out.println(ob2);				// toString 과 동일한 결과
		System.out.println(ob2.toString());	
	}
}
