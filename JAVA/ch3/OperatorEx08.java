package ch3;

public class OperatorEx08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1_000_000;		// 1,000,000	1백만
		int b = 2_000_000;		// 2,000,000	2백만
		
		long c = a * b;			// a * b = 2,000,000,000,000 ?
		
		System.out.println(c);	// -1454759936
	}

}
/*	int * int = int
 * 		=> a * b 의 결과가 이미 int 타입의 값이므로 long 형으로 자동 형변환되어도 값 변동x
 * 
 * 	올바른 결과를 얻으려면
 * 	long c = (long)a * b;
 * 	-> long c = (long)1000000 * 2000000;
 * 	-> long c = 1000000L * 2000000;
 * 	-> long c = 1000000L * 2000000L;
 *  -> long c = 2000000000000L;
 * */
