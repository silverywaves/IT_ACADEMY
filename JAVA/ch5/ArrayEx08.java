package ch5;

public class ArrayEx08 {

	public static void main(String[] args) {
		// 배열의 요소의 순서를 반복해서 바꿈(shuffle) - 카드섞기, 로또번호생성 등
		int[] numArr = new int[10];
		
		for(int i=0; i<numArr.length; i++) {
			numArr[i] = i;	// 배열을 0~9의 숫자로 초기화
			System.out.print(numArr[i]);
		}
		System.out.println();
		
		for(int i=0; i<numArr.length; i++) {	// 값 교환을 numArr.length 번 반복
			int n = (int)(Math.random()*10);	// 0~9 중의 한 값을 임의로 얻음
			int tmp = numArr[0];				// tmp : 두 변수에 저장된 값을 서로 바꾸려면 별도의 저장공간이 하나 더 필요하여 생성함
			numArr[0] = numArr[n];
			numArr[n] = tmp;					// numArr[0]과 numArr[n]의 값을 서로 바꿈
		}
		
		for(int i=0; i<numArr.length; i++)
			System.out.print(numArr[i]);
	}

}

