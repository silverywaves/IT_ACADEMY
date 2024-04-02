package Ch32;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C02FlatMap {

	public static void main(String[] args) {
		// 2차원(리스트 안에 리스트) 요소들을 한 스트림으로
		List<List<Integer>> numbers = Arrays.asList(
				Arrays.asList(1,2,3),
				Arrays.asList(4,5,6),
				Arrays.asList(7,8,9)
				);
		List<Integer> list = numbers.stream()
//									.flatMap((li)->li.stream())
									.flatMap(List::stream)		// 메서드 참조 연산자
									.collect(Collectors.toList());
		System.out.println(numbers);
		System.out.println(list);
	}
}
