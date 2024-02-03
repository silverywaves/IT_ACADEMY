package ch5;

public class ArrayEx13_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] name = new String[3]   // 3개의 문자열을 담을 수 있는 배열 생성
										// 참조형 변수의 기본값은 NULL 이므로 각 요소의 값은 NULL 로 초기화
		
//		String[] names = new String[]{"Kim","Park", "Yi"};	// new String[] 생략 가능
		String[] names = {"Kim", "Park", "Yi"};
		
		for(int i=0; i< names.length; i++) {
			System.out.println("names[" + i + "]:" + names[i]);
		}
		
		String tmp = names[2];			// 배열 names 의 세번째 요소를 tmp 에 저장
		System.out.println("tmp:" + tmp);
		
		names[0] = "Yu";				// 배열 names 의 첫번째 요소를 "Yu" 로 변경
		
		for(String str : names)
			System.out.println(str);
		
	}

}
/*	String 배열의 초기화
 * 		String[] name = new String[3];
 * 		name[0] = new String("Kim");		--큰 따옴표만으로 간략히 표현 허용-->	name[0] = "Kim";
 * 		name[1] = new String("Park");		--큰 따옴표만으로 간략히 표현 허용-->	name[1] = "Park";
 * 		name[2] = new String("Yi");			--큰 따옴표만으로 간략히 표현 허용-->	name[2] = "Yi";
 * 	=> 참조형 배열(객체 배열)에 실제 객체가 아닌 객체의 주소가 저장됨
 * 
 * 
 * 	변수의 타입에 따른 기본값
 * 		자료형			->			기본값
 * 		boolean			->			false
 * 		char			->			'\u0000'
 * 	 byte, short, int	->			0
 * 		long			->			0L
 * 		float			->			0.0f
 * 		double			->			0.0d or 0.0
 * 	   참조형변수		->			null
 * 
 * 
 * 
 * 		String 클래스는 char 배열에 기능(메서드)를 추가한 것
 * 		+ String 객체(문자열)는 읽울수만 있을 뿐, 내용 변경 불가
 * 			String str = "JAVA";
 * 			str = str + "8";			// 변경 X. 새로운 문자열이 str 에 저장
 * 			System.out.println(str);	// "JAVA8"
 * */

