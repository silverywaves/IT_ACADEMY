package ch4;

public class FlowEx21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				if(i==j) {			// 2중 for 문 안에 if 문 추가하여 정렬하기
					System.out.printf("[%d, %d]", i, j);	// i==j 를 만족하는 경우에만 값 출력
				} else {
					System.out.printf("%5C", ' ');			// 나머지 공백 출력
				}
			}
			System.out.println();
		}
	}

}
