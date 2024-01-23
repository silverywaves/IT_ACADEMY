package ch2;

public class VarEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10, y = 20;
		int tmp = 0;
		
		System.out.println("x:"+ x + " Y:" + y);		// x:10 Y:20
		
		tmp = x;
		x = y;
		y = tmp;
		
		System.out.println("x:"+ x + " Y:" + y);		// x:20 Y:10

	}

}

/*
 *	두 변수의 값 교환
 *	=> 변수를 하나 더 선언하여 임시 저장소로 사용
 *
 *	덧셈연산자(+) : 1. 두 값을 더함
 *					2. 문자열(큰따옴표로 묶은 연속된 문자)과 숫자를 하나로 결합
 */