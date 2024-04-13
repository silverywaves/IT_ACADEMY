package Ch33;

import java.util.Arrays;

//함수형 인터페이스 선언
interface functional{
	int execute(int ...args);	// 가변인자를 받아서 정수형 결과를 반환하는 추상 메서드
}
class Calc{		// Calc 클래스 =>  덧셈, 뺄셈, 곱셈, 나눗셈을 수행하는 functional 타입의 변수들을 선언
	functional sum;	// 덧셈을 수행하는 functional 타입의 변수 선언
	functional sub;	// 뺄셈을 수행하는 functional 타입의 변수 선언
	functional mul;	// 곱셈을 수행하는 functional 타입의 변수 선언
	functional div;	// 나눗셈을 수행하는 functional 타입의 변수 선언
	
	Calc(){		// Calc 클래스의 생성자 => 각 연산에 해당하는 람다식을 정의하여 해당 변수들에 초기화
		// Stream.reduce(accumulator) : Stream의 요소들을 하나의 데이터로 만드는 작업을 수행
		// Stream.parallel() : Stream 연산을 병렬 처리로 수행
		//덧셈로직
		sum = (numbers)->Arrays.stream(numbers).reduce((a,b)->a+b).getAsInt();
		//뺄셈로직
		sub = (numbers)->Arrays.stream(numbers).sorted()		// 오름차순정렬
												.reduce((a,b)->b-a)
												.getAsInt();
		//곱셈로직
		mul = (numbers)->Arrays.stream(numbers).reduce((a,b)->a*b).getAsInt();
		//나눗셈로직
		div = (numbers)->Arrays.stream(numbers).reduce((a,b)->a/b).getAsInt();
	}
}


public class C02Ex {

	
	public static void main(String[] args) {
		Calc calc = new Calc();		// Calc 객체 생성 -> 결과 출력
		System.out.println("합 :"+ calc.sum.execute(10,20,30,40,50,60));
		System.out.println("차 :"+ calc.sub.execute(10,20,30,40,50,60));
		System.out.println("곱 :"+ calc.mul.execute(10,20,30,40,50,60));
		System.out.println("몫 :"+ calc.div.execute(10,20,30,40,50,60));
	}
}
