package Ch10;

// 1차원 배열 : 해당 자료형을 요소단위로 정함
// int arr[] = new int[5] => 5개의 공간 하나하나당 int

// 2차원 배열 : 1차원 배열을 요소단위로 정함
// int arr[][] = new int[2][3]		// [2] : 행, [3] : 열
// 2행 3열 	arr[0][0]	arr[0][1]	arr[0][2]
//			arr[1][0]	arr[1][1]	arr[1][2]
// => 실제로는 연속된 한줄로 적재되어있긴함. arr[0][0]	arr[0][1]	arr[0][2]	arr[1][0]	arr[1][1]	arr[1][2]

public class C03MultiArrayMain {

	public static void main(String[] args) {
		int arr[][] = {
				{10, 20, 30},
				{40, 50, 60, 65, 57},
				{70, 80, 90, 95, 97, 98, 99},
				{100, 110, 120, 22},
		};
		System.out.println("행의 길이 : " + arr.length);	
		System.out.println("[0]행의 열의 길이 : " + arr[0].length);
		System.out.println("[1]행의 열의 길이 : " + arr[1].length);
		System.out.println("[2]행의 열의 길이 : " + arr[2].length);
		System.out.println("[3]행의 열의 길이 : " + arr[3].length);
	}
}
