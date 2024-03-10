package Ch10;

import java.util.Arrays;

public class C02ArrayMain {

	public static void main(String[] args) {
		// 얕은 복사(주소복사)
		int arr1[] = {10, 20, 30};	// 힙영역에 연속적인 저장공간에 값 들어감
		int arr2[];		// 스택영역
		arr2 = arr1;	// 위치공유
		arr1[0] = 100;
		for(int val : arr2) {
			System.out.print(val + " ");
		}
		System.out.println();
		
		// 깉은 복사(값복사)
		int arr3[] = new int[3];
		for(int i=0;i<arr3.length;i++) {
			arr3[i]=arr1[i];
		}
		
		int arr4[] = Arrays.copyOf(arr1, arr1.length);
		System.out.println("arr1 : " + arr1);
		System.out.println("arr4 : " + arr4);
		
		for(int val: arr4) 
			System.out.print(val + " ");
		System.out.println();
		
	}
}
