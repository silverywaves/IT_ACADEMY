package ch6;

public class _23_VarArgsEx_가변인자와오버로딩 {

	public static void main(String[] args) {
		String[] strArr = {"100", "200", "300"};
		
		System.out.println(concatenate("", "100", "200", "300"));	// 인자 여러개 가능
		// +
		System.out.println(concatenate("-", strArr));				
		// =
		System.out.println(concatenate("-", new String[] {"100", "200", "300"}));   // 배열 가능
//		System.out.println(concatenate("-", {"100", "200", "300"}));		// error
		// --------------------------------------------
		
		System.out.println(concatenate(",", new String[] {"1", "2", "3"}));
		System.out.println("["+concatenate(",", new String[0])+"]");
		System.out.println("["+concatenate(",")+"]");
	}
	
	static String concatenate(String delim, String... args) {
		String result = "";
		
		for(String str : args) {
			result += str + delim;
		}
		
		return result;
	}
//	static String concatenate(String... args) {
//		return concatenate("", args);
//	}	// The method concatenate(String, String[]) is ambiguous for the type VarArgsEx
		// 두 오버로딩된 메서드가 구분되지 않아 발생 -> 가능하면 가변인자를 사용한 메서드는 오버로딩X
}	

/*	가변인자(varargs)
 * 		- 선언 : 타입... 변수명
 * 		- 가변인자 외 매개변수가 더 있다면 가변인자를 매개변수 중 가장 마지막에 선언
 * 		- 내부적으로 배열 이용 -> 메서드 호출시마다 새로운 배열 생성 => 꼭 필요한 경우만 사용
 * */

