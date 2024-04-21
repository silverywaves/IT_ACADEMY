package C03;

public class SimpleDto {	// SimpleDto 클래스 선언(간단한 데이터 전송 객체(DTO)로 사용)

	// 클래스의 멤버 변수들 선언 => 이름(name), 나이(age), 주소(addr) 정보 저장
	private String name;
	private int age;
	private String addr;

	// toString => 객체의 정보를 문자열로 반환
	@Override
	public String toString() {
		return "SimpleDto [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	// 모든 인자 생성자(객체를 생성할 때 필요한 모든 정보를 인자로 받아 멤버 변수들 초기화)
	public SimpleDto(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

}
