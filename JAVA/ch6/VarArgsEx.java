package ch6;

public class VarArgsEx {
	public static void main(String[] args){
		String[] strArr = {"100", "200", "300"};
		// concatenate 메서드 => 매개변수로 입력된 문자열에 구분자르 사이에 포함시켜 결합해서 반환
		// => 가변인자로 매개변수를 선언 -> 문자열 개수 제약없이 매개변수 지정 가능
		System.out.println(concatenate("", "100", "200", "300"));
		System.out.println(concatenate("-", strArr));
		System.out.println(concatenate(",", new String[]{"1", "2", "3"}));
		// 위 문장은 아래 두 문장을 하나로 합친 것
		// String[] strArr = new String[]{"1", "2", "3"};
		// System.out.println(concatenate("-", strArr));
		System.out.println("["+concatenate(",", new String[0])+"]");
		System.out.println("["+concatenate(".")+"]");
	}
	static String concatenate(String delim, String... args) {
		String result = "";
		
		for(String str : args) {
			result += str + delim;
		}
		
		return result;
	}
//	static String concatenate(String...args) {
//		return concatenate("", args);
//	}	오버로딩된 메서드가 구분되지 않아 error 발생
//		가변일자를 선언한 메서드를 오버로딩하면 메서드 호출시 구별되지 못하는 경우 발생

}
/*	가변인자(variable arguments)
 *	 : '타입... 변수명'
 *	 : 메서드의 매개변수 개수를 동적으로 지정
 *	 : 가변인자 외에도 매개변수가 더 있으면 가변인자를 제일 마지막에 선언
 *	 : 가변인자는 내부적으로 배열을 이용하는 것 -> 가변인자가 선언된 메서드를 호출할때마다 배열이 새로 생성
 *
 * */
