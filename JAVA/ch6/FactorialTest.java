package ch6;

public class FactorialTest {

	public static void main(String[] args) {
		// 4! = 4 * 3 * 2 * 1 = 24
		// f(n) = n * f(n-1), 단 f(1) = 1
		int result = factorial(4);	// main 메서드와 같은 클래스 -> FactorialTest.factorial(4) 에서 클래스이름 생략
		
		System.out.println(result);
	}
	
	static int factorial(int n) {
		int result = 0;
		if (n == 1)
			result = 1;
		else
			result = n * factorial(n-1);	// 메서드 자신 호출
		
		return result;
	}

}
/*	재귀호출 : 메서드 내부에서 메서드 자신을 다시 호출, 조건문 필수
 * 		void method(){
 *			method();		// 재귀호출. 메서드 자신을 호출
 * 		}
 * 
 * 	- 반복문보다 수행시간이 길어 비효율적
 * 	- 논리적 간결함
 * 		=> 재귀호출에 드는 비용보다 간결함이 주는 이득이 충분히 큰 경우만 사용
 * */
