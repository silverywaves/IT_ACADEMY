package ch5;

public class ArrayEx15 {

	public static void main(String[] args) {
		// char 배열과 String 클래스의 변환
		String src = "ABCDE";
		
		for(int i=0; i<src.length(); i++) {		// length : 배열의 길이 / length() : 문자열의 길이
			char ch = src.charAt(i);	// src 의 i 번째 문자를 ch 에 저장
			System.out.println("src.charAt(" + i + "):" + ch);
		}
		// String 을 char[] 로 변환
		char[] chArr = src.toCharArray();
		
		// char[] (char 배열)을 출력
		System.out.println(chArr);		// println() 로 문자배열 출력하면 문자열 출력하듯 모든 요소를 이어서 한줄로 출력
	}

}
/*		charAt(int idx) : 문자열 중 idx 번째 위치에 있는 문자 추출(idx 는 배열처럼 0부터 시작)
 * 
 * 		char[] chArr = {'A', 'B', 'C'};
 * 		String str = new String(chArr);		// char 배열 -> String
 * 		char[] tmp = str.toCharArray();		// String -> char 배열
 * */
