package Ch15;

public class C01NullPointerExceptionMain {

	public static void main(String[] args) {
		
		try {
			String str=null;
			System.out.println(str.toString());
		// 예외 발생 : Cannot invoke "String.toString()" because "str" is null -> try{}로 예외발생예상부분 묶음
		} catch(NullPointerException e) {	// catch(발생오류, 참조변수)
//			System.out.println("예외발생" + e);
//			System.out.println(e.getCause());
//			System.out.println(e.toString());
//			System.out.println(e.getStackTrace());	// 예외 발생 부분만 출력
//			e.printStackTrace();	// 예외발생 당시의 호출스택(Call Stack)의 메서드정보 & 예외결과 모두 출력
									// 성능 중시할 경우 사용 지양
									// 	- System.err 로 쓰여지게 되면서 제어하기 힘들고 리소스 비용 비쌈
									//	- 보존 정책 설정 x, 보안성 떨어짐(메서드 내부 동작구조 노출)
									//	- 오버헤드 많이 발생 (Reflection 사용하여 예외 추적)
									//  - 서버 부하 원인 (서버에서 메서드 스택정보 취합)
									//	- 출력이 어디로 향하는지 파악 어려움(System.err 는 System.setErr()를 통해 변경될 수 있음)
									//	- 관리 어려움
		}
		
		System.out.println("HELLOWORLD");
	}
}
