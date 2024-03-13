package Ch13;

interface Remocon{
	// 속성
	int MAXVOL = 100;	// 최대볼륨
	int MINVOL = 0;		// 최소불륨
	// 추상메서드
	void on();		// 전원 켜기
	void off();		// 전원 끄기
	void setVolume(int vol);
}

interface Browser{
	void SearchURL(String url);
}

class TV implements Remocon {	// implements : 구현하다 => 반드시 재정의해야함(강제성이 높음)
	private int vol;
	@Override
	public void on() {
		System.out.println("TV를 켭니다");
		
	}

	@Override
	public void off() {
		System.out.println("TV를 끕니다");
		
	}

	@Override
	public void setVolume(int vol) {
		if(vol>=MAXVOL)
			this.vol = MAXVOL;
		else if(vol<=MINVOL)
			this.vol=MINVOL;
		else
			this.vol = vol;
		System.out.println("현재  TV Volume : " + this.vol);
	}
}
class SmartTv extends TV implements Browser {

	@Override
	public void SearchURL(String url) {
		System.out.println(url + "로 이동합니다");
	}
	
}

class Radio implements Remocon {

	private int vol;

	@Override
	public void on() {
		System.out.println("Radio를 켭니다");
	}

	@Override
	public void off() {
		System.out.println("Radio를 끕니다");
	}

	@Override
	public void setVolume(int vol) {
		if(vol>=MAXVOL)
			this.vol = MAXVOL;
		else if(vol<=MINVOL)
			this.vol=MINVOL;
		else
			this.vol = vol;
		System.out.println("현재 Radio Volume : " + this.vol);		
	}
	
}

public class C02InterfaceMain {

	public static void TurnOn(Remocon remocon) {
		remocon.on();
	}
	
	public static void TurnOff(Remocon remocon) {
		remocon.off();
	}
	public static void Volumn(Remocon remocon, int vol) {
		remocon.setVolume(vol);
	}
	public static void BrowerSearch(Browser searchUrl, String url) {
		searchUrl.SearchURL(url);
	}
	
	public static void main(String[] args) {
		TV tv1 = new TV();
		Radio radio1 = new Radio();
		
		SmartTv smartTv = new SmartTv();
		TurnOn(smartTv);
		Volumn(smartTv, 50);
		BrowerSearch(smartTv, "www.naver.com");
		
//		TurnOn(tv1);
//		Volumn(tv1, 10);
//
//		TurnOn(radio1);
//		Volumn(tv1, 105);
//		
//		TurnOff(tv1);
//		TurnOff(radio1);
	}
}


// 인터페이스는 기본 public 
// 인터페이스 용도 : 낮은 결합도 -> 모듈화 -> 유지보수
//				=> 코드 자체는 늘어나지만, 프로젝트 규모가 커졌을 때 범위별로 분리되어 편리해짐
