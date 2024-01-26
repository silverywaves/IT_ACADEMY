package ch3;

public class OperatorEx06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte a = 10;
		byte b = 20;
		//byte c = a + b;		// 컴파일 에러 : 명시적으로 형변환 필요	[Type mismatch: cannot convert from int to byte]
							// byte c = (byte)(a+b);
		//System.out.println(c);
	}

}
/*	a, b 모두 int 형보다 작은 byte 형이기 때문에 연산자 '+'는 두 피연산자들의 자료형을 int 형으로 변환 후 연산 수행
 *		=> a + b = 4 byte (int 형)
 * 		=> 큰 자료형의 값을 작은 자료형의 변수에 저장하려면 명시적으로 형변환 연산자 필요
 * */
