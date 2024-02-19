package ch6;

/* 클래스이름(타입변수명, 타입변수명, ...){
 * 	// 인스턴스 생성시 수행될 코드,
 * 	// 주로 인스턴스 변수의 초기화 코드 기재
 * }
 * 
 * 	클래스에 생성자를 정의하지 않고도 인스턴스를 생성할 수 있었던 이유?
 * 	=> 컴파일러가 제공하는 '기본 생성자(default constructor)' 자동 추가하여 컴파일
 * 	=> 클래스 내 생성자가 하나도 없을 때만 적용
 * */

class Data1{		// 정의되어있는 생성자 X => 기본생성자 추가
	int value;
}

class Data2 {
	int value;
	
	Data2(int x){	// 매개변수가 있는 생성자
		value = x;
	}
}

class ConstructorTest{
	public static void main(String[] args) {
		Data1 d1 = new Data1();
		// 1. 연산자 new 에 의해서 메모리(heap)에 Data1 클래스의 인스턴스 생성
		// 2. 생성자 Data1() 호출되어 수행됨
		// 3. 연산자 new 의 결과로, 생성된 Data1 인스턴스의 주소가 반환되어 참조변수 d1 에 저장됨
		
//		Data2 d2 = new Data2();		// Error : The constructor Data2() is undefined (Data2 에서 Data2() 생성자 찾을 수 없다는 내용-> 정의되어있지 않기 때문)
		Data2 d2 = new Data2(10);	// Error 해결 : 1. 인스턴스 생성시 생성자 Data2(int x) 사용
												 // 2. 클래스 Data2 에 생성자 Data2() 추가 정의
	}
}

/*	생성자(Constructor)
 * 		- 인스턴스가 생성될 때 호출되는 '인스턴스 초기화 메서드'
 * 		- 인스턴스 변수 초기화 작업에 주로 사용
 * 		- 인스턴스 생성시에 실행되어야할 작업을 위해서 사용
 * 		- 생성자 이름 = 클래스 이름
 *      - 리턴값X
 *      - 오버로딩 가능 -> 하나의 클래스에 여러개의 생성자 존재 가능
 *      - 생성자가 인스턴스 생성하는 것 아님 <- 연산자 new 가 인스턴스를 생성. 이름때문에 오해하지 말 것
 * */