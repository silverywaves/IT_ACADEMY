package ch2;

public class SpecialCharEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char tab = '\t';			// 변수 tab 에 탭 문자를 저장
		System.out.println(tab);
		System.out.println("---------------");
		
		System.out.println('\'');
		System.out.println("abc\t123\b456");
		System.out.println('\n');
		System.out.println("\"HELLO\"");
		System.out.println("c:\\");
	}

}
/*	tab				\t
 * 	backspace		\b
 *  form feed		\f
 *  new line		\n
 *  carriage return	\r
 *  역슬래쉬(\)		\\
 *  작은따옴표		\'
 *  큰따옴표		\"
 *  유니코드문자	\ u   ex) char a='\u0041'
 * */
