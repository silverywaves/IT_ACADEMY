package ch6;

public class MainTest {

	public static void main(String[] args) {
		main(null);		// 재귀호출 -> 자기 자신 호출 -> 조건 X -> 무한호출
						// -> 호출스택 메모리 한계 넘어가 StackOverFlowError 발생 -> 프로그램 비정상적으로 종료
	}

}
