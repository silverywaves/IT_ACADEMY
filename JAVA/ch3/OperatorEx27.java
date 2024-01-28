package ch3;

public class OperatorEx27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean b = true;
		char ch = 'C';
		
		System.out.printf("b=%b%n", b);
		System.out.printf("!b=%b%n", !b);
		System.out.printf("!!b=%b%n", !!b);
		System.out.printf("!!!b=%b%n", !!!b);
		System.out.println();
		
		System.out.printf("ch=%c%n", ch);
		System.out.printf("ch<'a' || ch>'z'=%b%n", ch<'a' || ch>'z');
		System.out.printf("!('a'<=ch && ch<='z')=%b%n", !('a'<=ch && ch<='z'));
		System.out.printf(" 'a'<=ch && ch<='z' =%b%n", 'a'<=ch && ch<='z');
	}	// main 끝

}
/*		논리 부정 연산자 !
 * 			피연산자가 true 면 false 를, 피연산자가 false 면 true 반환
 * 
 * 			System.out.printf("!!b=%b%n", !!b);
 * 			-> !!true	가까운 연산자가 먼저 연산
 * 			-> !false	!true 의 결과는 false
 * 			-> true		!false 의 결과는 true
 * */
