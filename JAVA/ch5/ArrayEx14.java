package ch5;

public class ArrayEx14 {

	public static void main(String[] args) {
		// 16진수를 2진수로 변환
		char[] hex = {'C', 'A', 'F', 'E'};		// 16진수에는 A~F 6개의 문자 포함되어 char 배열로 처리
		
		String[] binary = {		// 2진수 16개의 값 문자열로 저장
				"0000", "0001", "0010", "0011",
				"0100", "0101", "0110", "0111",
				"1000", "1001", "1010", "1011",
				"1100", "1101", "1110", "1111"
		};
		
		String result = "";
		
		for(int i=0; i<hex.length; i++) {		// 배열 hex 에 저장된 문자를 하나씩 읽어서 그에 해당하는 이진수 표현을 배열 binary 에서 얻어
			if(hex[i]>'0' && hex[i]<='9') {		// result 에 덧붙이고 그 결과를 화면에 출력
				result += binary[hex[i] - '0'];			// '8' - '0' 의 결과는 8
			} else {
				result += binary[hex[i] - 'A' + 10];	// 'C' - 'A' 의 결과는 2
				// result += binary[hex[0] - 'A' + 10];	// hex[0] 은 'C'
				// result += binary['C' - 'A' + 10];	// 'C' - 'A' -> 67 - 65 -> 2
				// result += binary[2+10];
				// result += binary[12];
				// result += "1100";
			}
		}
		
		System.out.println("hex:" + new String(hex));
		System.out.println("binary:" + result);
	}

}
