package ch4;

public class FlowEx12_for {

	public static void main(String[] args) {
		// for (초기화;조건식;증감식) { 조건식이 참일 때 수행될 문장 } <- 반복하려는 문장이 하나일 땐 {} 생략 가능
		// 초기화 : 처음 한번만 수행. 둘 이상의 변수가 필요할 떄는 콤마를 구분자로 초기화(단, 타입 일치)
		// 조건식 : 참(true)이면 반복, 거짓(false)이면 중단 후 for 문 종료 <- 무한반복 조심
		// 증감식 : 변수의 값을 증가 or 감소. 두 문장 이상은 콤마로 연결
		for(int i=1;i<=5;i++) 
			System.out.println(i);		// i 의 값 출력
		
		for(int i=1;i<=5;i++)
			System.out.print(i);		// print() 를 쓰면 가로로 출력
		
		System.out.println();
	}

}
/*	반복문은 주어진 조건을 만족하는 동안 주어진 문장들을 반복하여 수행 => 조건식 포함
 *  조건식 결과가 true 면 참, false 면 거짓
 *  for 문은 주로 반복횟수를 알고 있을 때 사용
 * 
 * 	for 문 & while 문 : 조건에 따라 한 번도 수행되지 않을 수 있음
 *  do-while 문 : 무조건 최소한 한 번은 수행될 것이 보장
 * 	
 * */
