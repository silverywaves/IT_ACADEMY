package Ch10;

// class 단위로 배열 생성 - 실수가 많이 나옴. 주의하기
class C04Person{
	String name;
	int age;
	
	public C04Person() {}	// default 생성자
	// 생성자
	public C04Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	// toString
	@Override
	public String toString() {
		return "C04Person [name=" + name + ", age=" + age + "]";
	}
}


public class C04ClassArrayMain {

	public static void main(String[] args) { 
		C04Person list[] = new C04Person[3];	// 생성자 함수 사용 x => 참조배열 => 인스턴스 생성하지 않아 오류 발생
		list[0] = new C04Person();	// solution
		list[0].name = "홍길동";
		list[0].age = 55;

		list[1] = new C04Person();	// solution
		list[1].name = "김영희";
		list[1].age = 35;
		
		list[2] = new C04Person();	// solution
		list[2].name = "김법수";
		list[2].age = 40;
		
		// 잘못된 코드 why? => 형태는 갖춰져있지만 객체 공간이 없음 => list[0] = new C04Person(); 추가해야함
		// NullPointerException : 빈 공간에 작업하여 뜨는 오류
		
		for(C04Person obj : list) {
			System.out.println(obj);
		}
		
	}
}
