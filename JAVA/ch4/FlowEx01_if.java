package ch4;

public class FlowEx01_if {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0;
		System.out.printf("x=%d 일 떄, 참인 것은%n", x);
		
		// if (조건식) { 조건식이 참(true)일 때 수행될 문장 } => 결과는 true or false
		if(x==0) System.out.println("x==0");
		if(x!=0) System.out.println("x!=0");
		if(!(x==0)) System.out.println("!(x==0)");
		if(!(x!=0)) System.out.println("!(x!=0)");
		
		x = 1;
		System.out.printf("x=%d 일 때, 참인 것은%n", x);
		
		if(x==0) System.out.println("x==0");
		if(x!=0) System.out.println("x!=0");
		if(!(x==0)) System.out.println("!(x==0)");
		if(!(x!=0)) System.out.println("!(x!=0)");
	}

}
/*	제어문(control statement)
 * 		프로그램의 흐름(flow)을 바꾸는 역할을 하는 문장
 * 		- 조건문 : 조건에 따라 다른 문장이 수행 (if / switch)
 * 		- 반복문 : 특정 문장들을 반복해서 수행	(for / while / do-while)
 * */
