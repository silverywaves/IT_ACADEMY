package ch2;

public class CastingEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f = 1234;		// 형변환 생략. float f = (float)1234; 와 같음
		// byte b = 1000;		// incompatible types: possible lossy conversion from int to byte
								// 에러 : byte 범위(-128~127) 넘는 값 지정 -> 값손실 발생
		char ch = (char)1000;	// 명시적 형변환 -> 실수가 아닌 의도적으로 해석 -> 에러 x
	}

}
/*	자동 형변환
 * 		편의상의 이유로 형변환 생략 가능 => 컴파일러가 생략된 형변환 자동으로 추가
 * 		단, 변수가 저장할 수 있는 값의 범위보다 더 큰 값을 저장하려는 경우 자동형변환 실행 x
 * 
 * 	산술 변환
 * 		연산과정에서 자동적으로 발생하는 형변환
 * 		서로 다른 두 타입간의 덧셈 -> 두 타입 중 표현범위가 더 넓은 타입으로 형변환
 * 
 * 	자동 형변환 규칙
 * 		기존의 값을 최대한 보존할 수 있는 타입으로 자동 형변환
 * 		= 값의 범위가 작은 타입->큰 타입 형변환은 생략 가능
 * 
 * 		byte -> short/char -> int -> long -> float -> double
 * 		화살표 방향으로의 변환은 형변환 연산자 사용x. 자동 형변환 가능
 * 		화살표 반대 방향으로의 변환은 형변환 연산자 사용.
 * 		실수형이 정수형보다 큰 표현 범위를 갖기 때문에 int 와 long 보다 float 가 오른쪽에 위치
 * 		short 와 char 는 크기는 같지만 범위가 달라서 값 손실 가능성有 -> 자동형변환 x
 * */
