package ch2;

public class FloatEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f	 = 9.1234567890123456789f;
		float f2 = 1.2345678901234567890f;
		double d = 9.1234567890123456789d;
		
		System.out.printf("	123456789012345678901234%n");
		System.out.printf("f  :	%f%n", f);		// 소수점 이하 6째자리까찌 출력(7자리에서 반올림)
		System.out.printf("f  : %24.20f%n", f);	// 전체 24자리 중에서 20자리는 소수점 이하의 수 출력
		System.out.printf("f2 : %24.20f%n", f2);
		System.out.printf("d  : %24.20f%n", d);
	}

}
/*	실수형 값을 출력할 때는 printf() 메서드의 지시자 '%f' 사용

 */
