package Ch35;

// Main 클래스 정의
public class Main {
	
	// main 메서드 정의(프로그램 시작점)
	public static void main(String[] args) {
	
		Marine m1 = new Marine("m1",new Pistol());	// 이름이 "m1"인 Marine 객체 생성 -> Pistol을 무기로 설정 -> m1 변수에 할당
		Marine m2 = new Marine("m2",new Rifle());	// 이름이 "m2"인 Marine 객체 생성 -> Rifle을 무기로 설정 -> m2 변수에 할당
		
		m1.attack(m2);	// attack 메서드 호출 => m1 Marine 객체가 m2 Marine 객체를 공격
		
		System.out.println(m1);		// m1 Marine 객체의 정보 출력
		System.out.println(m2);		// m2 Marine 객체의 정보 출력
		
	}
	
}
