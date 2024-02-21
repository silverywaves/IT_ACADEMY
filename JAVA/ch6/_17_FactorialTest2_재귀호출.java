package ch6;


public class _17_FactorialTest2_재귀호출 {

	static long factorial(int n) {
		if(n<=0 || n>20) return -1;		// 매개변수 유효성 검사 : n 이 음수거나 20보다 크면 -1 반환
		if(n<=1) return 1;
			return n * factorial(n-1);
	}
	
	public static void main(String[] args) {
		int n = 21;
		long result = 0;
		
		for(int i=1; i<=n; i++) {
			result = factorial(i);
			
			if(result == -1) {
				System.out.printf("유효하지 않은 값입니다.(0<n<=20):%d%n", n);
				break;
			}
			
			System.out.printf("%2d != %20d%n", i, result);
		}
	}

}
