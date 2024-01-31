package ch4;

public class FlowEx26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int i = 0;
		
		// 1부터 몇까지 더하면 누적합계가 100을 넘지 않는 제일 큰 수가 되는지 확인
		// i 를 1씩 증가시켜서 sum 에 계속 더함 -> sum 의 값이 100보다 작거나 같은지 확인
		while((sum += ++i) <= 100) {		
			System.out.printf("%d - %d%n", i, sum);
		}
	}

}
