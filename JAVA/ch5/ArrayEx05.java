package ch5;

public class ArrayEx05 {

	public static void main(String[] args) {
		char[] abc = {'A', 'B', 'C', 'D'};
		char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		System.out.println(abc);
		System.out.println(num);
		
		// 배열 abc 와 num 을 붙여서 하나의 배열(result) 생성
		char[] result = new char[abc.length+num.length];
//		System.arraycopy(num, 0, newNum, 0, num.length) <- num[0]에서 newNum[0]으로 num.length개의 데이터를 복사		
		System.arraycopy(abc, 0, result, 0, abc.length);
		System.arraycopy(num, 0, result, abc.length, num.length);
		System.out.println(result);
		
		// 배열 abc 를 배열 num 의 첫번째 위치부터 배열 abc 의 길이만큼 복사
		System.arraycopy(abc, 0, num, 0, abc.length);
		System.out.println(num);
		
		// 배열 num 의 인덱스6 위치에 배열 abc 요소 3개를 복사
		System.arraycopy(abc, 0, num, 6, 3);
		System.out.println(num);
	}

}
/*	for 복사	: 배열의 요소 하나하나에 접근해서 복사
 * 	System.arraycopy 복사 : 지정된 범위의 값들을 한번에 통째로 복사
 * 		=> 배열의 복사는 for 문보다 System.arraycopy() 사용하는 것이 효율적
 * */
