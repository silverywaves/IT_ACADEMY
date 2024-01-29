package ch3;

public class OperatorEx21_comparisonOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("10 == 10.0f \t %b%n", 10 == 10.0f);		// int 를 float 로 변환하여 비교
		System.out.printf("'0' == 0 \t %b%n", '0' == 0);			// '0' == 48 != 0
		System.out.printf("'A' == 65 \t %b%n", 'A' == 65);			// 'A' == 65 == 65
		System.out.printf("'A' > 'B' \t %b%n", 'A' > 'B');			// ('A'==65) < ('B'==66)
		System.out.printf("'A' + 1 != 'B' \t %b%n", 'A' + 1 != 'B');// ('A'+1==65+1 ==66) == ('B'==66)
	}

}
/*	비교연산자
 * 		두 피연산자를 비교하는데 사용 (주로 조건문, 반복문의 조건식으로 사용)
 * 		true / false
 * 		이항 연산자 -> 피연산자 타입이 다르면 자료형의 범위가 큰 쪽으로 자동형변환 후 비교
 * 		=> 대소비교 연산자 : boolean 형을 제외한 모든 자료형에 사용 가능
 * 		=> 등가비교 연산자 : 참조형 포함 모든 자료형에 사용 가능
 * 				    기본형과 참조형은 서로 형변환 불가능 -> 등가비교연산자로 비교
 * */
