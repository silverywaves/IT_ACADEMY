package ch5;

public class ArrayEx16 {

	public static void main(String[] args) {
		// 문자열(String)을 모스부호(morse)로 변환
		String source = "SOSHELP";
		String[] morse = {
				".-", "-...", "-.-", "-..", ".",
				"..-.", "--.", "....", "..", "---",
				"-.-", ".-..", "--", "-.", "---",
				".--", "--.-", ".-.", "...", "-",
				"..-", "...-", ".--", "-..-", "-.--",
				"--.."
		};
		String result = "";
		
		for(int i=0; i<source.length(); i++) {
			result += morse[source.charAt(i) - 'A'];	// i 가 0일 때
//			result += morse[source.charAt(0) - 'A'];	// source.charAt(0) 은 첫번째 문자
//			result += morse['S' - 'A'];					// 'S' - 'A' -> 83 - 65 -> 18
//			result += morse[18];
//			result += "...";							// result = result + "..."; 와 같음
		}
		
		System.out.println("source:" + source);
		System.out.println("morse:" + result);

	}

}
