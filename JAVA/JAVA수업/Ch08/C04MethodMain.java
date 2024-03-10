package Ch08;

import java.util.Scanner;

class MethodTest{
	// 속성
	public Scanner sc = new Scanner(System.in);
	
	// 기능
	// 인자를 받고 반환도 하는
	public int sum1(int n1, int n2) {	// 사용방법에 대한 명시
		return n1+n2;			// 구현
	}
	// 인자를 받지 않고 반환은 하는
	public int sum2() {
		return sc.nextInt() + sc.nextInt();
	}
	// 인자를 받고 반환은 하지 않는
	public void sum3(int n1, int n2) {
		System.out.println(n1+n2);	// return 없어도 호출했던 함수로 되돌아감(회귀)
	}
	// 인자를 받지 않고 반환도 하지 않는
	public void sum4() {
		System.out.println(sc.nextInt() + sc.nextInt());
}
}

public class C04MethodMain {

	public static void main(String[] args) {
		MethodTest sumCalc = new MethodTest();
		System.out.println(sumCalc.sum1(10, 20));
		System.out.println(sumCalc.sum2());
		sumCalc.sum3(10,20);
		sumCalc.sum4();
	}

}
