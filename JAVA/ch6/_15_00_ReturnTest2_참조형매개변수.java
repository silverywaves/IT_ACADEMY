package ch6;

public class _15_00_ReturnTest2_참조형매개변수 {

	public static void main(String[] args) {
		_15_00_ReturnTest2_참조형매개변수 r = new _15_00_ReturnTest2_참조형매개변수();
		int result = r.add(3, 5);
		System.out.println(result);
		
		int[] result2 = {0};	// 배열을 생성하고 result2[0]의 값을 0으로 초기화
		r.add(3, 5, result2);	// 배열을 add 메서드의 매개변수로 전달
		System.out.println(result2[0]);
	}
	
	int add(int a, int b) {
		return a + b;
	}
	
	void add(int a, int b, int[] result) {
		result[0] = a + b;		// 매개변수로 넘겨받은 배열에 연산결과를 저장
	}

}

// 메서드는 단 하나의 값만을 반환할 수 있지만 참조형매개변수를 활용하면 여러 개의 값을 반환받는 것과 같은 효과를 얻을 수 있음
