package Ch15;

// throws - 단수(던지다)
// throw  - 복수(던지다)

class A{
	public void Ex1() throws NullPointerException {	 // 예외처리를 호출했던 위치에서 관리하도록 함
		throw new NullPointerException("NULLException");	// 인위적인 예외 발생시킴(테스트용으로 주로 사용)
	}
}
class B{
	
	public void Ex2(A a) {
		try {			// 호출위치에서 관리
			a.Ex1();
		}catch(Exception e){
			System.out.println("B.Ex2 Function's Exception ..");
		}
	}
}

public class C05ThrowAndThrows {

//	public static void Ex1() throws NullPointerException{	// 예외처리를 호출했던 위치에서 관리하도록 함
//		try {
//			throw new NullPointerException("Ex1에서 발생시킨 Null");	// 인위적인 예외 발생시킴(테스트용으로 주로 사용)
//			throw new ClassCastException("Ex1에서 발생시킨 Null");
//		} catch(Exception e) {
//			System.out.println(e);
//		}
//	}
	
	public static void main(String[] args) {
		
		System.out.println("실행코드1");
		System.out.println("실행코드2");
		A a = new A();
		B b = new B();
			
		b.Ex2(a);		
		
		System.out.println("실행코드3");
		
	}
}
