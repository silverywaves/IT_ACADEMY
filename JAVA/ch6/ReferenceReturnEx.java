package ch6;

//class Data{int x}

public class ReferenceReturnEx {

	public static void main(String[] args) {
		// 매개변수뿐만 아니라 반환타입도 참조형 가능 => 메서드가 객체의 주소 반환
		Data d= new Data();
		d.x = 10;
		
		Data d2 = copy(d);		// 메서드 반환타입 : Data -> 호출결과를 저장하는 변수타입 : Data 타입의 참조변수 
		System.out.println("d.x = " + d.x);
		System.out.println("d2.x = " + d2.x);
	}
	
	static Data copy(Data d) {
		Data tmp = new Data();	// 새로운 객체 tmp 생성
		tmp.x = d.x;			// d.x 의 값을 tmp.x 에 복사
		
		return tmp;				// 복사한 객체의 주소 반환
	}

}
