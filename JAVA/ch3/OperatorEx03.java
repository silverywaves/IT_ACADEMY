package ch3;

public class OperatorEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5, j = 5;
		System.out.println(i++);	// 값이 증가되기 전에 참조 -> println() 에 5 넘겨주고 1 증가
		System.out.println(++j);
		System.out.println("i = " + i + ", j = " + j);
	}

}
/*	증감 연산자를 사용하면 코드가 간결해지지만 남용하면 이해하기 어려움
 * 		=> 하나의 식에서 증감연산자의 사용 최소화
 * 		=> 식에 두번 이상 포함된 변수에 증감연산자를 사용 지양
 * */
