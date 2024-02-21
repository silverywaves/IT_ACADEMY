package ch6;

class Car3{
	String color;		// 색상
	String gearType;	// 변속기 종류 = auto(자동), manual(수동)
	int door;			// 문의 개수
	
	Car3(){
		this("white", "auto", 4);	
	}				
	
	Car3(Car3 c){		// 인스턴스 복사를 위한 생성자
		color = c.color;
		gearType = c.gearType;
		door = c.door;
//		this(c.color, c.gearType, c.door);  이 방법이 더 바람직함. 무작정 새 코드를 작성하기보단 기존 코드 활용을 고민해야함
	}
	
	Car3(String color, String gearType, int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}

public class _27_CarTest3_생성자로_인스턴스복사 {

	public static void main(String[] args) {
		Car3 c1 = new Car3();
		Car3 c2 = new Car3(c1);	// c1의 복사본 c2를 생성
		System.out.println("c1의 color = " + c1.color + ", c1의 gearType = " + c1.gearType + ", c1의 door = " + c1.door);
		System.out.println("c2의 color = " + c2.color + ", c1의 gearType = " + c2.gearType + ", c1의 door = " + c2.door);
		
		c1.door = 100;	// c1 의 인스턴스변수 door 의 값 변경
		System.out.println("v1.door=100; 수행 후");
		System.out.println("c1의 color = " + c1.color + ", c1의 gearType = " + c1.gearType + ", c1의 door = " + c1.door);
		System.out.println("c2의 color = " + c2.color + ", c1의 gearType = " + c2.gearType + ", c1의 door = " + c2.door);	
		// 인스턴스 c2는 c1을 복사하여 생성된 것이라 서로 같은 상태를 갖지만, 서로 독립적으로 메모리 공간에 존재하는 별도의 인스턴스
		// => c1 값이 변경되어도 c2 는 영향받지 않음
	}

}
/*	인스턴스 생성시 결정 사항
 * 		- 클래스 : 어떤 클래스의 인스턴스를 생성할 것인가?
 * 		- 생성자 : 선택한 클래스의 어떤 생성자로 인스턴스를 생성할 것인가?
 * */

