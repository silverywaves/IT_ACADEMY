package ch3;

public class OperatorEx15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char lowerCase = 'a';
		char upperCase = (char)(lowerCase - 32);	// char - int = int 
													// => 연산 후 char 형으로 다시 형변환
		System.out.println(upperCase);
	}

}
// 대문자와 소문자 간의 코드값 차이는 10진수로 32