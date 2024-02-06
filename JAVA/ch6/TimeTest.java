package ch6;

public class TimeTest {

	private int hour;
	private int minute;
	private float second;
	
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public float getSecond() {
		return second;
	}
	
	public void setHour(int h) {
		if (h<0 || h>23) return;	// 시의 범위 0~23
		hour = h;
	}
	
	public void setMinute(int m) {
		if (m<0 || m>59) return;	// 분의 범위 0~59
		minute = m;
	}
	
	public void setSecond(int s) {
		if (s<0 || s>59) return;	// 초의 범위 0~59
		second = s;
	}


}

/*	프로그래밍적 관점의 클래스
 * 		- 데이터와 함수의 결합(구조체 + 함수)
 * 		- 사용자정의 타입
 * 			: 프로그래밍언어에서 제공하는 자료형 외에 프로그래머가 
 * 			  서로 관련된 변수들을 묶어서 하나의 타입으로 새로 추가하는 것
 * 
 * 	- 변수 : 하나의 데이터를 저장할 수 있는 공간
 * 	- 배열 : 같은 종류의 여러 데이터를 하나의 집합으로 저장할 수 있는 공간
 * 	- 구조체 : 서로 관련된 여러 데이터를 종류에 관계없이 하나의 집합으로 저장할 수 있는 공간
 * */

