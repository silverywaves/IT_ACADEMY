package ch2;

public class CastingEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 10;
		byte b = (byte)i;
		System.out.printf("[int -> byte] i=%d -> b=%d%n", i, b);
		
		i = 300;
		b = (byte)i;
		System.out.printf("[int -> byte] i=%d -> b=%d%n", i, b);
		
		b = 10;
		i = (int)b;
		System.out.printf("[byte -> int] b=%d -> i=%d%n", b, i);
		
		b = -2;
		i = (int)b;
		System.out.printf("[byte -> int] b=%d -> i=%d%n", b, i);
		
		System.out.println("i="+Integer.toBinaryString(i));	// 변수 i 의 값인 -2가 2진수로 출력
	}

}
/*	정수형간의 형변환
 *		큰 타입 -> 작은 타입 : 크기의 차이만큼 잘려나감
 *								값 손실(loss of data) 발생
 *		작은 타입 -> 큰 타입 : 원래의 값을 채우고 남은 빈 공간은 0 또는 1로 채워짐
 *								양수 => 0, 음수 => 1 	// 부호 유지를 위함
 * */
