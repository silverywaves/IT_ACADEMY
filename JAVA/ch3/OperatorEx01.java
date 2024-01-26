package ch3;

public class OperatorEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5;
		i++;					// i = i + 1; 과 같은 의미. ++i; 로 바꿔써도 동일
		System.out.println(i);
		
		i = 5;					// 결과를 비교하기 위해 i 값을 다시 5로 변경
		++i;					// i 의 값을 1 증가 시킴. i++; 과 동일
		System.out.println(i);
	}

}
/*	단항 연산자 中 증감 연산자
 * 		- 증가 연산자(++) : 피연산자의 값을 1 증가시킴	// j = ++i;
 * 		- 감소 연산자(--) : 피연산자의 값을 1 감소시킴  // j = --i;
 * 
 * 		- 전위형 : 값이 참조되기 전에 증가		// j = ++i;
 * 					변수(피연산자)의 값을 먼저 증가시킨 후에 변수의 값을 읽어옴
 * 		- 후위형 : 값이 참조된 후에 증가		// j = i++;
 * 					변수를 먼저 읽어온 후 값을 증가시킴
 * 
 * 			=> 수식이나 메서드 호출에 포함되지 않고 독립적인 문장으로 쓰이면 값 차이 x
 * */
