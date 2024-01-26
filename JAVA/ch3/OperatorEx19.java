package ch3;

public class OperatorEx19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 8;
		
		System.out.printf("%d을 %d로 나누면, %n", x, y);
		System.out.printf("몫은 %d이고, 나머지는 %d입니다.%n", x / y, x % y);
	}

}
/*	'%' 나머지 연산자
 * 		왼쪽의 피연산자를 오른쪽 피연산자로 나누고 난 나머지 값 출력
 * 		나누는 수(오른쪽 피연산자) 0 불가
 * 		짝수, 홀수, 배수 검사 등에 사용
 * */
