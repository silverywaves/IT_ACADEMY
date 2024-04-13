package Ch33;

import java.util.Arrays;
import java.util.List;

// 함수형 프로그래밍 => 함수형 인터페이스 필요(추상메서드를 하나만 가짐)
@FunctionalInterface		// 함수형 인터페이스 애노테이션으로 명시
interface Func{
	void say(String message);	// 문자열을 출력하는 추상 메서드 선언
}

@FunctionalInterface		
interface Func2{
	int sum(int n1, int n2);	// 두 정수를 더하는 추상 메서드 선언
}

@FunctionalInterface		
interface Func3{
	int sum(int ... args);		// 가변인자(배열형태) 추상 메서드 선언
}

@FunctionalInterface		
interface Func4{
	List<Integer> sum(int ... args);	// Object 형으로하면 모든 형으로 받을 수 있음
}

public class C01Main {

	public static void main(String[] args) {
		
//		// 01 Func 인터페이스의 구현 객체 생성 및 메서드 호출
//		Func t1 = (m)->{System.out.println(m);};	// () 안에 인자 개수 맞춰줘야함
//		t1.say("HELLO");	// "HELLO" 출력
//		
//		// 02 만들어진 함수 연결 / 메서드 참조 연산자 이용
//		Func t2 = System.out::println;	
//		t2.say("HELLO WORLD");	// "HELLO WORLD" 출력
		
//		// 03 Func2 인터페이스의 구현 객체 생성 및 메서드 호출
//		Func2 t3 = (n1,n2)->{return n1+n2;};
//		System.out.println(t3.sum(10, 20));		// 30 출력
//		
//		// 04 Func3 인터페이스의 구현 객체 생성 및 메서드 호출
//		Func3 t4 = (numbers)->{
//			int sum = 0;
//			for(int n : numbers) {	// 가변인자 반복문 사용 
//				sum+=n;				// -> 합계 구하기
//			}
//			return sum;
//		};
//		
//		int result = t4.sum(10,2,3,1,40,120,4,2,5,77,6,4);
//		System.out.println(result);	// 합계 출력
		
		// 05 Func4 인터페이스의 구현 객체 생성 및 메서드 호출
		Func4 t5 = (numbers)->{
			return Arrays.asList(						// int->list
					Arrays.stream(numbers)				// 배열->Stream
						  .boxed()						// int->Integer 형으로 변환
						  .sorted((a, b)->{return a-b;})	// 정렬(기본 오름차순, 람다식으로 내림차순정령 변경 가능:b-a) 
						  .toArray(Integer[]::new)		// Integer 배열객체 반환
					);
		};
		List<Integer> result = t5.sum(55,11,251,9,15,2,1,67);
		System.out.print(result);	// 리스트 출력
		
	}
}
