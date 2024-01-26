package ch3;

public class OperatorEx22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f = 0.1f;			// 
		double d = 0.1;
		double d2 = (double)f;	// 부호, 지수 변화 x, 가수의 빈자리를 0으로 채움
								// => float 값을 정밀도가 더 높은 double 로 변환해도 오차가 적어지는 것은 아님
		
		System.out.printf("10.0==10.0f %b%n", 10.0==10.0f);	// 10.0f : 오차없이 저장 가능 -> double 형변환해도 오차 x
		System.out.printf("0.1==0.1f %b%n", 0.1==0.1f);		// false 인 이유 : 실수형은 근사값으로 저장 
															// -> 저장할 때 2진수로 변환하는 과정에서 오차 발생
		System.out.printf("f=%19.17f%n", f);
		System.out.printf("d=%19.17f%n", d);
		System.out.printf("d2=%19.17f%n", d2);
		System.out.printf("d==f %b%n", d==f);				// d == (double)f -> 0.10000000000000000 == (double)0.10000000149011612
															// -> 0.10000000000000000 == 0.10000000149011612 -> false
		System.out.printf("d==d2 %b%n", d==d2);
		System.out.printf("d2==f %b%n", d2==f);				// double d2 = (double)f; -> double d2 = (double)0.10000000149011612;
															// -> double d2 = 0.10000000149011612;
															// d2 == f -> 0.10000000149011612 == 0.10000000149011612 -> true
		
		System.out.printf("(float)d==f %b%n", (float)d==f);	// (float)0.10000000000000000 == 0.10000000149011612;
															// -> 0.10000000149011612 == 0.10000000149011612; -> true
	}

}
