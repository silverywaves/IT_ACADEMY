package ch2;

public class StringEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "Ja" + "va";
		String str = name + 17;
		
		System.out.println(name);
		System.out.println(str);
		System.out.println(7 + " ");
		System.out.println(" " + 7);
		System.out.println(7 + "");
		System.out.println("" + 7);
		System.out.println("" + "");
		System.out.println("7" + "7");
		System.out.println(7 + 7 + "");
			// 14 + "" -> "14" + "" -> "14"
		System.out.println("" + 7 + 7);
			// "7" + 7(String 으로 변환) -> "7" + "7" -> "77"
	}

}

/*
 * ** 문자 리터럴 : 'A' 와 같이 작은따옴표로 문자 하나를 감싼 것
	        		두 문자 이상은 큰 따옴표로 감사며 '문자열 리터럴'이라고 함
	        		
		char ch = 'J';			// char ch = 'Java' 불가
		String name = "Java";	// 변수 name에 문자열 리터럴 "Java" 저장
		String str = "";		// 내용이 없는 빈 문자열 가능
		char ch = '';			// 에러. '' 안에 반드시 하나의 문자 필요
		char ch = ' ';			// 공백 문자(blank)로 변수 ch 초기화 가능
		
		문자열 + any type -> 문자열 + 문자열 -> 문자열
		any type + 문자열 -> 문자열 + 문자열 -> 문자열
		
		true + "" -> "true" + "" -> "ture"
 * */