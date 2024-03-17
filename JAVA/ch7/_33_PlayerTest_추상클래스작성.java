package ch7;

// 추상 : 낱낱의 구체적 표상이나 개념에서 공통된 성질을 뽑아 이를 일반적인 개념으로 파악하는 정신 작용
// 추상화 : 클래스간의 공통점을 찾아내서 공통의 조상을 만드는 작업
// 구체화 : 상속을 통해 클래스를 구현, 확장하는 작업

// abstract 를 붙여 추상메서드로 선언하는 이유 : 자손클래스에서 추상메서드를 반드시 구현하도록 강요하기 위함

abstract class Player33{
	boolean pause;		// 일시정지 상태를 저장하기 위한 변수
	int currentPos;		// 현재 Play 되고 있는 위치를 저장하기 위한 변수
	
	// 생성자 <- 추상클래스도 생성자가 있어야 함
	Player33(){
		pause = false;
		currentPos = 0;
	}
	
	/* 지정된 위치(pos)에서 재생을 시작하는 기능이 수행하도록 작성되어야 함 */
	abstract void play(int pos);		// 추상메서드
	/* 재생을 즉시 멈추는 기능을 수행하도록 작성되어야 함 */
	abstract void stop();				// 추상메서드
	
	void play() {
		play(currentPos);			// 추상메서드 사용 가능
	}
	void pause() {
		if(pause) {					// pause 가 true 일 때, 정지상태에서 pause 가 호출되면
			pause = false;			// pause 의 상태를 false 로 바꾸고
			play(currentPos);		// 현재 위치에서 play 
		} else {					// pause 가 false 일 때, play 상태에서 pause 가 호출되면
			pause = true;			// pause 상태를 true 로 바꾸고
			stop();					// play 를 멈춤
		}
	}
}

class CDPlayer33 extends Player33{
	void play(int currentPos) {
		System.out.println("조상의 추상메서드 구현");
	}
	void stop() {
		System.out.println("조상의 추상메서드 구현");
	}
	
	// CDPlayer33 클래스에 추가로 정의된 멤버
	int currentTrack;		// 현재 재생중인 트랙
	
	void nextTrack() {
		currentTrack++;
	}
	void preTrack() {
		if(currentTrack>1) {
			currentTrack--;
		}
	}
}

public class _33_PlayerTest_추상클래스작성 {

}
