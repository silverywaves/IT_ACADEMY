package ch6;

//class Data{
//	int x;
//}

public class _12_ReferenceParamEx_참조형매개변수 {

	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x = " + d.x);
		
		change(d);
		System.out.println("After change(d)");
		System.out.println("main() : x = " + d.x);
	}

	static void change(Data d) {	// 참조형 매개변수 -> 매개변수 d 에 저장된 주소값으로 x 에 접근 가능
		d.x = 1000;					// 매개변수 d 로 x 의 값을 1000 으로 변경
		System.out.println("change() : x = " + d.x);
	}	// change 메서드가 종료되면서 매개변수 d 는 스택에서 제거됨
}
