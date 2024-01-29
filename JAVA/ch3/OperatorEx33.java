package ch3;

public class OperatorEx33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x;
		System.out.println(x = 3);		// 변수 x 에 3이 저장되고
		// -> System.out.println(3);		연산결과인 3이 출력
		
		int i = 0;
//		3 = i + 3;					에러. lvalue 가 값을 저장할 수 있는 공간이 아님
//		i + 3 = i;					에러. lvalue 의 연산결과는 리터럴(i+3->0+3->3)
		
		final int Max = 3;			// 변수 앞에 키워드 final 을 붙이면 상수
//		MAX = 10;					에러. 상수(MAX) 에 새로운 값을 저장할 수 없음
		
	}

}
/*		대입연산자
 * 			변수와 같은 저장공간에 값 또는 수식의 연산결과를 저장
 * 			- lvalue(left value) : 대입연산자의 왼쪽 피연산자. 변수처럼 값을 변경할 수 있는것만 가능
 * 			- rvalue(right value): 대입연산자의 오른쪽 피연산자. 변수, 식, 상수 가능
 * 
 * */
