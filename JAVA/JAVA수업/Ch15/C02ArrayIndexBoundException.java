package Ch15;

public class C02ArrayIndexBoundException {

	public static void main(String[] args) {
		
		int arr[] = {10,20,30};
		
		try {
			for(int i=0;i<4;i++) 
				System.out.println(arr[i]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException Error");
		}	// 실행을 멈추게 하지 않음. 예외가 발생했지만 멈추지 않고 HELLO WORLD 출력단계로 넘어감
		
		System.out.println("HELLO WORLD");	
	}
}
