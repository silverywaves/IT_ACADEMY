package Ch02;

public class C05상수 {

	public static void main(String[] args) {
		//상수 : 항상 같은 수 
		
		//리터럴 상수 : 이름부여 x , 상수 Pool 에 저장 , 단순한 수치,값
		//심볼릭 상수 : 이름부여O , final 예약어 사용 (const)
		
		
		//리터럴 접미사 : 리터럴 상수가 저장되는 자료형을 지정
		//l,L : long 자료형
		//f,F : float 자료형
		
		
//		고정소수점 / 부동소수점 개념 알고가기
		
		int n1 = 100; 				//100은 리터럴 상수 
		final int n2 = 200;			//n2는 심볼릭 상수
		
		final double PI = 3.14;		// 값 변경불가
		double result = PI*4*4;
		
		 
		double a = 1e-3;
		System.out.println(a);
		
	}

}
