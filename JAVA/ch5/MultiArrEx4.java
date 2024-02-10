package ch5;

import java.util.*;

public class MultiArrEx4 {

	public static void main(String[] args) {
		// 영어 단어를 보여주고 뜻을 맞추는 게임
		String[][] words = {
				{"chair", "의자"},		// words[0][0] words[0][1]
				{"computer", "컴퓨터"},	// words[1][0] words[1][1]
				{"integer", "정수"}		// words[2][0] words[2][1]
		};
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0; i<words.length; i++) {
			System.out.printf("Q%d. %s의 뜻은?", i+1, words[i][0]);	// words[i][0] => 문제 => 화면 출력
			String tmp = scanner.nextLine();	// 입력받은 답은 tmp 에 저장
			if(tmp.equals(words[i][1])) {		// words[i][1] => 답 / equals() 로 tmp 와 words[i][1] 문자열 비교
				System.out.printf("정답입니다. %n%n");
			} else {
				System.out.printf("틀렸습니다. 정답은 %s입니다. %n%n", words[i][1]);
			}
		}	// end of for
	}	// end of main

}
