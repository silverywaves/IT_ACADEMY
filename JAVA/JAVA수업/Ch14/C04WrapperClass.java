package Ch14;

public class C04WrapperClass {

	public static void main(String[] args) {
		// Boxing(기본 자료형 -> Wrapper Class)
		Integer ob1 = new Integer(100);		//The constructor Integer(int) has been deprecated since version 9 and marked for removal : 현재 잘 쓰이진 않음
		Integer ob2 = new Integer("100");	// 숫자형 바로 변환
		Integer ob3 = Integer.valueOf("300");
		System.out.println(ob1+ob2+ob3);
		
		// UnBoxing
		int n1 = ob1.intValue();
		int n2 = ob1.intValue();
		int n3 = ob1.intValue();
		System.out.println(n1+n2+n3);
		
		// Auto Boxing
		Integer ob4 = 100;					// Integer 형, int 형으로 타입이 달라도 자동 박싱
		int n4 = ob1 + ob2 + ob3;
		
	}
}
