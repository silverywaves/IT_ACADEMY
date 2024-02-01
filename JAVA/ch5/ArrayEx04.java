package ch5;

public class ArrayEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[5];
		
		// 배열 arr 에 1~5 저장
		for(int i=0; i<arr.length; i++) {
			arr[i] = i + 1;
		}
		
		System.out.println("[변경전]");
		System.out.println("arr.length:" + arr.length);
		for(int i =0; i<arr.length; i++) {
			System.out.println("arr["+ i + "]:" + arr[i]);
		}
		
		System.out.println();
		
		int[] tmp = new int[arr.length*2];		// 기존 배열보다 길이가 2배인 배열 생성
		
		// 배열 arr 에 저장된 값들을 배열 tmp 에 복사
		for(int i=0; i<arr.length; i++) {
			tmp[i] = arr[i];	// arr[i] 의 값을 tmp[i] 에 복사(저장)
		}
		
		arr = tmp;		// 참조변수 arr 이 새로운 배열을 가리키게 함
		
		System.out.println("[변경후]");
		System.out.println("arr.length:" + arr.length);
		for(int i=0; i<arr.length; i++) {
			System.out.println("arr[" + i + "]:" + arr[i]);
		}
	}

}
