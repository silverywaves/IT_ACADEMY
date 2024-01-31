package ch4;

public class FlowEx24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 11;
		
		System.out.println("카운트 다운을 시작합니다.");
		
		while(i--!=0) {
			System.out.println(i);
			for(int j=0; j<2_000_000_000; j++) {
				;	// 빈문장. 그저 조건식과 증감식을 2,000,000,000번 반복
				}
		}
		System.out.println("Game Over");
	}

}
/*	for(i=1; i<=10; i++);			// 빈 문장 ; 을 10번 반복
 * 	{
 * 		System.out.println("i="+i);	// i 의 값이 11일 때, 거짓이 되어 반복 종료 => i = 11 출력
 *  }
 * */
