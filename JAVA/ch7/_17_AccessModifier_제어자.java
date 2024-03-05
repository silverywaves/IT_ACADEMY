package ch7;

public class _17_AccessModifier_제어자 {
	// ------ 접근 제어자를 private 로 하여 외부에서 직접 접근하지 못하도록 함 --------
	private int hour;
	private int minute;
	private int second;
	// ---------------------------------------------------------------
	public int getHour() {				// get~ : 단순히 멤버변수의 값을 반환
		return hour;
	}
	public void setHour(int hour) {		// set~ : 매개변수에 지정된 값을 검사하여 조건에 맞는 값일 때만 
		if(hour<0 || hour>23) return;	// 		  멤버변수의 값을 변경하도록 작성
		this.hour = hour;
	}
	
	public int getMionute() {
		return minute;
	}
	public void setMinute(int minute) {
		if(minute<0 || minute>59) return;
		this.minute = minute;
	}
	
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		if(second<0 || second>59) return;
		this.second = second;
	}
	
}
/*	접근제어자(access modifier)
 * 	- 사용될 수 있는 곳 : 클래스, 멤버변수, 메서드, 생성자
 * 		- private : 같은 클래스 내에서만 접근 가능
 * 		- default : 같은 패키지 내에서만 접근 가능
 * 		- protected : 같은 패키지 내에서 & 다른 패키지의 자손클래스에서 접근 가능
 * 		- public : 접근 제한 X
 * */

/*	접근제어자를 이용한 캡슐화
 * 	- 외부로부터 데이터를 보호하기 위함
 * 	- 외부에는 불필요한, 내부적으로만 사용되는 부분을 감추기 위함 (복잡성 줄임)
 * */
