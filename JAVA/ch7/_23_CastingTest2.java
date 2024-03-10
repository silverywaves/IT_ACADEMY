package ch7;

public class _23_CastingTest2 {

	public static void main(String[] args) {
		Car car = new Car();
		Car car2 = null;
		FireEngine fe = null;
		
		car.drive();
		fe = (FireEngine)car;		// 컴파일 ok, 실행시 Error => 형변환 오류
		// 캐스트 연산자를 이용해서 조상타입의 참조변수를 자손타입의 참조변수로 형변환했지만,
		// 참조변수 car 가 참조하고 있는 인스턴스가 Car 타입의 인스턴스라 문제 발생
		// -> 조상타입의 인스턴스를 자손타입의 참조변수로 참조 불가
		// -> solution : Car car = new FireEngine(); 으로 변경
		fe.drive();
		car2 = fe;
		car2.drive();
	}
}
/*	서로 상속관계에 있는 타입간의 형변환은 양방향으로 자유롭게 수행 가능
 *  단, 참조변수가 가리키는 인스턴스의 자손타입으로는 형변환 불가
 *  => 참조변수가 가리키는 인스턴스의 타입이 무엇인지 확인 필요
 * */
