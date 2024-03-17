package ch7;

// 두 조상으로부터 상속받는 멤버 중 멤버변수의 이름이 같거나 메서드의 선언부가 일치하고 구현내용이 다르다면
// 이 두 조상으로부터 상속받는 자손클래스는 어느 조상의 것을 상속받게 되는 것인지 알 수 없음
// => 어느 한 쪽으로부터 상속을 포기하던가 이름이 충돌하지 않게 조상클래스를 변경해야 함
// => 다중상속은 단점이 더 커서 허용 X

// 인터페이스는 static 상수만 정의 가능 -> 조상클래스의 멤버변수와 충돌하는 경우는 거의 없고, 충돌되어도 클래스 이름을 붙여 구분 가능
// 추상메서드는 구현내용이 없어서 조상클래스의 메서드와 선언부가 일치하는 경우, 조상클래스 메서드를 상속받으면 되므로 문제 x
// => 상속받는 멤버 충돌은 막아도, 다중상속의 장점을 잃음
// => 두 조상클래스 중 비중이 높은 쪽을 상속받고, 다른 한쪽은 클래스 내부에 멤버로 포함

class Tv38{
	
	protected boolean power;
	protected int channel;
	protected int volume;
	
	public void power() {power = !power;}
	public void channelUp() {channel++;}
	public void channelDown() {channel--;}
	public void volumeUp() {volume++;}
	public void volumeDown() {volume--;}
}

class VCR38{
	protected int counter;	// VCR 카운터
	
	public void play() {
		// Tape 재생
	}
	
	public void stop() {
		// 재생 멈춤
	}
	
	public void reset() {
		counter = 0;
	}
	
	public int getCounter() {
		return counter;
	}
	
	public void setCounter(int c) {
		counter = c;
	}
}

interface IVCR{		// VCR 클래스에 정의된 메서드와 일치하는 추상메서드를 갖는 인터페이스 작성
	public void play();
	public void stop();
	public void reset();
	public int getCounter();
	public void setCounter(int c);
}

public class _38_TVCRTest_인터페이스다중상속 extends Tv38 implements IVCR {
// IVCR 인터페이스를 구현하고 Tv38 클래스로부터 상속받는 TVCR 클래스 작성
	// => VCR 클래스 타입의 참조변수를 멤버변수로 선언하여 IVCR 인터페이스 추상메서드 구현하는데 사용
	VCR38 vcr = new VCR38();
	
	public void play() {
		vcr.play();		// 코드를 작성하는 대신 VCR 인스턴스의 메서드 호출
	}
	public void stop() {
		vcr.stop();
	}
	public void reset() {
		vcr.reset();
	}
	public int getCounter() {
		return vcr.getCounter();
	}
	public void setCounter(int c) {
		vcr.setCounter(c);
	}

}
