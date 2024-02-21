package ch6;

public class _19_PowerTest_재귀호출 {

	public static void main(String[] args) {
		// x 의 1승부터 n 승까지의 합
		int x = 2;
		int n = 5;
		long result = 0;
		
		for(int i=1; i<=n; i++) {
			result += power(x, i);
		}
		System.out.println(result);
	}
	
	static long power(int x, int n) {
		if(n==1) return x;
		return x * power(x, n-1);
	}
}
