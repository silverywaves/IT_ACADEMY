package ch7;

public class _18_TimeTest_접근제어자 {

	public static void main(String[] args) {
		Time t = new Time(12, 35, 30);
		System.out.println(t);
//		t.hour = 13;		// Error : The field Time.hour is not visible
							// => 변수 hour 의 접근제어자가 private 이므로 직접적인 접근 불가
		t.setHour(t.getHour()+1);	// 현재시간보다 1시간 후로 변경
		System.out.println(t);		// = System.out.println(t.toString());
	}
}

class Time{		// Time 클래스의 모든 멤버변수의 접근제어자를 private 으로 설정
	private int hour, minute, second;
	
	Time(int hour, int minute, int second){
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}
	// Time 클래스의 멤버변수들을 다루기 위한 public 메서드 추가
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		if(hour<0 || hour>23) return;
		this.hour = hour;
	}
	
	public int getMinute() {
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
	
	public String toString() {
		return hour + ":" + minute + ":" + second;
	}
}