package ch6;

// 클래스멤버가 인스턴스 멤버를 참조 혹은 호출하고자 하는 경우 => 인스턴스 생성
// 인스턴스멤버가 존재하는 시점에 클래스멤버는 항상 존재하지만,
// 클래스멤버가 존재하는 시점에 인스턴스멤버가 존재하지 않을 수도 있기 때문

public class MemberCall {
	int iv = 10;
	static int cv = 20;
	
	int iv2 = cv;
//	static int cv2 = iv;	// error : 클래스변수는 인스턴스 변수 사용 불가
	static int cv2 = new MemberCall().iv;	// 객체 생성해야 사용 가능
	
	static void staticMethod1() {
		System.out.println(cv);
//		System.out.println(iv);	// error : 클래스메서드에서 인스턴스변수 사용 불가
		MemberCall c = new MemberCall();
		System.out.println(c.iv);		// 객체 생성 후 인스턴스 변수 참조 가능
	}
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv);			// 인스턴스메서드에서는 인스턴스변수 바로 사용 가능
	}
	static void staticMethod2() {
		staticMethod1();
//		instanceMethod1();			// error : 클래스메서드에서는 인스턴스메서드 호출 불가
		MemberCall c = new MemberCall();
		c.instanceMethod1();		// 인스턴스 생성 후 호출 가능
	}
	void instanceMethod2() {		// 인스턴스메서드에서는 인스턴스메스드와 클래스메서드 모두
		staticMethod1();			// 인스턴스 생성없이 바로 호출 가능
		instanceMethod1();
	}
}
