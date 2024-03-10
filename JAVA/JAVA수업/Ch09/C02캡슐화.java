package Ch09;

// 캡슐화
// 특정 목적을 가지는 기능을 구현하는데 필요한 세부 기능들을 묶어서 처리하는 방법
// 특정 목적을 가지는 기능 구현에 있어서 각 과정의 일부나 전부가 외부로 노출되는 문제 막기 위해 정보은닉 수반(필수 x)
// 캡슐화 작업은 각 공정과정에 대한 정확한 이해가 수반되어야 함(작업 공정의 순서 중요)

class Engine{
	private void 흡입() {System.out.println("외부로부터 공기를 빨아들인다.");}
	private void 압축() {System.out.println("가둔 공기를 압축시킨다.");}
	private void 폭발() {System.out.println("일정 수준 압축되면 폭발한다.");}
	private void 배기() {System.out.println("가스를 외부로 내보낸다.");}
	// 기능을 외부에서 볼수는 없지만 버튼을 퍼블릭하게 만들어 자동차와 연결 
	public void EngineStart() {
		// 캡슐화
		흡입();
		압축();
		폭발();
		배기();
	}
}

class Car{
	Engine engine;
	Car(){
		engine = new Engine();
	}
	void run() {
		// Engine 의 start 버튼 실행
		engine.EngineStart();
	}
}

public class C02캡슐화 {

	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.run();
	}

}
