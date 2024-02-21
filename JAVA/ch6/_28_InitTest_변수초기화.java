package ch6;

public class _28_InitTest_변수초기화 {
	int x;				// 인스턴스변수 -> 초기화해주지 않아도 자동으로 int 형 기본값 0으로 초기화
	int y = x;			// 인스턴스변수 -> 0 저장

//	void method1() {
//		int i;			// 지역변수 -> 자동 초기화X
//		int j=i;		// error : The local variable i may not have been initialized(지역변수를 초기화하지 않고 사용)
//	}

	/* 변수 초기화 예 */
	
//	int i = 10;			// 정상 : int 형 변수 i 를 선언하고 10으로 초기화
//	int j = 10;			// 정상 : int 형 변수 j 를 선언하고 10으로 초기화
	
//	int i = 10, j = 0;			// 정상 : 같은 타입 변수는 콤마를 사용해 함께 선언 및 초기화 가능
	
//	int i = 10, long j =  0;	// error : 타입이 다른 변수는 함께 선언 및 초기화 불가
	
//	int i = 10;			// 정상 : int 형 변수 i 를 선언하고 10으로 초기화
//	int j = i;			// 정상 : 변수 j 는 i 의 값인 10으로 초기화
	
//	int j = i;			// error : Cannot reference a field before it is defined
//	int i = 10;			//         변수 i 가 선언되기 전에 i 를 사용할 수 없음
	
}
/* 변수의 초기화
 *		- 변수를 선언하고 처음으로 값을 저장하는 것
 *		- 초기화는 선택적이지만 가능하면 선언과 동시에 적절한 값으로 초기화 하는것이 바람직함(클래스변수&인스턴스변수)
 *		- 단, 지역변수는 사용하기 전에 반드시 초기화해야함
 * */

/*	멤버변수의 초기화 방법
 * 		- 명시적 초기화(explicit initialization)
 * 		- 생성자(constructor)
 * 		- 초기화 블럭(initialization block)
 * 			- 인스턴스 초기화 블럭 : 인스턴스변수를 초기화하는데 사용
 * 			- 클래스 초기화 블럭 : 클래스변수를 초기화하는데 사용
 * */
