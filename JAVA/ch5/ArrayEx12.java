package ch5;

public class ArrayEx12 {

	public static void main(String[] args) {
		// 배열에 어떤 값이 몇 개 저장되어 있는지 확인 (빈도수 구하기)
		int[] numArr = new int[10];
		int[] counter = new int[10];
		
		for(int i=0; i<numArr.length; i++) {
			numArr[i] = (int)(Math.random()*10);	// 0~9 의 임의의 수 배열에 저장
			System.out.print(numArr[i]);
		}
		System.out.println();
		
		for(int i=0; i<numArr.length; i++) {
			counter[numArr[i]]++;				// i 의 값이 0인 경우를 가정
//			counter[numArr[0]]++;				// numArr[0]의 값은 4
//			counter[4]++;						// counter[4]의 값을 1 증가시킴
		}
		
		for(int i=0; i<numArr.length; i++) {
			System.out.println(i + "의 개수 :" + counter[i]);
		}
	}

}
