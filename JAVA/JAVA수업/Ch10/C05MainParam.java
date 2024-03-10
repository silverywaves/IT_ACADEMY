package Ch10;

public class C05MainParam {

	public static void main(String[] args) {
		System.out.println("파라미터 배열 길이 : " + args.length);	// 0 <- 현재 받은 값 없음
		// 우클릭 -> RunAs -> configuration -> argument => 문자열입력(띄어쓰기 기준으로 배열생성)
		for(String param : args) {
			System.out.println(param);
		}
	}
}

/* cmd 로도 추가는 가능 */
