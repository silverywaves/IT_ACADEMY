package Ch02;

public class C04자료형 {

	public static void main(String[] args) {
		 
		//--------------------
		//정수 int - 4byte 정수 부호 o
		//--------------------
		int n1 = 0b10101101;	//2진수값
		int n2 = 173;			//10진정수값
		int n3 = 0255;			//8진수
		int n4 = 0xad;			//16진수
		System.out.printf("%d %d %d %d\n", n1,n2,n3,n4);
//		원시타입은 공간제약, 데이터타입 o, 
//		참조타입은 객체지향일 경우 공간제약X(크기 가늠할 수 없으므로)  <=> c 에서는 제약 o

		System.out.println();
		
		
		
		//--------------------
		//정수 byte - 1byte 정수 부호 o
		//--------------------
		byte n5 = (byte)-129;		// => 11111111 
		byte n6 = -30;
		byte n7 = 30;
		byte n8 = 127;
//		byte n9 = 129;		// Error! 왜?	
		// => Type mismatch: cannot convert from int to byte
		// => int 형으로 뜸 => byte 최대범위인 128이 넘어갔기 때문!
		
		System.out.printf("%d\n", n5);	// 127
		System.out.printf("%d\n", n6);	// -30
		System.out.printf("%d\n", n7);	// 30
		System.out.printf("%d\n", n8);	// 127
//		System.out.printf("%d\n", n9);	// int : 129 / byte : -127
		System.out.println();
		System.out.println(0b10101101); // 가장 앞자리가 1인데 음수가 아닌 이유?! => 기본자료형이 int! 범위 넉넉
		System.out.println(Integer.toBinaryString(-129));	// toBinaryString : 2진수 문자열로 변환
		System.out.println();
		
		
		
		//--------------------
		//정수 short-2byte정수 부호o | char-2byte정수 부호x(양수만)
		//--------------------
		char n10 = 65535;  //(0~2^16-1)	(0~65535)
		short n11 = 32767; //(-2^15 ~ +2^15-1)(-32768 ~ + 32767)
		
		char n12 = 60000;
//		short n13 = n12; //문제발생... 왜?? => 범위를 벗어남
		// Type mismatch: cannot convert from char to short
	
//		System.out.printf("%d\n",n13);	// short : -5536 / char : n12에 n12를 대입 => Error
		System.out.println();
		
		
		
		//--------------------
		//정수 long-8byte 정수 부호o
		//--------------------
		long n13 = 10;
		long n14 = 20;	//L,l (리터럴접미사) : long 자료형 사용하여 값 저장 
		
//		long n15 = 10000000000; 	// The literal 10000000000 of type int is out of range 
		long n16 = 10000000000L;
		
		System.out.println(n13);		
		System.out.println(n14);
//		System.out.println(n15);	// 접미사 L 을 붙이면 10000000000
		System.out.println(n16);
		System.out.println();		
		
		
		//--------------------
		//실수
		//--------------------
		//유리수와 무리수의 통칭
		//소숫점이하값을 가지는 수 123.456
		//float : 4byte 실수(6-9자리)
		//doblue : 8byte 실수(15-18자리),기본자료형
		
		//정밀도 확인(double>float)
		float n17 = 0.123456789123456789F; //f,F:float형 접미사
					// 0.12345679
		double n18 = 0.123456789123456789;
					// 0.12345678912345678
		System.out.println(n17);
		System.out.println(n18);
		System.out.println();		
		
		
		
		//--------------------
		//단일문자 char 2byte 정수
		//--------------------
		char ch1 = 'a';
		System.out.println(ch1);		// a
		System.out.println((int)ch1);	// 97 = 011000001
//	
//		
		char ch2 = 98;
		System.out.println(ch2);		// b	
		System.out.println((int)ch2);	// 98 = 011000010
//		
		char ch3 = 'b'+1;
		System.out.println(ch3);		// c
		System.out.println((int)ch3); 	// 99 = 011000011
//		
		byte ch4 = 'c'+2;			
		System.out.println((char)ch4);	// e
		System.out.println(ch4); 		// 101 = 011000011
		System.out.println();	
		
		char ch5  = 0xac00;				// ac00 : 가
//		char ch6 = 44032;				// 유니코드한글시작
//		
		System.out.println(ch5);		// 가
//		System.out.println(ch6);		// 가
		System.out.println((char)(0b1010110000000000+1));	// 각
		System.out.println();
		 
		char ch6 = 0xac00+1;
		System.out.printf("%c %c\n", ch5,ch6);	// 가 각
		System.out.println();		
		
//		// \\u :유니코드값 이스케이프문자
		// https://www.compart.com/en/unicode/scripts/Hang
		// https://ko.wikipedia.org/wiki/%EC%9C%A0%EB%8B%88%EC%BD%94%EB%93%9C_0000~0FFF
		System.out.printf("%c\n", '\uACa1');	// ACa1 : 겡
		
		System.out.printf("TEST : %c\n", '\uabcd');	// abcd : 기호
		
		
		char n = 10;
		System.out.printf("HELLO %c WORLD", n);
		System.out.println('\n');
		
		
		//--------------------
		//문자열 : String (클래스자료형)
		//--------------------
		
		//기본자료형(원시타입)
//		byte n1;
//		short n2;
//		double n3;
//		long n4;
		
		//클래스자료형
		//클래스자료형으로 만든변수는 '참조변수'라고 하고
		//참조변수는 데이터가 저장된 위치정보(메모리주소값)이 저장된다.
//		int n1 = 10;
//		byte n2 = 20;
//		char n3 = 40;
		
		String name = "홍길동";
		String job = "프로그래머";
		System.out.println(name);
		System.out.println(job);
		System.out.println();
		
		//--------------------
		//boolean : 논리형(true/false 저장)
		//--------------------
		
		boolean flag = (10>11);
		if(flag)
		{
			System.out.println("참인경우 실행");
		}
		else 
		{
			System.out.println("거짓인경우 실행");
		}
		
	
		
		
		
	}	

}
