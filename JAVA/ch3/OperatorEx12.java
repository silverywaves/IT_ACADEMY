package ch3;

public class OperatorEx12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c1 = 'a';		// c1 : 문자 'a' 의 코드값인 97 저장
		char c2 = c1;		// c1 에 저장되어 있는 값이 c2에 저장
		char c3 = ' ';		// c3 는 공백으로 초기화
		
		int i = c1 + 1;		// 'a' + 1 -> 97 + 1 -> 98
		
		c3 = (char)(c1 + 1);		// 덧셈연산 c1 + 1 의 결과는 int
									// 결과를 char 형 변수 c3 에 담기위해 형변환 필요
		c2++;
		c2++;
		
		System.out.println("i=" + i);
		System.out.println("c2=" + c2);		// 97 에서 1씩 두번 증가 => 99 => 문자 c
		System.out.println("c3=" + c3);
	}

}
/*	c2++; 대신 c2 = c2 + 1; 사용시 에러
 * 		=> c2 + 1 의 연산결과는 int 형이라 그 결과를 다시 c2 에 담으려면 char 형으로 형변환 필요
 * */

