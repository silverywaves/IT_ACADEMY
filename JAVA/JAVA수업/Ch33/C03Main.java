package Ch33;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

//제공되는 함수형 인터페이스들
//Function<T, R>:
//apply 메서드를 가지고 있어서 하나의 인자(T)를 받아서 결과(R)를 반환하는 함수형 인터페이스입니다.
//
//Supplier<T>:
//get 메서드를 가지고 있어서 어떠한 인자도 받지 않고 결과만을 제공하는 함수형 인터페이스입니다.
//
//Consumer<T>:
//accept 메서드를 가지고 있어서 어떠한 인자를 받아서 결과를 반환하지 않는 함수형 인터페이스입니다.
//
//Predicate<T>:
//test 메서드를 가지고 있어서 어떠한 인자를 받아서 불리언 결과를 반환하는 함수형 인터페이스입니다.
//
//UnaryOperator<T>:
//apply 메서드를 가지고 있어서 하나의 인자를 받아서 동일한 타입의 결과를 반환하는 함수형 인터페이스입니다.
//
//BinaryOperator<T>:
//apply 메서드를 가지고 있어서 두 개의 인자를 받아서 동일한 타입의 결과를 반환하는 함수형 인터페이스입니다.


public class C03Main {

	// 01 Function<파라미터, 반환자료형> func = ()->{}
	public static Function<Integer,Integer> func1 = x -> x*x;	// 정수를 입력받아 제곱한 결과를 반환하는 함수
	public static Function<Integer,Integer> func2 = x -> x+x;	// 정수를 입력받아 자기 자신을 더한 결과를 반환하는 함수
		
	// 02 파라미터를 받는 리스트
	public static Function<List<Integer>,Integer> func3 = x -> x.stream().reduce((a, b)->a+b).get();
	// 정수 리스트를 입력받아 그 합계(누적합)를 반환하는 함수
	
	// 03 모든 자료형 받아내고 정수형 데이터만 필터링
	public static Function<List<Object>,List<Integer>> func4 = x -> {
//		return x.stream()
//				.filter(item->{return item instanceof Integer;})
//				.map(item->{return (Integer)item;})			
//				.collect(Collectors.toList());
		return x.stream()
				.filter(item->item instanceof Integer)
				.map(item->(Integer)item)			
				.collect(Collectors.toList());	// 객체 리스트를 입력받아 정수만 필터링하여 정수 리스트로 반환하는 함수
	};
	
	// 04 null 체크 포함 Optional
	public static Function<List<Object>,List<Integer>> func5 = x->{
		return Optional.ofNullable(x)	// 1차 걸러냄
						.map(list->list.stream()					// NULL 이 아니면
							.filter(item->item instanceof Integer)	// Integer 추출
							.map(item->(Integer)item)				// 재구성
							.collect(Collectors.toList())			// List 형으로 변환
						)	// 객체 리스트를 입력받아 정수만 필터링하여 정수 리스트로 반환하는 함수
						.orElse(Collections.emptyList());	// null 값일 경우 빈 리스트를 반환
	};
	
	// 05 인터페이스간 조합 가능  => default 를 쓰면 인터페이스에서도 완성된함수
	public static Function<Integer,Integer> f1Andf2 = func1.andThen(func2);	// func1 후 func2 진행
	public static Function<Integer,Integer> f2Andf1 = func2.andThen(func1);	// func2 후 func1 진행
	public static Function<List<Object>,Integer> f4Andf3 = func4.andThen(func3); // func4 후 func3 진행
	
	// 06 BinaryOperator
	public static BinaryOperator<Integer> func6 = (a,b)->a+b;	// 두 정수를 입력받아 그 합을 반환하는 BinaryOperator
	public static BiFunction<Integer, Integer, Integer> func7 = (a,b)->a+b;	// // 두 정수를 입력받아 그 합을 반환하는 BiFunction <첫번째인자, 두번째인자, 반환자료형>
	
	// 07
	// 정수를 입력받아 또 다른 정수를 반환하는 함수를 반환하는 함수
	public static Function<Integer, Function<Integer, Integer>> func8 = (x)->{return (y)->{return x+y;};};	// 리턴타입 function(로직으로 기재)
															 // func8 = x -> y -> x+y
	// func8를 사용하여 세 정수의 합을 계산하는 함수를 반환하는 함수
	public static Function<Integer, Function<Integer, Function<Integer, Integer>>> func9 = x -> y -> z -> x+y+z; // JS 클로저와 비슷
	
	public static void main(String[] args) {
//		// 01
//		System.out.println(func1.apply(10));
//		System.out.println(func2.apply(10));
//		
//		// 02
//		List<Integer> li1 = new ArrayList();
//		li1.add(10);li1.add(20);li1.add(30);li1.add(40);li1.add(50);li1.add(60);
//		System.out.println(func3.apply(li1));
//		
//		// 03
//		List<Object> li2 = new ArrayList();
//		li2.add(10);li2.add(20);li2.add(30);li2.add(40);li2.add(50);li2.add(60);
//		li2.add("HELLO");li2.add(15.2);li2.add('a');
//		System.out.println(func4.apply(li2));
//		
//		// 04
//		List<Integer> result1 = func4.apply(null);
//		System.out.println(result1); 	// 예외가 그대로 나옴(중단)
//		
//		List<Integer> result2 = func5.apply(null);
//		System.out.println(result2);	// 중단되지 않고 빈 배열 나옴
//		
//		// 05
//		System.out.println(f1Andf2.apply(5));
//		System.out.println(f2Andf1.apply(5));
//		
//		System.out.println(f4Andf3.apply(li2));
		
		// 06
		System.out.println(func6.apply(5, 10));
		System.out.println(func7.apply(5, 10));
		
		// 07
		System.out.println(func8.apply(10).apply(20));
						// func8 = (10)->{return (y)->{return x+y;};};
						// func8.apply(10) => (y)->{return 10+y;}.apply(20) => 10+20
		System.out.println(func9.apply(10).apply(20).apply(30));
						// func9 = (10)->{return (y)->{return x+y;};};
						// func9.apply(10) => (y)->{return 10+y;}.apply(20) => 10+20
		
	}
}










