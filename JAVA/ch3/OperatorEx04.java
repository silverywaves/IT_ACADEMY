package ch3;

public class OperatorEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = -10;
		i = +i;
		System.out.println(i);
		
		i = -10;
		i = -i;
		System.out.println(i);
	}

}
/*	부호 연산자 (+, -)
 * 		boolean 형, char 형을 제외한 기본형에만 사용 가능
 * 
 * 		'-' : 피연산자의 부호를 반대로 변경한 결과 반환
 * 				음수 -> 양수, 양수 -> 음수
 * 		'+' : 하는 일 없음. 쓰이는 경우 거의 x
 * */
