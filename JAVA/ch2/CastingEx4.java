package ch2;

public class CastingEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 91234567;		// 8자리의 10진수
		float f = (float)i;		// int 를 float 로 형변환
		int i2 = (int)f;		// float 를 다시 int 로 형변환
		
		double d = (double)i;	// int 를 double 로 형변환
		int i3 = (int)d;		// double 을 다시 int 로 형변환
		
		float f2 = 1.666f;
		int i4 = (int)f2;
		
		System.out.printf("i=%d\n", i);
		System.out.printf("f=%f i2=%d\n", f, i2);
		System.out.printf("d=%f i3=%d\n", d, i3);
		System.out.printf("(int)%f=%d\n", f2, i4);
	}

}
/*	정수형 -> 실수형 변환
 * 		정수를 2진수로 변환 -> 정규화 -> 실수의 저장형식으로 저장
 * 		실수형의 정밀도의 제한으로 인한 오차 발생 가능성有
 * 		10진수로 8자리 이상 값을 실수형으로 변환할 때는 double 로 해야 오차 발생 x
 * 
 * 	실수형 -> 정수형 변환
 * 		실수형의 소수점이하 값은 버려짐 (반올림x)
 * */
