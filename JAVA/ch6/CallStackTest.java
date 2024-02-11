package ch6;

public class CallStackTest {

	public static void main(String[] args) {	// main 메서드 호출, 프로그램 시작
		firstMethod();	// firstMethod 호출, main 대기 (static 메서드는 객체 생성없이 호출 가능)
	}
	static void firstMethod() {
		secondMethod();	// secondMethod 호출, firstMethod 대기(sM 수행 마쳐야 fM 나머지 문장 수행 가능)
	}
	static void secondMethod() {
		System.out.println("secondMethod()");	// println 호출 -> sM 출력 -> println 수행완료, 호출스택에서 사라짐 -> sM 수행재개
	}											// sM 수행코드X 종료 -> fM 수행재개 -> fM 수행코드X 종료 -> main 수행재개
												// main 수행코드x 종료 -> 호출스택 완전히 비워지고 프로그램 종료
}

/*	< JVM 의 메모리 구조 >
 * 	- 메서드 영역(method area)
 * 		- 프로그램 실행 중 어떤 클래스가 사용되면, 해당 클래스파일(*.class)을 읽어 분석 후 정보 저장
 * 		- 클레스 데이터 & 클래스변수(class variable, cv)
 * 
 * 	- 힙(heap)
 *		- 인스턴스가 생성되는 공간
 *		- 인스턴스 변수(instance variable, iv)
 *
 * 	- 호출스택(call stack / execution stack)
 * 		- 메서드의 작업에 필요한 메모리 공간 제공
 * 		- 메서드 호출시, 메모리 할당 -> 매개변수 포함 지역변수(local variable, lv)들과 연산의 중간결과 저장
 * 			-> 작업 종료시 메모리공간 반환, 스택에서 제거
 * 		- 아래에 있는 메서드가 바로 위의 메서드를 호출한 메서드
 * 		- 호출스택의 제일 상위에 위치하는 메서드가 현재 실행중인 메서드, 나머지는 대기상태
 * 
 * 	=> 반환타입(return type)이 있는 메서드는 종료되면서 결과값을 자신을 호출한 메서드(caller)에게 반환
 * 		대기상태에 있던 호출한 메서드(caller)는 넘겨받은 반환값으로 수행 계속 진행 
 * */
