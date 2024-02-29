package Ch02;

public class C01진수 {
// 진수 : 앞으로 나가는 수
	public static void main(String[] args) {
// 8진수(0~7) 10진수(0~9) 16진수(0~F) 2진수(0~1)
// 1				1		 	1		1
// 2				2			2		10
// 3				3			3		11
// 4				4			4		100
// 5				5			5		101
// 6				6			6		110
// 7				7			7		111
// 10			8			8		1000
// 11			9			9		1001
// 12			10			A		1010
// 13			11			B		1011
// 14			12			C		1100
// 15			13			D		1101
// 16			14			E		1110
// 16			15			F		1111

//		------------------------------
//		1bit : 2^1 = 2(0~1)
//		2bit : 2^2 = 4(0~3)
//		3bit : 2^3 = 8(0~7)
//		4bit : 2^4 = 16(0~15)
//		5bit : 2^5 = 32(0~31)
//		6bit : 2^6 = 64(0~63)
//		7bit : 2^7 = 128(0~127)
//		8bit : 2^8 = 256(0~255)
//		9bit : 2^9 = 512(0~511)
//		10bit: 2^19 =1024(0~1023)
//		--------------------------------
//		1	1	1	1	1	1	1	1
//		*	*	*	*	*	*	*	*
//		2^7	2^6	2^5	2^4	2^3	2^2	2^1	2^0
//
//		128	64	32	16	8	4	2	1
		
		// 10000000 = 128 
		// 01000000 = 64
		// 00100000 = 32
		// 00010000 = 16
		// 00001000 = 8
		// 00000100 = 4
		// 00000010 = 2
		// 00000001 = 1

		//문제
		// 2진수 - > 10진수
		// 10101100 = 2^7 + 2^5 + 2^3 + 2^2 = 128 + 32 + 8 + 4 = 172 
		// 10011010 = 2^7 + 2^4 + 2^3 + 2^1 = 128 + 16 + 8 + 2 = 154
		// 01101001 = 2^6 + 2^5 + 2^3 + 1^0 = 64 + 32 + 8 + 1 = 105
		// 10010010 = 2^7 + 2^4 + 2^1 = 128 + 16 + 2 = 146

		// 10진수 -> 2진수 : 2^7 부터 아래로 내려가면서 나눠주면 쉽게 계산 가능
		// 192 -> 11000000	
		// 224 -> 11100000
		// 252 -> 11111100
		// 12 -> 00001100
		// 15 -> 00001111

		// 코드 이쁘게 정리하기 : ctrl + shift + f
		System.out.printf("10진수 : %d\n", 0b00001111); // 데이터값 자료형 / 2진수 (0b : 2진수를 의미하는 접두사)
		
		System.out.println();
		
		System.out.printf("10진수 : %d\n", 173); // 10진수
		System.out.printf("10진수 : %d\n", 0255); // 8진수 (0 :8진수를 의미하는 접두사)
		System.out.printf("10진수 : %d\n", 0xAD); // 16진수(0x:16진수를 의미하는 접두사)

		System.out.println();
		
		System.out.printf("8진수 : %o\n", 173); // 10진수
		System.out.printf("8진수 : %o\n", 0255); // 8진수 (0 :8진수를 의미하는 접두사)
		System.out.printf("8진수 : %o\n", 0xAD); // 16진수(0x:16진수를 의미하는 접두사)
		
		System.out.println();

		System.out.printf("16진수 : %X\n", 173); // 10진수
		System.out.printf("16진수 : %X\n", 0255); // 8진수 (0 :8진수를 의미하는 접두사)
		System.out.printf("16진수 : %X\n", 0xAD); // 16진수(0x:16진수를 의미하는 접두사)

	}

}


