package Ch09;



public class C05StringClassMain {

	public static void main(String[] args) {

		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		String str4 = new String("java");
		
		// 주소값 확인
		System.out.printf("%x\n", System.identityHashCode(str1));
		System.out.printf("%x\n", System.identityHashCode(str2));
		System.out.printf("%x\n", System.identityHashCode(str3));
		System.out.printf("%x\n", System.identityHashCode(str4));
		System.out.println();
		
		System.out.println("str1==str2 ? " + (str1==str2));		// T 주소가 같아서 true
		System.out.println("str3==str4 ? " + (str3==str4));		// F 주소값 비교 <= "==" 자체가 숫자를 비교하는 것
		System.out.println("str1==str3 ? " + (str1==str3));		// F 
		System.out.println("str2==str4 ? " + (str2==str4));		// F 
		System.out.println();
		System.out.println("str1==str2 ? " + (str1.equals(str2)));	// T 문자열 비교=>equals
		System.out.println("str1==str2 ? " + (str3.equals(str4)));	// T
		System.out.println("str1==str2 ? " + (str1.equals(str3)));	// T
		System.out.println("str1==str2 ? " + (str2.equals(str4)));	// T
	}
}
