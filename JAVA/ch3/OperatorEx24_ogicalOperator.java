package ch3;

public class OperatorEx24_ogicalOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x= 0;
		char ch = ' ';
		
		x= 15;
		System.out.printf("x=%2d, 10 < x && x < 20 = %b%n", x, 10 < x && x < 20);
		
		x = 6;
		System.out.printf("x=%2d, x%%2==0 || x%%3==0 && x%%6!=0 = %b%n", x, x%2==0 || x%3==0 && x%6!=0);
		System.out.printf("x=%2d, (x%%2==0 || x%%3==0) && x%%6!=0 = %b%n", x, (x%2==0 || x%3==0) && x%6!=0);
		
		ch = '1';
		System.out.printf("ch='%c', '0' <= ch && ch <= '9' = %b%n", ch, '0' <= ch && ch <= '9');
		
		ch = 'a';
		System.out.printf("ch='%c', 'a' <= ch && ch <= 'z' = %b%n", ch, 'a' <= ch && ch <= 'z');
		
		ch = 'A';
		System.out.printf("ch='%c', 'A' <= ch && ch <= 'Z' = %b%n", ch, 'A' <= ch && ch <= 'Z');
		
		ch = 'q';
		System.out.printf("ch='%c', ch=='q' || ch=='Q' = %b%n", ch, ch=='q' || ch=='Q');
	}

}
/*	논리 연산자
 * 		둘 이상의 조건을 '그리고(AND)' 나, '또는(OR)' 으로 연결하여 하나의 식으로 표현
 * 		피연산자로 boolean 형 또는 boolean 형 값을 결과로 하는 조건식만 허용
 * 		'&&' 가 '||' 보다 우선순위가 높으니, 하나의 식에 같이 포함된 경우 괄호로 우선순위 명확하게 표현
 * 		- '&&'(그리고) : 두 피연산자가 모두 true 일 때 결과 true
 * 		- '||'(또는)   : 피연산자 중 어느 한 쪽만 true 이면 결과 true
 * */
