package Ch08;

// 생성자 메서드(함수=>오버로딩가능)
// 객체 생성시에 한 번 호출되는 특수한 메서드(-객체 생성 전에 이미 적재되어있음)
// 생성된 객체 내에서는 사용 불가
// 객체 생성시에 필요한 메모리공간 형성과 초기값 부여에 사용
// 클래스명과 동일, 반환자료형X
// 생성자 함수를 클래스 내에 명시하지 않으면 컴파일러에 의해서 주입되는 생성자가 있는데, 이를 디폴트 생성자라고 함
// 디폴트 생성자는 모든 멤버변수의 초기값을 0(or false-boolean 경우 or null-object 경우) 지정

class C08Simple{
	// 속성
	int n1;
	double n2;
	boolean n3;
	String n4;
	// 기능(생성자)
	C08Simple(){
		System.out.println("C08Simple() 호출");
		this.n1=100;
		this.n2=200.3;
		this.n3=true;
		this.n4="HI";
	}
	C08Simple(int n1){
		System.out.println("C08Simple(int n1) 호출");
		this.n1 = n1;
	}
	C08Simple(int n1, double n2){
		System.out.println("C08Simple(int n1, double n2) 호출");
		this.n1 = n1;
		this.n2 = n2;
	}
	C08Simple(int n1, double n2, boolean n3){
		System.out.println("C08Simple(int n1, double n2, boolean n3) 호출");
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
	}
	// Builder 패턴
	// 자동 생성 => 우클릭->source->generate constructor using field
	public C08Simple(int n1, double n2, boolean n3, String n4) {
		super();
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		this.n4 = n4;
	}
	
}

public class C08ConstructorMain {

	public static void main(String[] args) {
		C08Simple ob = new C08Simple();
		System.out.printf("%d %f %b %s\n", ob.n1, ob.n2, ob.n3, ob.n4);
		C08Simple ob2 = new C08Simple(111);
		C08Simple ob3 = new C08Simple(111,222.4);
		C08Simple ob4 = new C08Simple(111,222.4,false);		
	}

}
