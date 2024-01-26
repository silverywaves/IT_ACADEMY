package ch3;

public class OperatorEx13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c1 = 'a';
//		char c2 = c1 + 1;		// 에러 발생 => 변수가 들어가면 컴파일러가 미리 계산 x => 형변환 필요
		char c2 = 'a' + 1;		// 에러 x => 'a' + 1 은 리터럴 간의 연산!
								// => 상수 또는 리터럴 간 연산은 실행과정동안 변하는 값 x
								// => 컴파일러가 미리 덧셈 연산 수행(실행시 덧셈 연산 수행 x)
		System.out.println(c2);
	}

}
