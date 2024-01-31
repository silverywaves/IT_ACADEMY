package ch4;

public class FlowEx29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 3,6,9 게임 출력
		for(int i=1; i<=100; i++) {
			System.out.printf("i=%d ", i);
			
			int tmp = i;	// i 의 값을 다른 변수에 저장 <- 변수 i 는 for 문의 제어에 사용되는 변수이기 때문
			
			do {
				// tmp 끝자리가 3의 배수인지 확인(0 제외)
				if(tmp % 10 % 3 == 0 && tmp % 10 !=0)	
					System.out.print("짝");
				// [tmp /= 10] 은 [tmp = tmp / 10] 과 동일
			} while((tmp /= 10) != 0);
			
			System.out.println();
		}
	}

}
