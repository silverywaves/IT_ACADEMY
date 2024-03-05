package ch7;		// 선언 : package 패키지명;	<= 소스파일에서 주석과 공백을 제외한 첫 번째 문장
					// 대소문자 모두 허용하지만 클래스명과 쉽게 구분하기 위채 소문자로 하는 것을 원칙으로 함
public class _10_PackageTest {
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
}
}
/*	패키지
 * 	- 물리적으로 클래스 파일(.class)을 포함하는 하나의 디렉토리
 * 	- 하나의 소스파일에는 첫 번째 문장으로 단 한 번의 패키지 선언만을 허용
 * 	- 모든 클래스는 반드시 하나의 패키지에 속해야 함
 * 	- 점(.)을 구분자로 하여 계층구조로 구성
 * 	
 * 	jar 파일 : 클래스 파일들을 압축한 것
 * */
