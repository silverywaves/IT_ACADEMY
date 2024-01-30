package ch4;

public class FlowEx14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(int i=1, j=10; i<=10; i++, j--)
//			System.out.printf("%d \t %d%n", i, j);		i 와 j 를 더한 값이 11로 일정함. 더 간단히 작성 가능
		
		for(int i=1; i<=10; i++) {
			System.out.printf("%d \t %d%n", i, 11-i);	// 변수의 수가 적은 것이 더 효율적
		}
	}

}
