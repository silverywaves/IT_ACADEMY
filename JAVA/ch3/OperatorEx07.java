package ch3;

public class OperatorEx07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte a = 10;
		byte b = 30;
		byte c = (byte)(a * b);
		System.out.println(c);		// 44 출력
	}

}
/*	10 * 30 = 300 이지만, 큰 자료형에서 작은 자료형으로 변환하면 데이터 손실 발생 -> 값 바뀜
 * */
