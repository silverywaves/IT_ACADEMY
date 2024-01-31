package ch4;

public class FlowEx30_break {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 숫자를 1부터 계속 더해나가서 몇까지 더하면 합이 100을 넘는지 확인
		int sum = 0;
		int i = 0;
		
		while(true) {
			if(sum > 100)	// sum 의 값이 100을 넘으로 if 문의 조건식이 참이므로 break 문 수행 -> 반복문 종료
				break;
			++i;			// i 의 값을 1부터 1씩 계속 증가시키며 
			sum += i;		// 더해서 sum 에 저장
		}	// end of while
		System.out.println("i=" + i);
		System.out.println("sum=" + sum);
	}

}
