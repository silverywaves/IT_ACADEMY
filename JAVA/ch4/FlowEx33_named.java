package ch4;

public class FlowEx33_named {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// for 문에 Loop1 이름 지정
		Loop1 : for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				if (j==5)
//					break Loop1;		// 2단 *4 까지만 출력 후 반복 종료
//					break;				// 2단 *4 까지 출력 후 종료(%n) -> for 문 반복 (반복되는 i 단들도 모두 *4 까지 출력)
//					continue Loop1;		// 2단 *4 까지 출력 후 for 문 반복 (반복되는 i 단들도 모두 *4 까지 출력)
					continue;			// *5 만 건너뛰고 모든 i 단 반복 출력
				System.out.println(i + "*" + j + "=" + i*j);
			}	// end of for i
			System.out.println();
		}	// end of Loop1
	}

}
/*	break 문은 근접한 단 하나의 반복문만 벗어남
 * 	-> 반복문이 중첩된 경우 완전히 벗어날 수 없음
 * 	-> 중첩 반복문 앞과 break 문 & continue 문에 이름을 붙여 반복을 벗어나거나 건너뛸 수 있음
 * */
