package ch6;

class ReturnTest{
	void printGugudan(int dan) {
	for(int i=1; i<=9; i++) {
		System.out.printf("%d * %d = %d%n", dan, i, dan *i);
	}
	return;		// 반환타입이 void 이므로 생략 가능. 컴파일러가 자동 추가
	}
	
	int multiply(int x, int y) {
		int result = x * y;
		
		return result;	// 반환타입이 void 가 아니라 생략 불가
	}
	
	int max(int a, int b) {
		if(a > b)
			return a;		// 조건식이 참일때만 실행	- 이 문장만 있으면 에러
		else				// if 문 조건식의 결과에 따라 return 문 실행 안될 수 있으므로 else 블럭에 return 추가 필요
			return b;		// 조건식이 거짓일 때 실행
	}
	
	float divide(int c, int d) {
		// 매개변수 유효성 검사 => 작업을 하기 전에 나누는 수(d)가 0인지 확인
		if(d==0) {
			System.out.println("0으로 나눌 수 없습니다.");
			return 0;	// 매개변수가 유효하지 않으므로 메서드 종료 <- 안하면 비정상적 종료 발생
		}
		return c / (float)d;
	}
}

/*	- return
 * 		- 현재 실행중인 메서드를 중료하고 호출한 메서드로 되돌아감
 * 		- 반환값 유무에 관계 없이 모든 메서드에는 적어도 하나의 return 문이 있어야 함
 * 	
 * 
 * 	- 반환값(return value)
 * 		- 주로 변수이나 항상 변수인 것은 아님 (ex. 수식 게산 결과 등)
 * */
