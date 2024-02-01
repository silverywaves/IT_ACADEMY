package ch5;

public class ArrayEx11 {

	public static void main(String[] args) {
		// 오름차순, 내림차순으로 배열 정렬 '버블 정렬(bubble sort)'
		int[] numArr = new int[10];
		
		for(int i=0; i<numArr.length; i++) {
			System.out.print(numArr[i] = (int)(Math.random()*10));
		}
		System.out.println();
		
		for(int i=0; i<numArr.length-1; i++) {
			boolean changed = false;	// 자리바꿈이 발생했는지 체크. 매 반복마다 false 로 초기화
			
			for(int j=0; j<numArr.length-1-i; j++) {	// 배열의 마지막 요소는 최대값이므로 비교할 필요 x
									// -> 비교작업(아래의 for 문)을 반복할수록 비교범위는 하나씩 줄어들어 바깥쪽 for 문의 제어변수 i 뺀 것
				if(numArr[j] > numArr[j+1]) {	// 옆의 값이 작으면 서로 바꿈
					int temp = numArr[j];
					numArr[j] = numArr[j+1];
					numArr[j+1] = temp;
					changed = true;				// 자리바꿈이 발생했으니 changed 를 true 로
				}
			}	// end of for j
			
			if (!changed) break;		// 자리바꿈이 없으면(=정렬 완료) 반복문 벗어남
			
			for(int k=0; k<numArr.length; k++) {
				System.out.print(numArr[k]);	// 정렬된 결과 출력
			}
			System.out.println();
		}	// end of for i
	}

}
