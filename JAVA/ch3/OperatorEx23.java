package ch3;

public class OperatorEx23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abc";
		String str2 = new String("abc");
		
		System.out.printf(" \"abc\" == \"abc\" ? %b%n " , "abc" == "abc");
		System.out.printf(" str1 == \"abc\" ? %b%n ", str1 == "abc");
		System.out.printf(" str2 == \"abc\" ? %b%n ", str2 == "abc");	// 내용은 같지만 서로 다른 객체라서 false
		
		System.out.printf(" str1.equals(\"abc\") ? %b%n ", str1.equals("abc"));
		System.out.printf(" str2.equals(\"abc\") ? %b%n ", str2.equals("abc"));	// 객체가 달라도 내용이 같으면 true
		System.out.printf(" str2.equals(\"ABC\") ? %b%n ", str2.equals("ABC"));
		
		System.out.printf(" str2.equalsIgnoreCase(\"ABC\") ? %b%n ", str2.equalsIgnoreCase("ABC"));	// 대소문자 구별 x 비교
	}

}
/*	문자열 비교시 '==' 대신 equals()
 * 	'=='	 : 두 문자열이 완전히 같은 것인지 비교
 * 	equals() : 문자열의 내용이 같은지 비교. 같으면 true, 다르면 false
 * */
