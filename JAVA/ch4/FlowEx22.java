package ch4;

public class FlowEx22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;
//		배열의 모든 요소를 출력하는 for 문		
		for(int i=0; i<arr.length; i++)
			System.out.printf("%d ", arr[i]);
		System.out.println();
		
//		for (타입변수형 : 배열 또는 컬렉션) { 반복할 문장-변수를 사용해서 코드 작성 }
		for(int tmp : arr) {
			System.out.printf("%d ", tmp);
			sum += tmp;
		}						// 향상된 for 문의 제약 : 읽어오는 용도로만 사용 가능
		System.out.println();
		System.out.println("sum=" + sum);
	}

}
