package Ch09;

// 정보은닉 != 캡슐화 (캡슐화 과정에서 정보은닉을 수반한다-단, 필수조건은 아님)

// 접근 한정자
// 멤버/클래스의 접근 범위 제한을 위한 예약어
// public		: 모든 클래스에서 접근 가능
// private		: 해당 클래스에서만 접근 가능
// protected	: 상속 관계를 가지는 경우에 접근 가능
// default(기본) : 동일 패키지에 속한 클래스에서 접근 가능

// 일반인
// 이름		// 공개가능	// 수정여부 o
// 나이		// 공개가능	// 수정여부 o
// 주소		// 비공개		// 수정여부 o
// 성별		// 공개가능	// 수정여부 x
// 학력		// 비공개		// 수정여부 o
// 연봉		// 비공개		// 수정여부 o
// 주민번호	// 비공개		// 수정여부 x
// ...

// 연예인
// 이름		// 비공개		// 수정여부 o
// 나이		// 비공개		// 수정여부 o
// 주소		// 비공개		// 수정여부 o
// 성별		// 공개가능	// 수정여부 x
// 학력		// 비공개		// 수정여부 o
// 연봉		// 비공개		// 수정여부 o
// 주민번호	// 비공개		// 수정여부 x
//...

class C01Person{		// 기본적으로 default 한정자 들어가있음
	private String name;	// 특정 함수로만 접근 가능 => 접근 함수 getter/setter 생성
	private int age;
	private String addr;
	
	public C01Person(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	// getter : 조회
	String getName() {
		return this.name;
	}
	// setter : 수정
	void setAge(int age) {
		this.age = age;
	}
	// 자동생성 => 우클릭->source->generate getter and setter
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
//	@Override	// 주석처리 안하면 모두 출력됨
//	public String toString() {
//		return "C01Person [name=" + name + ", age=" + age + ", addr=" + addr + "]";
//	}
	
}

public class C01정보은닉 {

	public static void main(String[] args) {
		C01Person ob1 = new C01Person("윤정한", 30, "서울");
		System.out.println(ob1.getName());
		ob1.setAge(32);		// getter 함수 만들기 전에는 바로 조회 불가
	}

}
