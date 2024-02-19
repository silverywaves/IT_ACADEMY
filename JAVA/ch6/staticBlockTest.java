package ch6;

class staticBlockTest {
	static int[] arr = new int[10];
	
	static {
		for(int i=0; i<arr.length; i++) {
			// 1과 10사이의 임의 값을 배열 arr 에 저장
			arr[i] = (int)(Math.random()*10)+1;
		}
	}	// 명시적 초기화만으로는 작업 X -> 추가 클래스 초기화 블럭 사용
	
	public static void main(String[] args) {
		for(int i=0; i<arr.length; i++) {
			System.out.println("arr[" + i + "] : " + arr[i]);
		}
	}
}
