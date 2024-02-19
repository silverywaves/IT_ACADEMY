package ch6;

class BlockTest {
	static { 
		/* 클래스 초기화 블럭 */
		System.out.println("static { }");						// - 1
	}
	{ 
		/* 인스턴스 초기화 블럭 : 모든 생성자에서 공통으로 수행되야하는 코드 넣는데 사용
		 * 	코드 중복 제거 -> 신뢰성 높아지고 오류 발생가능성 줄여줌 -> 객체지향프로그래밍의 궁극적 목표 */ 
		System.out.println("{ }");								// - 3-1 / 5-1	: 인스턴스 생성시마다 수행
	}
	public BlockTest() {
		System.out.println("생성자");							// - 3-2 / 5-2
	}
	
	public static void main (String[] args) {
		System.out.println("BlockTest bt = new BlockTest();");	// - 2
		BlockTest bt = new BlockTest();							// - 3
		
		System.out.println("BlockTest br2 = new BlockTest();");	// - 4
		BlockTest bt2 = new BlockTest();						// - 5
	}
}

/*	명시적 초기화
 * 		- 변수를 선언과 동시에 초기화하는 것
 * 		- 복잡한 초기화 작업이 필요할 때는 초기화블럭 또는 생성자 사용
 * */

/*	초기화 블럭
 * 		- 인스턴스 초기화 블럭 : 클래스 내에 블럭{} 생성 후 코드 작성
 * 								 생성자와 같이 인스턴스를 생성할 때마다 수행
 * 								 생성자보다 인스턴스 초기화 블럭이 먼저 수행
 * 		- 클래스 초기화 블럭 : 인스턴스 초기화 블럭 앞에 static 
 * 							   클래스가 메모리에 처음 로딩될 떄 한번만 수행
 * */
