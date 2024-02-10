package ch6;

public class Method {

	public static void main(String[] args) {
		int[] numArr = new int[10];
		
		for(int i=0; i<10; i++) {
			numArr[i] = (int)(Math.random()*10);
		}
//		for(int i=0; i<10; i++) {					// 중복1
//			System.out.printf("%d", numArr[i]);
//		}
//		System.out.println();
//	}
//		for(int i=0; i<10; i++) {					// 중복2
//			System.out.printf("%d", numArr[i]);
//		}
//		System.out.println();
		
		printArr(numArr);	// 배열 출력	<<= 반복되는 코드 대신 메서드 호출
		printArr(numArr);	// 배열 출력
	}

	static void printArr(int[] numArr) {		// 중복문장 메서드 생성
		for(int i=0; i<10; i++) {
			System.out.printf("%d", numArr[i]);
		}
		System.out.println();
	}
}
/*	method(메서드) : 특정 작업을 수행하는 일련의 문장들을 하나로 묶은 것
 * 					: 입력값 또는 출력값(결과값)이 없을 수도 있음(둘다 없을 수도)
 * 					: 메서드를 정의한다 = 선언부와 구현부 작성
 * 
 * 	- 사용 이유
 * 	1. 높은 재사용성(reusability)
 * 		- 한번 만들어놓은 메서드는 몇번이고 호출 가능 & 다른 프로그램에서도 사용 가능
 * 
 * 	2. 중복된 코드 제거
 * 		- 반복 문장들을 묶어 하나의 메서드로 작성해놓으면 소스 코드 길이 짧아짐
 * 			-> 변경사항 발생시 수정할 코드 양 줄어들어 오류 발생가능성 낮아짐
 * 
 * 	3. 프로그램 구조화
 * 		- 문장들을 작업단위로 나눠 여러개의 메서드에 담아 프로그램 구조 단순화
 * 			-> 프로그램 문제 발생시, 쉽게 찾아 해결 가능
 * 
 * 	- 구조
 * 	1. 선언부(header)
 * 		- '반환타입-출력' '메서드 이름' ('매개변수선언-입력') : 작업 수행을 위해 어떤 값이 필요하고 어떤 타입값을 결과로 반환하는지 정보 제공
 * 		-  변경사항 발생하지 않도록 작성(메서드가 호출되는 모든 곳 같이 변경해야함)
 * 
 * 	2. 구현부(body)
 * 		- 메서드 선언부 다음에 오는 괄호{메서드 호출시 수행될 문장}
 * 		- 반환타입이 'void' 아닌 이상 'return 반환값' 필수	<= 반환타입 일치 or 자동형변환 가능한 것. 단 하나의 값만 출력
 * */	
