package Ch09;

import java.util.Scanner;

public class C06StringClassMain {

	public static void main(String[] args) {
		
		String str1 = "Java Powerful";
		String str2 = new String("Java Programming");
		String str3 = str1 + str2;
		String str4 = str1.concat(str2);
		
		// 문자열 덧붙일 때
		StringBuffer str5 = new StringBuffer();
		System.out.println();
		System.out.printf("%x\n", System.identityHashCode(str5));
		str5.append(str1).append(str2).append(str3).append(str4);	// 동적확장
		System.out.printf("%x\n", System.identityHashCode(str5));
		System.out.println();
		
		// 문자열 확인
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);

		System.out.println();
		
		// 위치확인
		System.out.printf("%x\n", System.identityHashCode(str1));
		System.out.printf("%x\n", System.identityHashCode(str2));
		System.out.printf("%x\n", System.identityHashCode(str3));
		System.out.printf("%x\n", System.identityHashCode(str4));
		
		//
		System.out.println();
		System.out.println("문자열길이 : " + (str1.length()));		// 'a' = 숫자-> . 으로 선택 불가, "aa" = 만주 -> . 으로 선택가능
		System.out.println("문자찾기 : " + (str1.charAt(1)));		// charAt(i) : i 번째 문자 찾기
//		Scanner sc = new Scanner(System.in);
//		char ch = sc.next().charAt(0);	// nextChar() 는 없음 => 대신 next() : 문자열(공백x)
		System.out.println("문자열의 index 번호 : " + (str1.indexOf("a")));
		System.out.println("문자열의 index 번호 : " + (str1.lastIndexOf("a")));
		System.out.println();
		System.out.println("문자 포함 여부 : " + (str1.contains("va")));
		System.out.println("문자 포함 여부 : " + (str1.contains("abs")));
		System.out.println();
		
//		Scanner sc = new Scanner(System.in) {
//			String tmp = sc.nextLine();
//			System.out.println(tmp.length());
//			System.out.printnl(tmp.trim().length());	// trim() : 앞뒤 공백 제거
//		}
		
		System.out.println("문자열자르기 : " + (str1.substring(2,5)));	// (a, b) : a 부터 b 만큼
		System.out.println();
		String str6 = "홍길동,남길동,서길동,동길동,길동길동";
		String[] result = str6.split(",");		// split("구분자") : 구분자 기준으로 잘라내어 배열을 만듦. 자주 쓰임
		for(String val : result) {
			System.out.println(val);
		}
		
		// toUpperCase(): 소문자->대문자
		// toDownCase()	: 대문자->소문자
		// replace(a,b)	: a 를 b 로 변환
		
	}
}
