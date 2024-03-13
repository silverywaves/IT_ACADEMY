package Ch13;

//class A{}
//class B{}
//class C extends A,B {}	// 다중상속 불가
// 다중상속 자체를 권장하진 않음(복잡도가 높아짐)

interface D{}
interface E{}

class F implements D,E {}	// 다중상속 가능

// class 일때는 다중상속 불가, interface 일때는 다중상속 가능
// 01
// interface 는 추상클래스보다 한단계 더 추상화된 클래스
//		-> abstract class 에는 추상메서드가 하나 이상 필요, 미리 구현된 메서드도 올 수 있음
//		-> interface 는 모든 메서드가 추상메서드
// interface 는 메서드가 정의되지 않았기 때문에, 메서드의 접근제어자나 리턴타입, 메서드명, 매개변수가 모두 동일한 메서드를
// 상속받아도 문제가 발생하지 않음 <- 해당 메서드는 아직 구현되지 않아 자식클래스에서 새롭게 정의해야하기 때문
// class 는 메서드의 접근제어자나 리턴타입, 메서드명, 매개변수가 모두 동일한 메서드를 상속받게된다면 어느 부모의 메서드를
// 상속받아야할지 파악 불가 <- 이미 구현된 메서드 상속 불가
// 02
// namespace 관련 이름충돌 여부

public class C04InterfaceMain {

	public static void main(String[] args) {
		
	}
}
