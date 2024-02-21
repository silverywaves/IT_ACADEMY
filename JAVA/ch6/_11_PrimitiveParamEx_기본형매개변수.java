package ch6;

class Data{int x;}

public class _11_PrimitiveParamEx_기본형매개변수 {

	public static void main(String[] args) {
		Data d= new Data();
		d.x = 10;
		System.out.println("main() : x = " + d.x);
		
		change(d.x);
		System.out.println("After change(d.x)");
		System.out.println("main() : x = " + d.x);	// 2. => main 메서드의 d.x 값 그대로 10
	}
	
	static void change(int x) {
		x= 1000;	// 1. main 메서드로부터 넘겨받은 d.x 값을 1000으로 변경
		System.out.println("change() : x = " + x);	
	}	// 3. change 메서드가 종료되면서 매개변수 x 는 스택에서 제거되었기 때문!
		// => 즉, 복사본이 변경된 것이라 원본에 영향 x. 저장된 값을 읽기만 할 뿐 변경 불가
}	

/*	- 기본형 매개변수(primitive type) : 기본형 값 복사 -> 변수의 값을 읽기만 할 수 있음 (read only)
 * 	- 참조형 매개변수(reference type) : 인스턴스 주소 복사 -> 변수의 값을 읽고 변경 가능 (read & write)
 * */
