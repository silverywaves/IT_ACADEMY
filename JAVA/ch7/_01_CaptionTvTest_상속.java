package ch7;

class Tv{
	boolean power;	// 전원상태(on/off)
	int channel;	// 채널
	
	void power() {power = !power;}
	void channelUp() {++channel;}
	void channelDown() {--channel;}
}

class CaptionTv extends Tv{
	boolean caption;	// 캡션상태(on/off)
	void displayCaption(String text){
		if(caption){	// 캡션상태가 on(true)일때만 text 출력
			System.out.println(text);
		}
	}
}

public class _01_CaptionTvTest_상속 {

	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 10;		// 조상 클래스로부터 상속받은 멤버
		ctv.channelUp();		// 조상 클래스로부터 상속받은 멤버
		System.out.println(ctv.channel);
		ctv.displayCaption("Hello, World");
		ctv.caption = true;		// 캡션(자막) 기능을 켬
		ctv.displayCaption("Hello, World");
	}

}	// 자손클래스 인스턴스 생성 = 조상클래스 멤버 + 자손클래스 멤버

/*	상속(inheritance)
 * 		- 기존 클래스를 재사용하여 새로운 클래스 작성
 * 			=> 적은 양의 코드로 새로운 클래스 작성 가능, 공동관리로 인한 수정 용이
 * 			=> 재사용성, 중복제거, 생산성, 유지보수
 * 
 * 		- 새로 작성하고자 하는 클래스 이름 뒤에 상속받고자하는 클래스이름을 키워드'extends'와 함께 작성
 * 			=> extends : 상속을 거듭할수록 상속받는 클래스의 멤버개수는 늘어나기 때문
 * 
 * 			=> class 자손클래스 extends 조상클래스
 * 		- 조상클래스 : 상속해주는 클래스 / 부모(parent)클래스, 상위(super)클래스, 기반(base)클래스
 * 		- 자손클래스 : 상속 받는 클래스 / 자식(child)클래스, 하위(sub)클래스, 파생된(derived)클래스
 * 
 * 		- 생성자와 초기화 블럭은 상속X / 멤버만 상속
 * 		- 자손 클래스 멤버개수 >= 조상 클래스 멤버개수
 * */

