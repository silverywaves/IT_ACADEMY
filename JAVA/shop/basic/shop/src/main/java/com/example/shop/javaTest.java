package com.example.shop;

public class javaTest {
    public static void main(String[] args) {
//		// 변수 : 문자나 숫자 자료를 잠깐 저장하는 장소
//		// 		생성 방법 : 자료형 변수명 = 변수에넣을값;
//		// 자료형 : 변수에 들어갈 자료의 타입
//		// 문자(String), 정수(int), 20억 이상의 큰 정수(long), 소수(float), 오차가 더 적은 소수(double), true/false(boolean)
//		String name = "조은파";	// 문자자료는 큰따옴표 사용
//		int age = 32;			// 자료형대신 var 키워드 사용 가능
//		final int bookCode = 0;		// final : 상수 설정(변수에 들어있는 값 변경 불가)
////		bookCode = 20;				// Error
//		System.out.println(name);
//		System.out.println(age);
//
//		// if 조건문
//		// if(조건){
//		// 		조건이 참일 때 실행할 코드
//		// }
//
//		// for 반복문
//		// for(int i=0; i<3; i++){
//		//		복붙할 코드
//		// }
//
//		// 함수 : 코드 재사용시 class 안에 함수를 만들어 사용
//		// 반환타입 함수이름(){}
//		// 함수 안에 return 있을 경우 return 하는 자료가 무슨타입인지 기재
//		// return 없으면 void
//
//		// class 안에 있는 변수함수 쓰려면? => new 클래스()로 복사해서 써야함
//		// 클래스 복사시 타입을 정확히 넣고싶으면 타입자리에 클래스명 넣으면 됨(클래스도 일종의 자료형 역할을 할 수 있기 때문)
//		Test test = new Test();
//		// new 클래스이름() : class에 있던 변수와 함수를 복사해서 이 자리에 남겨달라는 뜻
//		// => test : class의 복사본 = Object
//		System.out.println(test.name);	// . 으로 변수, 함수 꺼내쓸 수 있음
//		test.hello();

//		new Friend("kim");	// = blank 자리에 "kim" 넣어서 object 뽑아주세요
//		new Friend("park");	// = blank 자리에 "park" 넣어서 object 뽑아주세요
//		var test = new Friend("park");
//		System.out.println(test.name);
    }
}

// class : 변수, 함수 보관함
// class 쓰는 이유?
// 1. java 는 클래스 강요함
// 2. class 사용시 관련있는 변수, 함수들 한 곳에 정리가능
// 3. 중요한 변수, 함수 원본 데이터를 안전하게 보관 가능
// [참고1] new로 복사 안되는 변수, 함수 뿐만아니라 복사안해도 쓸 수 있는 변수, 함수 제작 가능 (static, private, protected 등)
// [참고2] object = 인스턴스
//		  클래스 안의 변수 = field = attribute
//		  클래스 안의 함수 = method
//class Test{
//	String name = "Kim";
//	void hello(){		// return 없으니 void
//		System.out.println("안녕");
//	}
//}

// constructor
// 친구1의 이름과 나이를 변수로 저장
//class Friend{
//	String name = "kim";
//	int age = 20;
//	Friend(String blank){	// Constructor - new Friend() 할 때 자동 실행 => this 로 변수의 초기값 설정 가능
//		// this.name="kim";
//		// => this : 새로 생성될 object / .name : 그 안의 name 변수에 / "kim" 넣어주라는 뜻
//		// 사용이유 : 잘 쓰면 매번 다른 변수값으로 object 뽑을 수 있음
//		this.name = blank;
//	}
//}
// 친구2의 이름과 나이를 변수로 저장
//class Friend2{
//	String name = "park";
//	int age = 20;
//}
//// => 비슷한 class 는 여러개 만들 필요 없음

