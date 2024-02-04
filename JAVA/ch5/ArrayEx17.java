package ch5;

public class ArrayEx17 {

	public static void main(String[] args) {
		// 커맨드라인을 통해 입력받기
		// Run -> Run Configurations -> Arguments -> 매개값 입력
		// C:\Users...[클래스이름.java의 경로]>java 클래스이름.java+공백+문자열
		// C:\Users\admin\Desktop\이클립스\Java\src\ch5>java ArrayEx17.java 123 abc "Hello world"
		if(args != null) {		// args 가 null 이 아닐 때만 괄호 {}의 문장들을 수행
		System.out.println("매개변수의 개수:" + args.length);
		for(int i=0; i<args.length; i++) {
			System.out.println("args[" + i + "] = \"" + args[i] + "\"");
		}
		}
		
	}

}
