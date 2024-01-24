package ch2;

public class CastingEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f	  = 9.1234567f;
		double d  = 9.1234567;
		double d2 = (double)f;
		
		System.out.printf("f =%20.18f\n", f);
		System.out.printf("d =%20.18f\n", d);
			// 같은 값을 저장해도 정밀도 차이때문에 다른 값이 저장
		System.out.printf("d2 =%20.18f\n", d2);	
			// 저장할 때 이미 값이 달라졌기 때문에, 형변환해도 값이 같아지지 않음
	}

}
/*	실수형 간의 형변환
 * 		작은 타입 -> 큰 타입 : 빈 공간을 0으로 채움
 * 
 * 		float -> double
 * 			지수(E) : float 기저인 127을 뺀 후 double 기저인 1023을 더해서 변환
 * 			가수(M) : float 가수 23자리를 채우고 남은 자리는 0으로 채움
 * 
 * 		double -> float
 * 			지수(E) : double 기저인 1023을 뺀 후 float 기저인 127을 더해서 변환
 * 			가수(M) : double 가수 52자리 중 23자리만 저장, 나머지 버림
 * 					  가수의 24번째 자리에서 반올림 발생 가능성有 -> 23번째 자리 값 1 증가
 * 			float 타입의 범위를 넘는 값을 형변환할 경우 '+-무한대' or '+-0'
 * */
